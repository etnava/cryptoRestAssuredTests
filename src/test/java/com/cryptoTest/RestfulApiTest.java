package com.cryptoTest;

import org.junit.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestfulApiTest {

	
	
	@Test
	public void that_base_request_returnsOK() {
		RestAssured.baseURI = "http://localhost:1111";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode,  200);
	}

	
	@Test
	public void that_requested_id_returnsOK() {
		RestAssured.baseURI = "http://localhost:1111";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/bitcoin");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode,  200);
	}
}
