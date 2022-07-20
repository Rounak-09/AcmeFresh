package com.acmefresh.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.acmefresh.model.Cart;
import com.acmefresh.model.User;
import com.acmefresh.model.Vegetable;
import com.acmefresh.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/users/cart")
	public ResponseEntity<Cart> saveCartHandler(@Valid @RequestBody Cart cart, @RequestHeader String key){
			
		Cart savedCart = cartService.saveCart(cart,key);
		return new ResponseEntity<Cart>(savedCart,HttpStatus.CREATED);
	}
	
	@PutMapping("/users/cart")
	public ResponseEntity<Cart> updateCartHandler(@RequestBody Cart cart, @RequestHeader String key){
			
		Cart updatedCart = cartService.updateCart(cart,key);
		return new ResponseEntity<Cart>(updatedCart,HttpStatus.CREATED);
	}
	
	@GetMapping("/users/cart")
	public ResponseEntity<List<Cart>> getAllCartHandler(@RequestHeader String key){
			
		List<Cart> cartItems = cartService.getallCartItems(key);
		return new ResponseEntity<List<Cart>>(cartItems,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/users/cart")
	public ResponseEntity<String> deleteCartHandler(@RequestBody Cart cart, @RequestHeader String key){
			
		cartService.deleteCart(cart,key);
		return new ResponseEntity<String>("Cart item deleted",HttpStatus.CREATED);
	}
}
