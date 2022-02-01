package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.entity.Entertainment;
import com.example.demo.entity.LoginDetails;
import com.example.demo.entity.Restaurant;
import com.example.demo.entity.UserTable;
import com.example.demo.service.EntertainmentServiceImpl;
import com.example.demo.service.HotelServiceImpl;
import com.example.demo.service.RestaurantServiceImpl;
import com.example.demo.service.UserServiceImpl;

@RestController
@RequestMapping("/places")

@CrossOrigin(origins = "*")
public class HREController {
	
	@Autowired
	private RestaurantServiceImpl restaurantServiceImpl;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private HotelServiceImpl hotelServiceImpl;
	
	@Autowired
	private EntertainmentServiceImpl entertainmentServiceImpl;
	
	
//	@GetMapping("/getRestaurant")
//	public List<Restaurant> getRest(@RequestBody Category category){
//		
//		return restaurantServiceImpl.getRest(category.getLatitude(),category.getLongitude(),category.getCategory());
//	}
//	
	
	@GetMapping("/getRestaurant/{latitude}/{longitude}")
	public ResponseEntity<Object> getRest(@PathVariable("latitude") String latitude,@PathVariable("longitude") String longitude){
		ArrayList restaurant=restaurantServiceImpl.getRest(latitude,longitude);
		return new ResponseEntity<Object>(restaurant,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/getHotel/{latitude}/{longitude}")
	public ResponseEntity<Object> getHotel(@PathVariable("latitude") String latitude,@PathVariable("longitude") String longitude){
		ArrayList hotelss=hotelServiceImpl.getHotel(latitude,longitude);
		return new ResponseEntity<Object>(hotelss,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/getEntertain/{latitude}/{longitude}")
	public ResponseEntity<Object> getEntertain(@PathVariable("latitude") String latitude,@PathVariable("longitude") String longitude){
		ArrayList entertains=entertainmentServiceImpl.getEntertain(latitude,longitude);
		return new ResponseEntity<Object>(entertains,HttpStatus.OK);
		
		
	}
	
   
//	@GetMapping("/getEntertain")
//	public List<Entertainment> getEntertain(@RequestBody Category category){
//		return entertainmentServiceImpl.getEntertain(category.getLatitude(),category.getLongitude(),category.getCategory());
//	}
//	
	
	
	@PostMapping("/addUsers")
	public String saveUsers(@RequestBody UserTable users) {
		userServiceImpl.saveUsers(users);
		return "User added";
		
	}
	
	
	@PostMapping("/authenticate")
	public ResponseEntity<Object> validUser(@RequestBody LoginDetails login) {
		
		String str=userServiceImpl.authentication(login.getEmail(), login.getPassword());
		if (str!="Authentication failed") {
			System.out.println("Success");
		return new ResponseEntity<Object>(str,HttpStatus.OK);
		}
		else {
			System.out.println("Authentication failed");
			return new ResponseEntity<Object>(str,HttpStatus.UNAUTHORIZED);
		}
	}


}
