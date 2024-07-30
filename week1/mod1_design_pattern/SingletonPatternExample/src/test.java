/*
 * Exercise 1: Implementing the Singleton Pattern
Scenario: 
You need to ensure that a logging utility class in your application has only one instance throughout the application lifecycle to ensure consistent logging.
Steps:
1.	Create a New Java Project:
    >>	Create a new Java project named SingletonPatternExample.
2.	Define a Singleton Class:
    >>	Create a class named Logger that has a private static instance of itself.
    >>	Ensure the constructor of Logger is private.
    >>	Provide a public static method to get the instance of the Logger class.
3.	Implement the Singleton Pattern:
    >>	Write code to ensure that the Logger class follows the Singleton design pattern.
4.	Test the Singleton Implementation:
    >>  Create a test class to verify that only one instance of Logger is created and used across the application.

 * 
 */

class Logger{ //it is singleton class -> which allows to create only one object of that class
    private static Logger instance; // as through the function we creating an object and the function is static so we have to return a static object
    private Logger(){
        System.out.println("private constructor is called by getinstance function not from the main");
    }
    public static Logger getinstance(){ //as constructor is private so can't create obj in main function and without obj calling a function is possible if the function is static in that class
        if(instance==null){
            instance=new Logger();
            System.out.println("object created inside getinstance");
        }
        return instance;
    }
}
public class test { // to check the implementation of the singleton class
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        Logger logger_1 = Logger.getinstance();
        Logger logger_2 = Logger.getinstance();
        if(logger_1==logger_2)
            System.out.println("only one instance cretaed"); //as singleton class allow to create only one object
        //Logger.getinstance();
    }
}
