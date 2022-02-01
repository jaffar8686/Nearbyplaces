package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Hotel;
import com.example.demo.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public ArrayList getHotel(String latitude,String longitude) {
		// TODO Auto-generated method stub
		
		HttpConn1 connection=new HttpConn1(hotelRepository,latitude,longitude);
		ArrayList place=connection.getPlaces();
		
		return place;
	}

}
