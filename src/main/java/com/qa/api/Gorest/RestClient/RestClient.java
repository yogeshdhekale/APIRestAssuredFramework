package com.qa.api.Gorest.RestClient;

import java.util.Map;

import com.qa.api.Gorest.util.TestUtil;

import io.restassured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * This class is having all http methods
 * 
 * @author yogeshdhekale
 *
 */

public class RestClient {

	public static Response doGet(String contentType, String BaseURI, String BasePath, String token,
			Map<String, String> paramsMap, boolean log) {

		setBaseURI(BaseURI);

		RequestSpecification request = createRequest(contentType, token, paramsMap, log);

		return getResponse("GET", request, BasePath);
	}
	
	/*
	 * This method is used to call POST API 
	 * 
	 */
	
	public static Response doPost(String contentType, String BaseURI, String BasePath, String token,
			Map<String, String> paramsMap, Object obj, boolean log) {

		setBaseURI(BaseURI);

		RequestSpecification request = createRequest(contentType, token, paramsMap, log);
		String jsonPayload = TestUtil.getSerializedJASON(obj);
		request.body(jsonPayload);

		return getResponse("POST", request, BasePath);
	}

	private static void setBaseURI(String BaseURI) {

		RestAssured.baseURI = BaseURI;
	}

	private static RequestSpecification createRequest(String contentType, String token, Map<String, String> paramsMap,
			boolean log) {

		RequestSpecification request;
		if (log) {
			request = RestAssured.given().log().all();
		} else {
			request = RestAssured.given().log().all();
		}

		if (token != null) {
			request.headers("Authorization", "Bearer " + token);
		}

		if (!(paramsMap == null)) {
			request.queryParams(paramsMap);
		}

		if (contentType.equalsIgnoreCase("json")) {
			request.contentType(ContentType.JSON);
		} else if (contentType.equalsIgnoreCase("xml")) {
			request.contentType(ContentType.XML);
		} else if (contentType.equalsIgnoreCase("text")) {
			request.contentType(ContentType.TEXT);
		}

		return request;
	}

	private static Response getResponse(String httpMethod, RequestSpecification request, String BasePath) {

		return executeAPI(httpMethod, request, BasePath);
	}

	private static Response executeAPI(String httpMethod, RequestSpecification request, String BasePath) {
		Response response = null;
		switch (httpMethod) {
		case "GET":
			response = request.get(BasePath);
			break;

		case "POST":
			response = request.post(BasePath);
			break;

		case "PUT":
			response = request.put(BasePath);
			break;

		case "DELETE":
			response = request.delete(BasePath);
			break;

		default:
			System.out.println("Please pass correct HTTP Method");
			break;
		}

		return response;

	}

}
