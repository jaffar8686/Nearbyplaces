package com.example.demo.service;

import com.example.demo.entity.UserTable;

public interface UserService {
	
	public void saveUsers(UserTable users);
	public String authentication(String email,String password);

}
