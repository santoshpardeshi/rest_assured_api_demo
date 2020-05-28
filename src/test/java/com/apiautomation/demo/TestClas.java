package com.apiautomation.demo;

import com.apiautomation.util.ConfigurationReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class TestClas {
	ConfigurationReader configurationReader = ConfigurationReader.getInstance();

	public <T1, T2> T2 getStatusCall(T1 request, Class<T2> response) throws JsonMappingException, JsonProcessingException {

		ObjectMapper obj = new ObjectMapper();
		String payload = obj.writeValueAsString(request);
		RequestSpecification val;
		String resp = null;
		if (payload == null) {
			val = RestAssured.given().header("content-type", "application/json");
		} else {
			resp = RestAssured.given().header("content-type", "application/json").body(payload).when().post(
					configurationReader.getProperty("base_url") + configurationReader.getProperty("create_employee")).asString();

		}
		
		return obj.readValue(resp, response);
	}
}
