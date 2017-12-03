package com.brianholman.GetFizzBuzz;

import java.util.ArrayList;

import org.json.JSONObject;

public class FizzBuzz {
	
	ArrayList<Integer> fizzArray, buzzArray, fizzBuzzArray = new ArrayList<Integer>();
	JSONObject arraysObject = new JSONObject();
	int fizzValue, buzzValue, upperBound;
	
	// Default values set for fizz and buzz are 3 and 5
	public FizzBuzz(int upperBound) {
		fizzValue = 3;
		buzzValue = 5;
		this.upperBound = upperBound;
	}
	
	public FizzBuzz(int fizzValue, int buzzValue, int upperBound) {
		this.fizzValue = fizzValue;
		this.buzzValue = buzzValue;
		this.upperBound = upperBound;
	}
	
	public void calculate() {
		int fizzBuzzValue = this.fizzValue * this.buzzValue;
		
		for (int i = 1; i < this.upperBound; i++) {
			if (i % fizzBuzzValue == 0) {
				fizzBuzzArray.add(i);
			}
			else if (i % buzzValue == 0) {
				buzzArray.add(i);
			}
			else if (i % fizzValue == 0) {
				fizzArray.add(i);
			}
		}
	}
	
	public void toJSON() {
		arraysObject.put("Fizz", fizzArray);
		arraysObject.put("Buzz", buzzArray);
		arraysObject.put("FizzBuzz", fizzBuzzArray);
	}
	
	public JSONObject returnJSON() {
		return this.arraysObject;
	}
}
