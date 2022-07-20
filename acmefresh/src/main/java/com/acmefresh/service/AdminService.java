package com.acmefresh.service;

import com.acmefresh.exception.AdminException;
import com.acmefresh.model.Admin;
import com.acmefresh.model.AdminSession;

public interface AdminService {

	public Admin saveAdmin(Admin admin)throws AdminException;

	public AdminSession saveLogin(Admin admin) throws AdminException;

	public Admin updateAdmin(Admin admin, String key)throws AdminException;

	public String deleteSession(String key) throws AdminException;
}
