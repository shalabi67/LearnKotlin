package com.learn.function.calling_from_java;

/**
 * Created by mohammad on 10/31/2017.
 */
public class JavaApplication {
    public static void main(String[] args) {
        System.out.println("shows how to call kotlin function from java");
        System.out.println("5 + 6 is " + MathFunctions.intSum(5,6));

        
        Log.log("This is an info message");
        Log.log("This is a debug message", 1);
    }
}
