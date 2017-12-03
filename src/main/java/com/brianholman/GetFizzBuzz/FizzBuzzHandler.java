package com.brianholman.GetFizzBuzz;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class FizzBuzzHandler implements HttpHandler {
	
	public void handle(HttpExchange t) throws IOException {
		String requestString = t.getRequestURI().toString().substring(10);

		String response = processRequest(requestString);

		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
        	os.write(response.getBytes());
        	os.close();
	}
	
	public String processRequest(String requestString) {
		// Regex below checks to see that the string contains only numbers from start to end
		if (requestString.matches("^[0-9]*$") && requestString.length() > 0) {
			int upperBound = Integer.parseInt(requestString);
			FizzBuzz fizzBuzz = new FizzBuzz(upperBound);
			fizzBuzz.calculate();
			return fizzBuzz.toJSON().toString();
		}
		else {
			return "Error: Invalid Request, try entering only numbers after fizzbuzz/";
		}
	}
}
