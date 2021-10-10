package com.example.demo.service;
import com.example.demo.entity.*;
import com.example.demo.ifaces.CollegeRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollegeService {

	@Autowired
	private CollegeRepository repo;
	
	public List<College> findAll(){
		
		return this.repo.findAll();
		}
	
	public College add(College entity) {
		return this.repo.save(entity);
	}
}
