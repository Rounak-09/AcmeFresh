package com.acmefresh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.acmefresh.model.Admin;
import com.acmefresh.model.AdminSession;
import com.acmefresh.model.User;
import com.acmefresh.service.AdminService;
import com.acmefresh.service.UserService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/admin/signup")
	public ResponseEntity<Admin> saveAdminHandler(@Valid @RequestBody Admin admin){
			
		Admin savedAdmin = adminService.saveAdmin(admin);
		return new ResponseEntity<Admin>(savedAdmin,HttpStatus.CREATED);
	}
	
	@GetMapping("/admin/login")
	public ResponseEntity<AdminSession> getAdminHandler(@RequestBody Admin admin){
		
		AdminSession adminLoggedin = adminService.saveLogin(admin);
		return new ResponseEntity<AdminSession>(adminLoggedin,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/admin/allusers")
	public ResponseEntity<List<User>> getAllUsersHandler(@RequestHeader String key){
		List<User> users = userService.getAllUsers(key);
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	@PutMapping("/admin/update")
	public ResponseEntity<Admin> updateUserHandler(@RequestBody Admin admin,@RequestHeader String key){
		
		Admin updatedAdmin = adminService.updateAdmin(admin, key);
		return new ResponseEntity<Admin>(updatedAdmin,HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/admin/logout")
	public ResponseEntity<String> deleteAdminSessionHandler(@RequestHeader String key){
		adminService.deleteSession(key);
		return new ResponseEntity<String>("Logged out successfully",HttpStatus.ACCEPTED);
	}
}
