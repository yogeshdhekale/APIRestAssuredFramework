package com.qa.api.Gorest.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {
	
	/*
	 * This method is used to covert POJO object to a JSON String
	 * 
	 */
	
	public static String getSerializedJASON(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		String JSONString = null;
		
		try {
			JSONString = mapper.writeValueAsString(obj);
			System.out.println("JSON body Payload ==> " + JSONString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return JSONString;
	}

}
