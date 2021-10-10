package com.example.demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyJsonParser {
	private Gson parser;
	

	public MyJsonParser() {
		super();
		this.parser = new GsonBuilder().setPrettyPrinting().create();
	}

	public String convertToJson(Product product) {
		
		return parser.toJson(product);
	}
	
	public Product jsonToJava(String value) {
		 
		
		return parser.fromJson(value, Product.class);
	}
}
