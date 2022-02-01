package com.example.demo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Entertainment;
import com.example.demo.entity.Hotel;
import com.example.demo.repository.EntertainmentRepository;

@Component
public class HttpConn2 {
	

	
	private static HttpURLConnection conn;
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(HttpConn2.class.getName());
	private EntertainmentRepository entertainmentRepository;
	private String lat;
	private String lon;
	
	
	
	public HttpConn2() {
		
	}
	
	public HttpConn2(EntertainmentRepository entertainmentRepository,String latitude,String longitude) {
		this.entertainmentRepository=entertainmentRepository;
		this.lat=latitude;
		this.lon=longitude;
		
		
	}
	
	public  ArrayList parse(String responseBody) {
		
		 
		List<Entertainment> nearPlaces=new ArrayList<>(); 
		JSONObject place = new JSONObject(responseBody);
		 String name;
		 int distance;
		 String latitude;
		 String longitude;
		 String address;

		 String cross_street;
		 String locality;
		 String post_code;
		 String region;
		 String country;
		 String timezone;
		
		for(int i=0;i<place.getJSONArray("results").length();i++ ) {
	    
		System.out.println("fsq_id"+" "+place.getJSONArray("results").getJSONObject(i).get("fsq_id"));
		System.out.println("distance"+ " "+place.getJSONArray("results").getJSONObject(i).get("distance"));
		distance=(int) place.getJSONArray("results").getJSONObject(i).get("distance");
		System.out.println("name" + " "+place.getJSONArray("results").getJSONObject(i).get("name"));
		name=(String) place.getJSONArray("results").getJSONObject(i).get("name");
		System.out.println("timezone"+" "+place.getJSONArray("results").getJSONObject(i).get("timezone"));
		timezone=(String) place.getJSONArray("results").getJSONObject(i).get("timezone");
		System.out.println("latitude"+" "+place.getJSONArray("results").getJSONObject(i).getJSONObject("geocodes").getJSONObject("main").get("latitude"));
		latitude=""+place.getJSONArray("results").getJSONObject(i).getJSONObject("geocodes").getJSONObject("main").get("latitude");
		System.out.println("longitude"+" "+place.getJSONArray("results").getJSONObject(i).getJSONObject("geocodes").getJSONObject("main").get("longitude"));
		longitude=""+place.getJSONArray("results").getJSONObject(i).getJSONObject("geocodes").getJSONObject("main").get("longitude");
		try {
		System.out.println("location"+" "+place.getJSONArray("results").getJSONObject(i).get("location"));
		System.out.println("country"+" "+place.getJSONArray("results").getJSONObject(i).getJSONObject("location").get("country"));
		country=(String) place.getJSONArray("results").getJSONObject(i).getJSONObject("location").get("country");
		System.out.println("postcode"+" "+place.getJSONArray("results").getJSONObject(i).getJSONObject("location").get("postcode"));
		post_code=(String) place.getJSONArray("results").getJSONObject(i).getJSONObject("location").get("postcode");
		//System.out.println("cross_street"+" "+place.getJSONArray("results").getJSONObject(i).getJSONObject("location").get("cross_street"));
		//cross_street=(String) place.getJSONArray("results").getJSONObject(i).getJSONObject("location").get("cross_street");
	   
	    System.out.println("cross_street"+" "+place.getJSONArray("results").getJSONObject(i).getJSONObject("location").get("cross_street"));
	    cross_street=(String) place.getJSONArray("results").getJSONObject(i).getJSONObject("location").get("cross_street");
		System.out.println(place.getJSONArray("results").getJSONObject(i).getJSONObject("location").get("address"));
		address=(String) place.getJSONArray("results").getJSONObject(i).getJSONObject("location").get("address");
		///System.out.println(place.getJSONArray("results").getJSONObject(i).getJSONObject("location").get("locality"));
		//locality=(String) place.getJSONArray("results").getJSONObject(i).getJSONObject("location").get("locality");
		System.out.println(place.getJSONArray("results").getJSONObject(i).getJSONObject("location").get("region"));
		region=(String) place.getJSONArray("results").getJSONObject(i).getJSONObject("location").get("region");
	    }catch(JSONException e) {
		  
		   address="";
		
		   cross_street="";
		   //locality="";
		   post_code="";
		   region="";
		   country="";
		  
	       e.getMessage();
	    }
	    
	  
	   
		Entertainment entertain=new Entertainment();
		entertain.setName(name);
		entertain.setDistance(distance);
		entertain.setLatitude(latitude);
		entertain.setLongitude(longitude);
		entertain.setAddress(address);
	   // hotel.setLocality(locality);
	    
		entertain.setPost_code(post_code);
		entertain.setTimezone(timezone);
		entertain.setRegion(region);
		entertain.setCountry(country);
		entertain.setCross_street(cross_street);
	    nearPlaces.add(entertain);
	     
	    entertainmentRepository.save(entertain);
	    	
	    
	   
	    
	    
	    
	    System.out.println("---------------->");
		}

		return (ArrayList) nearPlaces;
		}
	
	 public  ArrayList getPlaces() {
		 
		ArrayList al = null;
		BufferedReader reader;
		String line;
		StringBuilder responseContent = new StringBuilder();
		try{
		URL url = new URL("https://api.foursquare.com/v3/places/nearby?ll="+lat+"%2C"+lon+"&query=entertainment");
		conn = (HttpURLConnection) url.openConnection();

		// Request setup
		conn.setRequestMethod("GET");
		    String authorization="fsq3FX2htWoltBkvFAuzX1lUHkXEoDKNxJTi0IUxk65Z/ZM=";
		       
		        conn.setRequestProperty("Authorization",authorization);
		conn.setConnectTimeout(5000);// 5000 milliseconds = 5 seconds
		conn.setReadTimeout(5000);


		// Test if the response from the server is successful
		int status = conn.getResponseCode();

		if (status >= 300) {
		reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		while ((line = reader.readLine()) != null) {
		responseContent.append(line);
		}
		reader.close();
		}
		else {
		reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		while ((line = reader.readLine()) != null) {
		responseContent.append(line);
		}
		reader.close();
		}
		log.info("response code: " + status);
		System.out.println(responseContent.toString());
		System.out.println(responseContent);
		al=parse(responseContent.toString());
		
		}
		catch (MalformedURLException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		}finally {
		conn.disconnect();
		}
		return al;


		}




}
