package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserBookMarkM;
import com.example.demo.service.UserBookMarkServiceImpl;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserBookMarkController {
	
	@Autowired
	private UserBookMarkServiceImpl userBookMarkServiceImpl;
	
	
	@PostMapping("/addbooks")
	public String add(@RequestBody UserBookMarkM user) {
		System.out.println("Add user");
		userBookMarkServiceImpl.saveUser(user);
		
		return "New bookmark added";
	}

}
