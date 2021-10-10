package com.training.entity;

import java.time.LocalDate;

public class Student {
	
	private int rollNumber;
	private String studentName;
	private LocalDate dateOfBirth;
	private double markScored;
	public Student() {
		super();

	}
	public Student(int rollNumber, String studentName, LocalDate dateOfBirth, double markScored) {
		super();
		this.rollNumber = rollNumber;
		this.studentName = studentName;
		this.dateOfBirth = dateOfBirth;
		this.markScored = markScored;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public double getMarkScored() {
		return markScored;
	}
	public void setMarkScored(double markScored) {
		this.markScored = markScored;
	}
	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", studentName=" + studentName + ", dateOfBirth=" + dateOfBirth
				+ ", markScored=" + markScored + "]";
	}
	
	

}
