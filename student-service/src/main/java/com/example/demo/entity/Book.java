package com.example.demo.entity;

public class Book {

	private int BookNumber;
	private String BookName;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int bookNumber, String bookName) {
		super();
		BookNumber = bookNumber;
		BookName = bookName;
	}
	public int getBookNumber() {
		return BookNumber;
	}
	public void setBookNumber(int bookNumber) {
		BookNumber = bookNumber;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	@Override
	public String toString() {
		return "Book [BookNumber=" + BookNumber + ", BookName=" + BookName + "]";
	}
	
	
}
