package org.example.demo;

public class Student {
	

	private int id;
	private String name;
	private double markscored;
	
	public Student() {
		super();
		
	}
	public Student(int id, String name, double markscored) {
		super();
		this.id = id;
		this.name = name;
		this.markscored = markscored;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarkscored() {
		return markscored;
	}
	public void setMarkscored(double markscored) {
		this.markscored = markscored;
	}

}
