package com.qa.api.Gorest.tests;

import org.testng.annotations.Test;

import com.qa.api.Gorest.RestClient.RestClient;
import com.qa.api.Gorest.pojo.User;

public class CreateUserPostTest {
	
	String baseURI = "https://gorest.co.in";
	String basePath = "/public-api/users";
	String token = "cb5d7e66b3c6c8d780f3056c01fe509d97f2b67d37b04cc465e62e339577b7f2";
	
	@Test
	public void createUserAPIPostTest() {
		
		User user = new User("Suryakant Mishra", "surya.mishra@hotmail.com", "male", "active");
		
		RestClient.doPost("JSON", baseURI, basePath, token, null, user, true);
		
	}

}
