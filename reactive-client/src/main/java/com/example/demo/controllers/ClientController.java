package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.dto.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path ="/client/students")
public class ClientController {

	
	private WebClient client;
	private static String baseURI = "http://localhost:6060/api/v1/students";
	
	@Autowired
	public void setClient(WebClient client) {
		this.client=client;
	}
	
	@GetMapping
	public Flux<String> getAllStudents(){
		//give  header.setBasicAuth("invalid username","invalid password"). it wont open for bad credentials
		return client.get().uri(baseURI).headers(header-> header.setBasicAuth("india","india")).retrieve().bodyToFlux(String.class);
	}
	
	@GetMapping(path="/{rollNumber}") 
	public Mono<String> getStudentById(@PathVariable("rollNumber")int rollNumber){
		return client.get().uri(baseURI+"/{rollNumber}", rollNumber).retrieve().bodyToMono(String.class);
	}
	
	@PostMapping
	public Mono<Student> addStudent(@RequestBody Student entity){
		
		return client.post().uri(baseURI)
				.body(Mono.just(entity),Student.class
						).retrieve().bodyToMono(Student.class);
	}
	
	@DeleteMapping(path = "/{rollNumber}")
	public Mono<String> removeStudentById(@PathVariable("rollNumber") int rollNumber){
		
		return client.delete().uri(baseURI+"/{rollNumber}",rollNumber)
				.retrieve().bodyToMono(String.class);
	}
//	
//	@PutMapping(path="/{rollNumber}/{markToUpdate")
//	public Mono<String> updateMark(@PathVariable("rollNumber") int rollNumber,
//			@PathVariable("markToUpdate") double markToUpdate){
//		
//		return client.put().uri(baseURI + "/{rollNumber}/{markToUpdate}",rollNumber,markToUpdate)
//				.retrieve().bodyToMono(String.class);
//	}
//	
	
}
