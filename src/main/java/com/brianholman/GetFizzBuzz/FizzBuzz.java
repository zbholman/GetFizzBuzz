package com.brianholman.GetFizzBuzz;

import java.util.ArrayList;

import org.json.JSONObject;

public class FizzBuzz {
	
	ArrayList<Integer> fizzArray = new ArrayList<Integer>();
	ArrayList<Integer> buzzArray = new ArrayList<Integer>();
	ArrayList<Integer> fizzBuzzArray = new ArrayList<Integer>();

	JSONObject arraysObject = new JSONObject();
	int fizzValue;
	int buzzValue;
	int upperBound;
	
	// Default values set for fizz and buzz are 3 and 5
	FizzBuzz(int upperBound) {
		setFizzValue(3);
		setBuzzValue(5);
		setUpperBound(upperBound);
	}
	
	FizzBuzz(int fizzValue, int buzzValue, int upperBound) {
		setFizzValue(fizzValue);
		setBuzzValue(buzzValue);
		setUpperBound(upperBound);
	}
	
	void calculate() {
		int fizzBuzzValue = fizzValue * buzzValue;
		
		for (int i = 1; i < upperBound; i++) {
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
	
	public JSONObject toJSON() {
		arraysObject.put("Fizz", fizzArray);
		arraysObject.put("Buzz", buzzArray);
		arraysObject.put("FizzBuzz", fizzBuzzArray);
		return arraysObject;
	}

	int getFizzValue() {
		return fizzValue;
	}

	void setFizzValue(int buzzValue) {
		this.fizzValue = buzzValue;
	}
	int getBuzzValue() {
		return buzzValue;
	}

	void setBuzzValue(int buzzValue) {
		this.buzzValue = buzzValue;
	}

	int getUpperBound() {
		return upperBound;
	}

	void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}
}
