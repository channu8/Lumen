package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Bill;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Invoice;
import com.example.demo.entity.Product;

@Configuration
public class ApplicationConfig {

	
	//Factory Method
	//Spring IoC container will call this method and
	//register a bean with id "Ram"
	//"Ram" being the method name.
	@Bean
	public Customer ram() {
		return new Customer(101,"Ram",9837393845L);
	}
	
	@Bean
	public Customer sam() {
		return new Customer(102,"sam",9855393845L);
	}
	
	//Spring IoC container will call this method and
	//register a bean with id "sony"
	//"sony" being the attribute name.
	//overriding the default name which is method name with custom name
	@Bean(name="Sony")
	public Product tv() {
		
		return new Product(202,"Sony",25000);	}
	
	//Refering a Bean by its Id
	@Bean
	public Bill inv() {
		
		return new Bill(tv(),ram());
	}
	
	@Bean(name = "ramsInvoice")
	public Invoice ramsInv() {
		return new Invoice(tv(),ram());
	}
	
}
