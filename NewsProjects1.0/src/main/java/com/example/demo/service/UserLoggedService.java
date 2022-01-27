package com.example.demo.service;

import com.example.demo.entity.UserLogged;

public interface UserLoggedService {
	
	public UserLogged saveUser(UserLogged  userLogin);
 
	public String authenticate(String email, String password);

}
