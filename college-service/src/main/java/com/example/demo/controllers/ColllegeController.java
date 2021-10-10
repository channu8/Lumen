package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class ColllegeController {

	@GetMapping(path="/colleges")
	public String getCollege() {
		return "KLETECH Hubli";
	}
}
