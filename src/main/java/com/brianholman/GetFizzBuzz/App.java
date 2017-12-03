package com.brianholman.GetFizzBuzz;

public class App 
{
    public static void main( String[] args )
    {
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.calculate(30, 3, 5);
        fizzBuzz.addToJSON();
        fizzBuzz.printJSON();
    }
}
