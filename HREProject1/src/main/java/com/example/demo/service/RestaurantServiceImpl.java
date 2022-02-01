package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Override
	public ArrayList getRest(String latitude,String longitude) {
		HttpConn3 connection=new HttpConn3(restaurantRepository,latitude,longitude);
		ArrayList place=connection.getPlaces();
		
		return place;
	}

}
