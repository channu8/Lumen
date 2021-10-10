package com.example.demo.exceptions;

public class NameNotFoundException extends Exception {
	
	private String message;

	public NameNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "NameNotFoundException [message=" + message + "]";
	}

	

}
