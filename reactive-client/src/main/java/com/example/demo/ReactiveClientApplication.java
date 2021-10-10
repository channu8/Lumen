package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ReactiveClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveClientApplication.class, args);
	}
	
	/*
	 * @SpringBootApplication has @Configuration annotation into it
	 * so we can declare factory methods with @Bean in this class itself
	 * Instead of creating a separate class with @Configuration annotation
	 */
	
	@Bean
	WebClient.Builder builder(){
		
		return WebClient.builder();
	}
	
	@Bean
	WebClient client(WebClient.Builder builderRef){
		
		return builderRef.build();
	}

}
