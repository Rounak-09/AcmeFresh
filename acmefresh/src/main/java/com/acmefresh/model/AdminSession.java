package com.acmefresh.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminSession {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer sessionId;
	
	@Column(name="adminId")
	private Integer adminId;
	private String uuid;
	private LocalDateTime localDateTime;
	public Integer getSessionId() {
		return sessionId;
	}
	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public AdminSession() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminSession(Integer adminId, String uuid, LocalDateTime localDateTime) {
		super();
		this.adminId = adminId;
		this.uuid = uuid;
		this.localDateTime = localDateTime;
	}
	
	
}
