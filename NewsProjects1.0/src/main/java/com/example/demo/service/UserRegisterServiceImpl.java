package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserRegister;
import com.example.demo.repository.UserRegisterRepository;
@Service
public class UserRegisterServiceImpl implements UserRegisterService{

	@Autowired
	private UserRegisterRepository userRegisterRepository;
	
	
	@Override
	public UserRegister saveNewsUsers(UserRegister newsusers) {
		// TODO Auto-generated method stub
		return userRegisterRepository.save(newsusers);
	}

	@Override
	public UserRegister UpdatePassword(UserRegister users) {
		
		UserRegister user1 = userRegisterRepository.findByEmailAddress(users.getEmailAddress());
	   // System.out.println(users.getEmail_address()+"==user1=="+user1.getPassword());
		if(user1 !=null) {
		  user1.setPassword(users.getPassword());
		  System.out.println(users.getEmailAddress()+"==user=="+user1.getPassword());
			return userRegisterRepository.save(user1);
				}
		return user1;
	}

	@Override
	public List<UserRegister> getAllUsers() {
		// TODO Auto-generated method stub
		return userRegisterRepository.findAll();
	}

}
