package com.example.demo;
import java.util.Arrays;
import java.util.*;
import java.util.HashMap;

public class StudentService {

//	HashMap<String,Student>details;
	HashMap<String,List<Student>>details;
	
	public StudentService() {
		details = new HashMap<>();
		
		List<Student> mcaList= Arrays.asList(new Student(101,"Arun",99), new Student(102,"Anoop",60));
		List<Student> beList= Arrays.asList(new Student(201,"Aroh",95), new Student(202,"bhim",64));
		
		details.put("be", beList);
		details.put("mca",mcaList);
	}
	
	public List<Student> findByBranch(String branch) {
		return details.get(branch);
	}
}
