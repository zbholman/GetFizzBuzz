package com.brianholman.GetFizzBuzz;

import java.io.IOException;
import java.net.URI;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class FizzBuzzHandler implements HttpHandler {
	
	public void handle(HttpExchange t) throws IOException {
		
		int upperBound = parseUpperBound(t.getRequestURI());
		FizzBuzz fizzBuzz = new FizzBuzz(upperBound);
		fizzBuzz.calculate();
		fizzBuzz.toJSON();
		String jsonString = fizzBuzz.returnJSON().toString();
		t.sendResponseHeaders(200, jsonString.length());
	}
	
	// Returns upper bound value from request
	public static int parseUpperBound(URI uri) {
		String upperBoundString = uri.toString().substring(10);
		int upperBound = Integer.parseInt(upperBoundString);
	    return upperBound;
	}
}