package com.practice.application.api;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class apiPractice {
	
	public static void Main(String[] args) {
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(InputFiles.addPlace()).when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200);
	}

}
