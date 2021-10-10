package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.College;
import com.example.demo.service.CollegeService;

@RestController
@RequestMapping(path="/api/v1")
public class CollegeController {

	
	@Autowired
	private CollegeService service;
	
	@GetMapping(path="/colleges")
		public List<College> getAll(){
		return this.service.findAll();
	}
	
	@PostMapping(path="/colleges")
	public College add(@RequestBody College entity) {
		return this.service.add(entity);
	}
}
