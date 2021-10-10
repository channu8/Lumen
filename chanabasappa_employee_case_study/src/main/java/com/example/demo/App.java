package com.example.demo;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;



import com.example.demo.exceptions.NameNotFoundException;
import com.example.demo.utils.DbConnection;
import com.training.daos.EmployeeDaoImpl;
import com.training.entity.Employee;
public class App {

	public static void main(String[] args) throws NameNotFoundException {
	
		 Logger log = Logger.getRootLogger();
		
		 Scanner sc = new Scanner(System.in);
		Connection con = DbConnection.getOracleConnection();
		
		EmployeeDaoImpl repo = new EmployeeDaoImpl(con);
		
		try {
            repo.createTable(); 
           // create table "employeetable"
        }catch (SQLException e){
            log.error("Database connectivity problem; "+e);
            
            return;    
        }
		
		boolean flag=true;
		while(flag) {
		System.out.println("******* Welcome to Employee Database*******");
		System.out.println("******* Please choose the operation you want to perform*******");
		System.out.println("*Press 1- To Add new Employee into Database*");
		System.out.println("*Press 2- To Display All Employees in the Database*");
		System.out.println("*Press 3- To Find Employee by name from Database*");
		System.out.println("*Press 4- To Update Employee details by Id from Database*");
		System.out.println("*Press 5- To Find only the firstname and phone number of Employee from Database*");
		System.out.println("*Press 6- To Find only the firstname and phone number of Employee by Wedding date Database*");
		System.out.println("*Press 7- ToFind only the firstname and Emailaddress of Employee by Birthdate date Database*");
		System.out.println("*Press 8- To Exit*");
		int key= sc.nextInt();
		
		if(key==1) {
		
		
      boolean result;
		result = repo.add();
		if(result) {
			
			log.info("One Employee Added");
		}
		else {
			log.info("Unable to add employee");
			
		}

		}
		
		if(key==2) {
			
			List<Employee> list = repo.findAllEmployeeTable();
			
			for(Employee eachEmployee : list) {
				
				log.info(eachEmployee);
				
			}
			log.info("All employee details Fethched");
		}
		
		if(key==3) {
			
			Employee obj = repo.findEmployeeByName();
			log.info(obj);
			log.info("One employee details Fethched By Name");
			
		}
		
		if(key==4) {
			
			boolean result;
			result = repo.updateEmployeeById();
			if(result) {
				log.info("One Employee Details updated");
			}
			else {
				log.info("unable to update employee details");
			}
			
		}
		
		if(key==5) {
			
			List<Employee> list = repo.findFnamePhone();
			
			for(Employee eachEmployee : list) {
				
				log.info("First name :"+eachEmployee.getFirstName()+ "->");
				log.info("Phone Number:"+eachEmployee.getPhoneNumber());
				
			}
			log.info("All employees First name and Phone Numbers Fethched");
		}
		
		if(key==6) {
			
			List<Employee> list = repo.findFnamePhoneByWed();
			
			for(Employee eachEmployee : list) {
				
				log.info("First name :"+ eachEmployee.getFirstName()+ "->");
				log.info("Phone Number:"+eachEmployee.getPhoneNumber());
				
			}
			log.info(" One Employee First name and Phone Number Fethched By using Wedding Date");
		}
		if(key==7) {
			
			List<Employee> list = repo.findFnameEmailByBday();
			
			for(Employee eachEmployee : list) {
				
				log.info("First name :"+ eachEmployee.getFirstName()+ "->");
				log.info("EmailId :"+ eachEmployee.getEmailAddress());
				
			}
			log.info(" One Employee First name and Email Address Fethched By using Birth Date");
		}
		if(key==8) {
			
			flag=false;
		}
	}
	}
}

