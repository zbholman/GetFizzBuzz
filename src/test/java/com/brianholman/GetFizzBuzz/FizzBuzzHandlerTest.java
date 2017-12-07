package com.brianholman.GetFizzBuzz;

import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class FizzBuzzHandlerTest {
	FizzBuzzHandler testHandler = null;
	String invalidRequestResponse = "Error: Invalid Request, try entering only numbers after fizzbuzz/";
	
	@Before
	public void setup() {
		testHandler = new FizzBuzzHandler();
	}
	
	
	@Test
	public void testHandlerValid() {
		JSONObject validResponse = new JSONObject("{\"FizzBuzz\":[15],\"Fizz\":[3,6,9,12],\"Buzz\":[5,10]}");
		String testResponse = testHandler.processRequest("15");
		JSONObject testResponseJSON = new JSONObject(testResponse);
		
		JSONAssert.assertEquals(validResponse, testResponseJSON, false);
	}
	
	@Test
	public void testHandlerInvalidEmpty() {
		String invalidRequest = "";
		String testResponse = testHandler.processRequest(invalidRequest);
		assertEquals(testResponse, invalidRequestResponse);
	}
	
	@Test
	public void testHandlerInvalidChars() {
		String invalidRequest = "abcde";
		String testResponse = testHandler.processRequest(invalidRequest);
		assertEquals(testResponse, invalidRequestResponse);
	}
	
	@Test
	public void testHandlerInvalidNumChars() {
		String invalidRequest = "abc123";
		String testResponse = testHandler.processRequest(invalidRequest);
		assertEquals(testResponse, invalidRequestResponse);
	}
}
