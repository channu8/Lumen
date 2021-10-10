package com.example.demo.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

import lombok.*;
import lombok.experimental.FieldDefaults;



@Data
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
	@Range(max=1000,min=100,message="Number should be between 100-1000")
	int rollNumber;
	@Length(min=3,max=20,message="Name should be 3 to 20 characters")
	String studentName;
	@DateTimeFormat(iso=ISO.DATE)
	LocalDate dateOfBirth;
	
	double markScored;

}
