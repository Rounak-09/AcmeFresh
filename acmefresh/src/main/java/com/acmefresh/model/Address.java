package com.acmefresh.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	
	@NotNull(message="UserId should not be null")
	private Integer userId;
	
	@NotNull(message="House number should not be empty")
	private String houseNo;
	
	@NotNull(message="Street name should not be empty")
	private String streetName;
	
	@NotNull(message="City should not be empty")
	private String city;
	
	@NotNull(message="State should not be empty")
	private String state;
	
	@NotNull(message="Pincode should not be empty")
	private String pinCode;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	

	public Address(Integer userId, String houseNo, String streetName, String city, String state, String pinCode) {
		super();
		this.userId = userId;
		this.houseNo = houseNo;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	
	
}
