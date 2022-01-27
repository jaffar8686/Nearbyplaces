package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.UserRegister;

public interface UserRegisterService {
	

	public UserRegister saveNewsUsers(UserRegister newsusers);
	public List<UserRegister> getAllUsers();
	//public LoggedInUser authenticate(String userName, String password);
	
	//public int authenticate1(String email_address);
	
	public UserRegister UpdatePassword(UserRegister users);

}
