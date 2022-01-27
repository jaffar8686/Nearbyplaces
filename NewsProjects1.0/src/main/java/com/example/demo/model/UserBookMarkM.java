package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class UserBookMarkM {
	
	private String emailId;
	private String urls;
	private Integer userId;
	
	public UserBookMarkM() {
		super();
		
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUrls() {
		return urls;
	}
	public void setUrls(String urls) {
		this.urls = urls;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	

}
