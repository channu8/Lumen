package com.example.demo.controllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.services.StudentService;

@RestController
@RequestMapping(path="/api/v1/students")
public class StudentController {
	@Autowired
	private StudentService service;
	public void setService(StudentService service ) {
		
		this.service=service;
	}
	
	//url mapping is prefixed with /api/followed by version number / followed
	//entity class name in plural and lowercase
	
	@GetMapping //(path="/api/v1/students") no need if declared at top
	@RolesAllowed(value= {"ROLE_ADMIN"})
	public List<Student> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping (path="/{rollNumber}") 
	@RolesAllowed(value= {"ROLE_ADMIN","ROLE_GUEST"})
	public Student findById(@PathVariable("rollNumber")int rollNumber){
		return this.service.findById(rollNumber);
	}
	
	
	@PostMapping //(path = "/api/v1/students")
	public ResponseEntity<Student> add(@RequestBody Student entity) {
		Student addedEntity = this.service.addStudent(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedEntity);
	}
	
	@PutMapping (path="/{rollNumber}/{markToUpdate}") 
	public ResponseEntity<String> updateMark(@PathVariable("rollNumber")int rollNumber,
			@PathVariable("markToUpdate") double markToUpdate){
		
		int count =  this.service.updateMark(rollNumber,markToUpdate);
		return ResponseEntity.ok().body(count+":RecordsUpdated0");
	}
	
	@GetMapping (path="/srch/{name}") 
	public List<Student> findByName(@PathVariable("name")String studentname){
		return this.service.findByName(studentname);
	}
	
	@DeleteMapping(path="/{rollNumber}")
	public ResponseEntity<String> removeStudent(@PathVariable("rollNumber") int rollNumber){
		
		int count =  this.service.remove(rollNumber);
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message="Record Not Found";
		
		if(count==1){
			
		        status=HttpStatus.OK;
				message =" One Record Deleted";
		}
		return ResponseEntity.status(status).body(message);
	
	}	
	
}
