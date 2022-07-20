package com.acmefresh.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.acmefresh.model.Address;
import com.acmefresh.model.User;
import com.acmefresh.model.UserSession;
import com.acmefresh.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/users/signup")
	public ResponseEntity<User> saveUserHandler(@Valid @RequestBody User user){
			
		User savedUser = userService.saveUser(user);
		return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
	}
	
	@PostMapping("/users/addresses")
	public ResponseEntity<Address> saveAddressHandler(@Valid @RequestBody Address address){
			
		Address savedAddress = userService.saveAddress(address);
		return new ResponseEntity<Address>(savedAddress,HttpStatus.CREATED);
	}
	
	@PostMapping("/users/login")
	public ResponseEntity<UserSession> getUserHandler(@RequestBody User user){
		
		UserSession userLoggedin = userService.saveLogin(user);
		return new ResponseEntity<UserSession>(userLoggedin,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/users/update")
	public ResponseEntity<User> updateUserHandler(@RequestBody User user,@RequestHeader String key){
		
		User updatedUser = userService.updateUser(user, key);
		return new ResponseEntity<User>(updatedUser,HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/users/logout")
	public ResponseEntity<String> deleteUserSessionHandler(@RequestHeader String key){
		userService.deleteSession(key);
		return new ResponseEntity<String>("Logged out successfully",HttpStatus.ACCEPTED);
	}
}
