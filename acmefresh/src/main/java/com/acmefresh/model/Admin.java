package com.acmefresh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	@Size(min=3,max=15,message="Name must be between 3 to 15 characters")
	private String name;
	
	private Long phone;
	
	@Email(message="Enter valid email")
	private String email;
	
	@Size(min=5,max=8,message="Password must be between 5 to 8 characters")
	private String password;

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(@Size(min = 3, max = 15, message = "Name must be between 3 to 15 characters") String name, Long phone,
			@Email(message = "Enter valid email") String email,
			@Size(min = 5, max = 8, message = "Password must be between 5 to 8 characters") String password) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}
	
	
}
