package com.acmefresh.service;

import java.util.List;

import javax.validation.Valid;

import com.acmefresh.exception.CartException;
import com.acmefresh.model.Cart;
import com.acmefresh.model.Vegetable;

public interface CartService {

	public Cart saveCart(@Valid Cart cart, String key) throws CartException;

	public Cart updateCart(Cart cart, String key) throws CartException;

	public List<Cart> getallCartItems(String key) throws CartException;

	public void deleteCart(Cart cart, String key) throws CartException;

}
