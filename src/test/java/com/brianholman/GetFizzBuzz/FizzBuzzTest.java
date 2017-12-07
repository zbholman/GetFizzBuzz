package com.brianholman.GetFizzBuzz;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class FizzBuzzTest {
	FizzBuzz usingDefaults = new FizzBuzz(15);
	FizzBuzz notUsingDefaults = new FizzBuzz(6, 5, 30);
	
	// Getters and setters were ignored in testing.
	// They could easily be added if code coverage percantage
	// is a metric that matters to management.
	
	@Before
	public void testConstructors() {
		assertEquals(usingDefaults.getFizzValue(), 3);
		assertEquals(usingDefaults.getBuzzValue(), 5);
		assertEquals(notUsingDefaults.getFizzValue(), 6);
		assertEquals(notUsingDefaults.getBuzzValue(), 5);
	}
	
	@Test
	public void testCalculate() {
		usingDefaults.calculate();
		assertTrue(usingDefaults.fizzArray.contains(3));
		assertTrue(usingDefaults.fizzArray.contains(6));
		assertTrue(usingDefaults.fizzArray.contains(9));
		assertTrue(usingDefaults.fizzArray.contains(12));
		assertTrue(usingDefaults.buzzArray.contains(5));
		assertTrue(usingDefaults.buzzArray.contains(10));
		assertTrue(usingDefaults.fizzBuzzArray.contains(15));

		notUsingDefaults.calculate();
		assertTrue(notUsingDefaults.fizzArray.contains(6));
		assertTrue(notUsingDefaults.fizzArray.contains(12));
		assertTrue(notUsingDefaults.fizzArray.contains(18));
		assertTrue(notUsingDefaults.fizzArray.contains(24));
		assertTrue(notUsingDefaults.buzzArray.contains(5));
		assertTrue(notUsingDefaults.buzzArray.contains(10));
		assertTrue(notUsingDefaults.buzzArray.contains(15));
		assertTrue(notUsingDefaults.buzzArray.contains(20));
		assertTrue(notUsingDefaults.buzzArray.contains(25));
		assertTrue(notUsingDefaults.fizzBuzzArray.contains(30));
	}
	
	@Test
	public void testToJSON() {
		JSONObject expectedDefaultJSON = new JSONObject("{\"FizzBuzz\":[15],\"Fizz\":[3,6,9,12],\"Buzz\":[5,10]}");
		JSONObject expectedNonDefaultJSON = new JSONObject("{\"FizzBuzz\":[30],\"Fizz\":[6,12,18,24],\"Buzz\":[5,10,15,20,25]}");
		notUsingDefaults.calculate();
		usingDefaults.calculate();
		String defaults = usingDefaults.toJSON().toString();
		String nonDefaults = notUsingDefaults.toJSON().toString();
		JSONAssert.assertEquals(expectedDefaultJSON.toString(), defaults, false);
		JSONAssert.assertEquals(expectedNonDefaultJSON.toString(), nonDefaults, false);
	}
}
