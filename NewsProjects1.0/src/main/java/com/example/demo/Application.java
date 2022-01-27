package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	private static HttpURLConnection conn;
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(Application.class.getName());

	public static String parse(String responseBody) {
	JSONObject albums = new JSONObject(responseBody);
	for(int i=0;i<albums.getJSONArray("results").length();i++ ) {
	System.out.println("fsq_id"+" "+albums.getJSONArray("results").getJSONObject(i).get("fsq_id"));
	System.out.println("distance"+ " "+albums.getJSONArray("results").getJSONObject(i).get("distance"));
	System.out.println("name" + " "+albums.getJSONArray("results").getJSONObject(i).get("name"));
	System.out.println("timezone"+" "+albums.getJSONArray("results").getJSONObject(i).get("timezone"));
	System.out.println("latitude"+" "+albums.getJSONArray("results").getJSONObject(i).getJSONObject("geocodes").getJSONObject("main").get("latitude"));
	System.out.println("longitude"+" "+albums.getJSONArray("results").getJSONObject(i).getJSONObject("geocodes").getJSONObject("main").get("longitude"));
	System.out.println("location"+" "+albums.getJSONArray("results").getJSONObject(i).get("location"));
	System.out.println("country"+" "+albums.getJSONArray("results").getJSONObject(i).getJSONObject("location").get("country"));
	System.out.println("postcode"+" "+albums.getJSONArray("results").getJSONObject(i).getJSONObject("location").get("postcode"));
	System.out.println("cross_street"+" "+albums.getJSONArray("results").getJSONObject(i).getJSONObject("location").get("cross_street"));
    try {
	System.out.println(albums.getJSONArray("results").getJSONObject(i).getJSONObject("location").get("address"));
	System.out.println(albums.getJSONArray("results").getJSONObject(i).getJSONObject("location").get("locality"));
    }catch(JSONException e) {
    	e.getMessage();
    }
    System.out.println("---------------->");
	}
	// for (int i = 0 ; i < albums.length(); i++) {
	// JSONObject album = albums.getJSONObject(i);
	// int userId = album.getInt("userId");
	// int id = album.getInt("id");
	// String title = album.getString("title");
	// System.out.println(id+" "+title+" "+userId);
	// }
	return null;
	}

	public static void main(String[] args) {

	BufferedReader reader;
	String line;
	StringBuilder responseContent = new StringBuilder();
	try{
	URL url = new URL("https://api.foursquare.com/v3/places/nearby?ll=17.4356989%2C78.4183354&query=hotels");
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
	parse(responseContent.toString());
	}
	catch (MalformedURLException e) {
	e.printStackTrace();
	} catch (IOException e) {
	e.printStackTrace();
	}finally {
	conn.disconnect();
	}




	SpringApplication.run(Application.class, args);
	}

}
