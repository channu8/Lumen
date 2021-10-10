package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class StudentRestApiConsumerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(StudentRestApiConsumerApplication.class, args);
	    
		WebClient client = ctx.getBean(WebClient.class);
		
		
	Flux<String> resp =	client.get().uri("http://localhost:6060/api/v1/students").retrieve().bodyToFlux(String.class);
		
		System.out.println(resp.blockFirst());
	
	}
	
	@Bean
	WebClient.Builder builder(){
		return WebClient.builder();
		
	}
	
	@Bean
	WebClient client (WebClient.Builder builderRef){
		return builderRef.build();
		
	}
	
	
	

}
