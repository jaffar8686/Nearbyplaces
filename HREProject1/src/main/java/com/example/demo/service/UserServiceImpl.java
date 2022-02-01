package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserTable;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveUsers(UserTable users) {
		System.out.println(userRepository.getClass());
		userRepository.save(users);
		
	}

	@Override
	public String authentication(String email, String password) {
		UserTable users=userRepository.findByEmailId(email);
		if(users!=null  &&  users.getPassword().equals(password)) {
			return users.getName();
			
		}
		else {
			return "Authentication failed";
		}
		
	}

}
