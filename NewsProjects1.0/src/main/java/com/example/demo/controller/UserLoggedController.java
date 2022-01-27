package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserLogged;
import com.example.demo.service.UserLoggedService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserLoggedController {
	

	@Autowired
	private UserLoggedService userLoggedService;
	
	//private UserLogged userLogged;
	
	@PostMapping("/addlogin")
	public String add(@RequestBody UserLogged user) {
		System.out.println("Add user");
		userLoggedService.authenticate(user.getEmail_id(), user.getPassword());
		
		return "New User logged";
		
	}
	
	
	@PostMapping("/signIn/{email}/{password}")
	public ResponseEntity<Object> signIn(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password) {
		System.out.println("login user");
		try {
			String emails = userLoggedService.authenticate(email, password);
			
			
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new ResponseEntity(re.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Object>("Success",HttpStatus.OK);

	}

}
