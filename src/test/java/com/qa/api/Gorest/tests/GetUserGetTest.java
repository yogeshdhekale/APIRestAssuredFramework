package com.qa.api.Gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.qa.api.Gorest.RestClient.RestClient;

import io.restassured.response.Response;

public class GetUserGetTest {
	
	String BaseURI = "https://gorest.co.in";
	String BasePath = "/public-api/users";
	String token = "cb5d7e66b3c6c8d780f3056c01fe509d97f2b67d37b04cc465e62e339577b7f2";
	
	@Test
	public void getAllUserListAPI() {
		
		Response getResponse = RestClient.doGet("JSON", BaseURI, BasePath, token, null, true);
		
		System.out.println(getResponse.getStatusCode());
		System.out.println(getResponse.prettyPrint());
		
	}
	
	@Test
	public void getUserWithParamAPI() {
		Map<String, String> queryParam = new HashMap<String, String>();
		queryParam.put("name", "Suryakanta Bhat");
		
		Response getResponse = RestClient.doGet("JSON", BaseURI, BasePath, token, queryParam, true);
		
		System.out.println(getResponse.getStatusCode());
		System.out.println(getResponse.prettyPrint());
	}

}
