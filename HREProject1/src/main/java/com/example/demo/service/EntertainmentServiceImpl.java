package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EntertainmentRepository;

@Service
public class EntertainmentServiceImpl implements EntertainmentService{

	@Autowired
	private EntertainmentRepository entertainmentRepository;
	
	@Override
	public ArrayList getEntertain(String latitude,String longitude) {
		
		HttpConn2 connection=new HttpConn2(entertainmentRepository,latitude,longitude);
		ArrayList place=connection.getPlaces();
		
		return place;
	}

}
