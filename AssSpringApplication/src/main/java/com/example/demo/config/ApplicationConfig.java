package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.entity.Student;



@Configuration
public class ApplicationConfig {
	
	@Bean
	@Profile(value="dev")
	public Student ram() {
		return new Student(101,"Ram",98);
	}
	
	@Bean
	@Profile(value="dev")
	public Student sam() {
		return new Student(102,"sam",96);
	}
	
	@Bean
	public Student raj() {
		return new Student(103,"raj",91);
	}

}
