package com.brianholman.GetFizzBuzz;

import java.util.ArrayList;

import org.json.JSONObject;

public class FizzBuzz {
	ArrayList<Integer> fizzArray = new ArrayList<Integer>();
	ArrayList<Integer> buzzArray = new ArrayList<Integer>();
	ArrayList<Integer> fizzBuzzArray = new ArrayList<Integer>();	
	JSONObject arraysObject = new JSONObject();	
	boolean isBoth = false;
	
	public void calculate(int upperBound, int fizzValue, int buzzValue) {
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
	public void addToJSON() {
		arraysObject.put("Fizz", fizzArray);
		arraysObject.put("Buzz", buzzArray);
		arraysObject.put("FizzBuzz", fizzBuzzArray);
	}
	
	public void printJSON() {
		System.out.println(arraysObject.toString());
	}
}
