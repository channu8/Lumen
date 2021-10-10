package com.example.demo.comtrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

	
	@Autowired
	private RestTemplate template;
	
	@GetMapping(path = "/client")
	public String getBooks() {
		
		//portnumber is not used here
		//eureka service registers client classes in it which can be referred 
		return this.template.getForObject("http://BOOK-SERVICE/books",String.class);
	}
	
}
