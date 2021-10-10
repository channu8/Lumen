package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
public class ClientController {

	@Autowired
	private WebClient client;
	
	
	
	
	@GetMapping(path="/rclient")
	public Mono<String> getBooks(){
		//give  header.setBasicAuth("invalid username","invalid password"). it wont open for bad credentials
		return client.get().uri("http://BOOK-SERVICE/books").retrieve().bodyToMono(String.class);
	}
	
	
	
}
