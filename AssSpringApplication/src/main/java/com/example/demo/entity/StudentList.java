package com.example.demo.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.*;

@Component
@AllArgsConstructor
@Getter
@Setter
@ToString
//@Lazy //if not this then it is eager
public class StudentList {
	
	private Student student;
	
	public StudentList() {
		super();
		
		System.out.println("Student service called");
	}
		@Autowired
		List<Student> studentList;
	
		
		

}
