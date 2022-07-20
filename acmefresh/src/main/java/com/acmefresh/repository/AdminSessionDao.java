package com.acmefresh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmefresh.model.AdminSession;

public interface AdminSessionDao extends JpaRepository<AdminSession, Integer> {

	public Optional<AdminSession> findByAdminId(Integer adminId);
	public Optional<AdminSession> findByUuid(String uuid);
	public String deleteByUuid(String uuid);
}
