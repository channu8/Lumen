package com.example.demo;

import java.sql.*;
import java.util.List;

import com.example.demo.exceptions.NameNotFoundException;
import com.example.demo.utils.DbConnection;
import com.training.daos.EmployeeDaoImpl;
import com.training.entity.Employee;
public class Application {

	public static void main(String[] args) throws NameNotFoundException {
	
		Connection con = DbConnection.getOracleConnection();
		
		EmployeeDaoImpl repo = new EmployeeDaoImpl(con);
		
		int key =6;
		if(key==1) {
		
		
      boolean result;
		result = repo.add();
		if(result) {
			System.out.println("One Employee Added");
		}
		else {
			System.out.println("unable to add");
		}

		}
		
		if(key==2) {
			
			List<Employee> list = repo.findAllEmployeeTable();
			
			for(Employee eachEmployee : list) {
				
				System.out.println(eachEmployee);
			}
		}
		
		if(key==3) {
			
			Employee obj = repo.findEmployeeByName();
			System.out.println(obj);
			
		}
		
		if(key==4) {
			
			boolean result;
			result = repo.updateEmployeeById();
			if(result) {
				System.out.println("One Employee updated");
			}
			else {
				System.out.println("unable to update");
			}
			
		}
		
		if(key==5) {
			
			List<Employee> list = repo.findFnamePhone();
			
			for(Employee eachEmployee : list) {
				
				System.out.print("First name :"+eachEmployee.getFirstName()+ "->");
				System.out.println("Phone Number:"+eachEmployee.getPhoneNumber());
			}
		}
		
		if(key==6) {
			
			List<Employee> list = repo.findFnamePhoneByWed();
			
			for(Employee eachEmployee : list) {
				
				System.out.print("First name :"+ eachEmployee.getFirstName()+ "->");
				System.out.println("Phone Number:"+eachEmployee.getPhoneNumber());
			}
		}
		if(key==7) {
			
			List<Employee> list = repo.findFnameEmailByBday();
			
			for(Employee eachEmployee : list) {
				
				System.out.print("First name :"+ eachEmployee.getFirstName()+ "->");
				System.out.println("EmailId :"+ eachEmployee.getEmailAddress());
			}
		}
	}

}
