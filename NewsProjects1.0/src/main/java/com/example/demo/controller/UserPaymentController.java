package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserBookMarkM;
import com.example.demo.model.UserPaymentM;
import com.example.demo.service.UserBookMarkServiceImpl;
import com.example.demo.service.UserPaymentServiceImpl;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserPaymentController {
	
	@Autowired
	private UserPaymentServiceImpl userPaymentServiceImpl;
	
	@PostMapping("/addpayment")
	public String add(@RequestBody UserPaymentM user) {
		System.out.println("Add user");
		userPaymentServiceImpl.saveUserSub(user);
		
		return "New payment added";
	}
	

}
