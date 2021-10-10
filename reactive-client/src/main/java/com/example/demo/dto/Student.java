package com.example.demo.dto;

import java.time.LocalDate;

import lombok.*;



@Data
public class Student {

	int rollNumber;

	String studentName;

	LocalDate dateOfBirth;

	double markScored;

}
