package com.acmefresh.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import com.acmefresh.exception.UserException;
import com.acmefresh.model.Address;
import com.acmefresh.model.AdminSession;
import com.acmefresh.model.User;
import com.acmefresh.model.UserSession;
import com.acmefresh.repository.AddressDao;
import com.acmefresh.repository.AdminSessionDao;
import com.acmefresh.repository.UserDao;
import com.acmefresh.repository.UserSessionDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AddressDao addressDao;
	
	@Autowired
	private UserSessionDao userSessionDao;
	
	@Autowired
	private AdminSessionDao adminSessionDao;

	@Override
	public User saveUser(User user) throws UserException {
		// TODO Auto-generated method stub
		String email = user.getEmail();
		Long phone = user.getPhone();
		User existingUser = userDao.findByEmail(email);
		if(String.valueOf(phone).length()==10) {
			if(existingUser==null) {
				return userDao.save(user);
			}
			else {
				throw new UserException("User already exists with email : "+email);
			}
		}
		else {
			throw new UserException("Phone number must be 10 digits");
		}
	}

	@Override
	public Address saveAddress(@Valid Address address) throws UserException {
		// TODO Auto-generated method stub
		
		return addressDao.save(address);
	}

	@Override
	public UserSession saveLogin(User user) throws UserException {
		// TODO Auto-generated method stub
		String email = user.getEmail();
		String password = user.getPassword();
		User existingUser = userDao.findByEmail(email);
		if(existingUser==null) {
			throw new UserException("Invalid login credentials");
		}
		else {
			Integer userId = existingUser.getUserId();
			Optional<UserSession> session = userSessionDao.findByUserId(userId);
			if(session.isPresent()) {
				throw new UserException("User already logged in");
			}
			String existingPassword = existingUser.getPassword();
			if(password.equals(existingPassword)) {
				String key = getRandomString(6);
				LocalDateTime localDateTime = LocalDateTime.now();
				UserSession userSession = new UserSession(existingUser.getUserId(),key,localDateTime);
				userSessionDao.save(userSession);
				return userSession;
			}
			else {
				throw new UserException("Wrong password");
			}
		}
	}
	
	public String getRandomString(int n) {
		String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz0123456789";
		String randomString = "";
		
		for(int i=0; i<n; i++) {
			int index = (int) ((Math.random()*str.length()));
			randomString = randomString + str.charAt(index);
		}
		return randomString;
	}

	@Override
	public User updateUser(User user, String key) throws UserException {
		// TODO Auto-generated method stub
		Optional<UserSession> session = userSessionDao.findByUuid(key);
		
		if(session.isPresent()) {
			UserSession existingSession = session.get();
			Integer existingUserId = existingSession.getUserId();
			Integer userId = user.getUserId();
			if(existingUserId==userId) {
				return userDao.save(user);
			}
			else {
				throw new UserException("Invalid User");
			}
		}
		else {
			throw new UserException("Invalid User");
		}
	}

	@Override
	public List<User> getAllUsers(String key) throws UserException {
		// TODO Auto-generated method stub
		Optional<AdminSession> session = adminSessionDao.findByUuid(key);
		if(session.isEmpty()) {
			throw new UserException("Only admin can access this data");
		}
		List<User> users = userDao.findAll();
		if(users.size()>0) {
			return users;
		}
		else {
			throw new UserException("No users found");
		}
	}

	@Override
	public String deleteSession(String key) throws UserException {
		// TODO Auto-generated method stub
		Optional<UserSession> opt = userSessionDao.findByUuid(key);
		if(opt.isPresent()) {
			UserSession session = opt.get();
			userSessionDao.deleteById(session.getSessionId());
			return "Logged out successfully";
		}
		else {
			throw new UserException("Invalid User");
		}
	}

	

}
