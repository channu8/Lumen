package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class BookController {

	
	@Value("${server.port}")
	private String port;
	
	@GetMapping(path="/books")
	public String getBooks() {
		return "Java,Dotnet=="+this.port;
	}
}
