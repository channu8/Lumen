package com.example.demo;

//import com.example.demo.utils.DbConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.utils.DbConnection;
import com.training.daos.StudentDaoImpl;
import com.training.entity.Student;
import com.training.ifaces.CrudRepository;
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(DbConnection.getOracleConnection());
		Connection con = DbConnection.getOracleConnection();
		
		CrudRepository<Student,Integer> repo = new StudentDaoImpl(con);
		
		int key=2;
		if(key==1) {
			
		
				
		Student ram= new Student(103,"mahesh",LocalDate.of(1995, 4, 9),98);
		
		boolean result = repo.add(ram);
		
		if(result) {
			System.out.println("One student Added");
		}
		}
		if(key==2) {
			
			List<Student> list = repo.findAll();
			
			for(Student eachStudent : list) {
				
				System.out.println(eachStudent);
			}
		}
		
		if(key==3) {
			
			Student obj = repo.findById(101);
			System.out.println(obj);
			
		}
		if(key==4) {
			
			Student ram= new Student(103,"mahesh",LocalDate.of(1995, 4, 9),98);
			
			boolean result = repo.remove(ram);
			
			if(result) {
				System.out.println("One student deleted");
			}
			}
         if(key==5) {
			
			Student ram= new Student(101,"Ramesh",LocalDate.of(1997, 10, 8),90);
			
			int r = repo.update(ram);
			
			
				System.out.println("One student updated");
			
			}

	}

}
