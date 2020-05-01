package com.cryptoTest;


import org.junit.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestfulApiTest {

	@Before
	public void init() {
		baseURI = "http://localhost:2222/";
	}

	@Test
	public void that_base_request_returnsOK() {
		given().get().then().statusCode(200);
	}

	@Test
	public void that_bitcoin_request_returnOK() {
		given().get("bitcoin").then().statusCode(200);
	}

	@Test
	public void that_bitcoin_id_return_bitcoin() {
		given().get("bitcoin").then().body("id", equalTo("bitcoin"));
	}

	@Test
	public void that_header_is_application_json() {
		given().get().then().contentType("application/json");
	}

	@Test
	public void that_bitcoin_header_is_application_json() {
		given().get("bitcoin").then().contentType("application/json");
	}

	@Test
	public void that_response_time_is_OK() {
		given().get().then().time(lessThan(1000L));
	}

	@Test
	public void that_bitcoin_response_time_is_OK() {
		given().get("bitcoin").then().time(lessThan(1000L));
	}

	@Test
	public void that_bitcoin_market_cap_is_correct() {
		given().get("bitcoin").then().body("market_cap", equalTo("246842812268"));
	}
	
	@Test
	public void that_bitcoin_market_price_is_correct() {
		given().get("bitcoin").then().body("current_price", equalTo(13448.54f));
	}
	
	@Test
	public void that_api_returns_list_of_10() {
		given().get().then().body("size()", is(10));
	}
	
}
