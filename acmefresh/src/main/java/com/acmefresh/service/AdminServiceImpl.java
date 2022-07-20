package com.acmefresh.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmefresh.exception.AdminException;
import com.acmefresh.exception.UserException;
import com.acmefresh.model.Admin;
import com.acmefresh.model.AdminSession;
import com.acmefresh.model.UserSession;
import com.acmefresh.repository.AdminDao;
import com.acmefresh.repository.AdminSessionDao;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private AdminSessionDao adminSessionDao;

	@Override
	public Admin saveAdmin(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		String email = admin.getEmail();
		Long phone = admin.getPhone();
		Admin existingAdmin = adminDao.findByEmail(email);
		if(String.valueOf(phone).length()==10) {
			if(existingAdmin==null) {
				return adminDao.save(admin);
			}
			else {
				throw new AdminException("Admin already exists with email: "+email);
			}
		}
		else {
			throw new AdminException("Phone number must be 10 digits");
		}

	}

	@Override
	public AdminSession saveLogin(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		String email = admin.getEmail();
		String password = admin.getPassword();
		Admin existingAdmin = adminDao.findByEmail(email);
		if(existingAdmin==null) {
			throw new AdminException("Invalid login credentials");
		}
		else {
			Integer adminId = existingAdmin.getAdminId();
			Optional<AdminSession> session = adminSessionDao.findByAdminId(adminId);
			if(session.isPresent()) {
				throw new AdminException("Admin already logged in");
			}
			String existingPassword = existingAdmin.getPassword();
			if(password.equals(existingPassword)) {
				String key = new UserServiceImpl().getRandomString(6);
				LocalDateTime localDateTime = LocalDateTime.now();
				AdminSession adminSession = new AdminSession(existingAdmin.getAdminId(),key,localDateTime);
				adminSessionDao.save(adminSession);
				return adminSession;
			}
			else {
				throw new AdminException("Wrong password");
			}
		}

	}

	@Override
	public Admin updateAdmin(Admin admin, String key) throws AdminException {
		// TODO Auto-generated method stub
		Optional<AdminSession> session = adminSessionDao.findByUuid(key);
		
		if(session.isPresent()) {
			AdminSession existingSession = session.get();
			Integer existingAdminId = existingSession.getAdminId();
			Integer adminId = admin.getAdminId();
			if(existingAdminId==adminId) {
				return adminDao.save(admin);
			}
			else {
				throw new AdminException("Invalid Admin");
			}
		}
		else {
			throw new AdminException("Try login first");
		}
	}

	@Override
	public String deleteSession(String key) throws AdminException {
		// TODO Auto-generated method stub
		Optional<AdminSession> opt = adminSessionDao.findByUuid(key);
		if(opt.isPresent()) {
			AdminSession session = opt.get();
			adminSessionDao.deleteById(session.getSessionId());
			return "Logged out successfully";
		}
		else {
			throw new AdminException("Try login first");
		}
	}
	
}
