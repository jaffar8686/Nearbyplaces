package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserLogged;
import com.example.demo.entity.UserRegister;
import com.example.demo.repository.UserLoggedRepository;
import com.example.demo.repository.UserRegisterRepository;
@Service
public class UserLoggedServiceImpl implements UserLoggedService{


	@Autowired
	private UserRegisterRepository userRegisterRepository;

	@Autowired
	private UserLoggedRepository userLoggedRepository;
	
	
	
	@Override
	public UserLogged saveUser(UserLogged userLogin) {
		return  userLoggedRepository.save(userLogin);
	}

	@Override
	public String authenticate(String email, String password) {
		System.out.println(email+"==email==="+password);
		UserRegister userRegister =  userRegisterRepository.findByEmailAddress(email);
			System.out.println("user==="+userRegister);
			System.out.println("password==="+password);
			if(userRegister != null && userRegister.getPassword().equals(password)) {
				//user.getId();
				UserLogged userLogin = new UserLogged();
				userLogin.setEmail_id(userRegister.getEmailAddress());
				userLogin.setPassword(userRegister.getPassword());
				userLogin.setUserRegister(userRegister);
				System.out.println(userRegister.toString());
				userLoggedRepository.save(userLogin);
				//create new model to send response to UI
				//map the data 
				
				return userRegister.getEmailAddress();
			}else {
				throw new RuntimeException("Authentiction failed");
			}
	}

}
