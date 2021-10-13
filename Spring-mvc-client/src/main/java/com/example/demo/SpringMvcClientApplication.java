package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication(scanBasePackages = {"com.example.demo.controllers"})
@ComponentScan
public class SpringMvcClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcClientApplication.class, args);
	}
	
	@Bean
	public ModelAndView mdlView() {
		return new ModelAndView();
	}
	
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}

}
