package com.acmefresh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmefresh.model.UserSession;

public interface UserSessionDao extends JpaRepository<UserSession, Integer>{

	public Optional<UserSession> findByUserId(Integer userId);
	public Optional<UserSession> findByUuid(String uuid);
	public String deleteByUuid(String uuid);
}
