package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("invoice")
public class Invoice {

	private Product product;
	private Customer customer;
	public Product getProduct() {
		return product;
	}
	
	@Override
	public String toString() {
		return "Invoice [product=" + product + ", customer=" + customer + "]";
	}
    
	//Setter dependency injection used
	@Autowired
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	public Customer getCustomer() {
		return customer;
	}
	
	
	//setter DI used
  //  @Autowired
	public void setCustomer( Customer customer) {
		this.customer = customer;
	}
	
    @Autowired
	public Invoice(Product product,@Qualifier("sam") Customer customer) {
		super();
		this.product = product;
		this.customer = customer;
	}

	
    
	
	
}
