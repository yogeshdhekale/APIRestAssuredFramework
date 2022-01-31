package com.qa.api.Gorest.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.api.Gorest.RestClient.RestClient;
import com.qa.api.Gorest.pojo.User;
import com.qa.api.Gorest.util.ExcelUtil;

import io.restassured.response.Response;

public class CreateUserPostTest {
	
	String baseURI = "https://gorest.co.in";
	String basePath = "/public-api/users";
	String token = "cb5d7e66b3c6c8d780f3056c01fe509d97f2b67d37b04cc465e62e339577b7f2";
	
	@DataProvider
	public Object[][] getUserData() {
		Object userData[][] = ExcelUtil.getTestDataExcel("userData");
		return userData;
	}
	
	
	@Test(dataProvider = "getUserData")
	public void createUserExcelAPIPostTest(String name, String email, String gender, String status) {
		
	//	User user = new User("Suryakant Mishra", "surya.mishra@hotmail.com", "male", "active");
		
		User user = new User(name, email, gender, status);
		
		Response response = RestClient.doPost("JSON", baseURI, basePath, token, null, user, true);
		
		System.out.println(response.prettyPrint());
		System.out.println("*************************************");
		System.out.println(response.statusCode());
		
	}
	
	
	@Test
	public void createUserAPIPostTest() {
		
		User user = new User("Suryakant Mishra", "surya.mishra@hotmail.com", "male", "active");
		
		Response response = RestClient.doPost("JSON", baseURI, basePath, token, null, user, true);
		
		System.out.println(response.prettyPrint());
		System.out.println(response.statusCode());
		
	}

}
