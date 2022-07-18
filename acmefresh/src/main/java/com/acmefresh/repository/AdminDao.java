package com.acmefresh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmefresh.model.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {
	
	public Admin findByPhone(Long phone);
	
	public Admin getByAdminId(Integer userId);

}
