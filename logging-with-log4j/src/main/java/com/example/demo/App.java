package com.example.demo;

import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Logger log = Logger.getRootLogger();
        
       
        try(Scanner sc = new Scanner(System.in);) {
        	
        	 //log.debug("inside try block");
        	 System.out.println("enter the number");
             double number = sc.nextInt();
             log.info("you entered number :"+number);
             
        if(number<0) {
        	log.error("number should be positive");
        	throw new Exception("Invalid Number");
        }
        	 double result = Math.sqrt(number);
             
             log.info("completed square root:"+result);
        	
             sc.close();
        }
        catch(Exception e) {
        	log.debug(e.getMessage());
        	e.printStackTrace();
        	
        }
             
       
    }
}
