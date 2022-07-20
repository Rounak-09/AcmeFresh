package com.acmefresh.service;

import java.util.List;

import javax.validation.Valid;

import com.acmefresh.exception.UserException;
import com.acmefresh.model.Address;
import com.acmefresh.model.User;
import com.acmefresh.model.UserSession;

public interface UserService {

	public User saveUser(User user)throws UserException;

	public Address saveAddress(@Valid Address address)throws UserException;

	public UserSession saveLogin(User user) throws UserException;

	public User updateUser(User user, String key)throws UserException;
	
	public List<User> getAllUsers(String key) throws UserException;

	public String deleteSession(String key)throws UserException;
}
