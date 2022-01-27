package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserRegister;
import com.example.demo.service.UserRegisterService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserRegisterController {
	
	@Autowired
	private UserRegisterService userRegisterService;
	
	@GetMapping("/getData")
	public List<UserRegister> getAllUsers(){
		return userRegisterService.getAllUsers();
	}
	
	@PostMapping("/adduser")
	public String add(@RequestBody UserRegister user) {
		System.out.println("Add user");
		userRegisterService.saveNewsUsers(user);
		
		return "New User added";
	}
	
	@PutMapping("/resetPassword")
	public String reset(@RequestBody UserRegister user) {
	//logger.info("password reset");
		userRegisterService.UpdatePassword(user);

	return "password reset";
	}

}
