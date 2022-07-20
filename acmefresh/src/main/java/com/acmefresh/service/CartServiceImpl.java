package com.acmefresh.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmefresh.exception.CartException;
import com.acmefresh.model.Cart;
import com.acmefresh.model.UserSession;
import com.acmefresh.model.Vegetable;
import com.acmefresh.repository.CartDao;
import com.acmefresh.repository.UserSessionDao;
import com.acmefresh.repository.VegetableDao;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private UserSessionDao userSessionDao;
	
	@Autowired
	private VegetableDao vegetableDao;

	@Override
	public Cart saveCart(@Valid Cart cart, String key) throws CartException {
		// TODO Auto-generated method stub
		Optional<UserSession> session  = userSessionDao.findByUuid(key);
		if(session.isPresent()) {
			Optional<Vegetable> existingvegetable = vegetableDao.findByVegetableId(cart.getVegetableId());
			if(existingvegetable.isPresent()) {
				Optional<Cart> opt = cartDao.findByVegetableId(cart.getVegetableId());
				if(opt.isPresent()) {
					Cart existingCart = opt.get();
					Integer quantity = existingCart.getQuantity();
					existingCart.setQuantity(quantity+1);
					existingCart.setTotal(existingCart.getPrice()*existingCart.getQuantity());
					return cartDao.save(existingCart);
				}
				cart.setQuantity(1);
				cart.setTotal(cart.getPrice()*cart.getQuantity());
				return cartDao.save(cart);
			}
			throw new CartException("Vegetable not found");
		}
		throw new CartException("Try login first");
	}

	@Override
	public Cart updateCart(Cart cart, String key) throws CartException {
		Optional<UserSession> session  = userSessionDao.findByUuid(key);
		if(session.isPresent()) {
			Optional<Vegetable> existingvegetable = vegetableDao.findByVegetableId(cart.getVegetableId());
			if(existingvegetable.isPresent()) {
				Optional<Cart> opt = cartDao.findByCartId(cart.getCartId());
				if(opt.isPresent()) {
					if(cart.getQuantity()<=0) {
						cartDao.delete(cart);
						throw new CartException("Vegetable deleted from cart");
					}
					cart.setTotal(cart.getPrice()*cart.getQuantity());
					return cartDao.save(cart);
				}
				throw new CartException("Vegetable not found in cart");
			}
			throw new CartException("Vegetable not found");
		}
		throw new CartException("Try login first");
	}

	@Override
	public List<Cart> getallCartItems(String key) throws CartException {
		Optional<UserSession> session  = userSessionDao.findByUuid(key);
		if(session.isPresent()) {
			List<Cart> list = cartDao.findAll();
			if(list.size()>0) {
				return list;
			}
			throw new CartException("Cart is empty");
		}
		throw new CartException("Try login first");
	}

	@Override
	public void deleteCart(Cart cart, String key) throws CartException {
		Optional<UserSession> session  = userSessionDao.findByUuid(key);
		if(session.isPresent()) {
			Optional<Cart> opt = cartDao.findByCartId(cart.getCartId());
			if(opt.isPresent()) {
				cartDao.delete(cart);
				return;
			}
			throw new CartException("Vegetable not found in cart");
		}
		throw new CartException("Try login first");
		
	}
	
	

	

}
