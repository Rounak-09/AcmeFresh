package com.acmefresh.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.acmefresh.model.User;

public interface UserDao extends JpaRepository<User, Integer> {

	public User findByPhone(Long phone);
	
	public User getByUserId(Integer userId);

}
