package com.example.demo;


import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.entity.Bill;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Invoice;

import com.example.demo.entity.Product;
import com.training.entity.OrderBook;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication(scanBasePackages = {"com.example.demo","com.training.entity"})
@Slf4j
public class SpringIoCApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(SpringIoCApplication.class, args);
	    
		System.out.println(ctx.getClass().getName());
		
		Customer customer=ctx.getBean("sam",Customer.class);
	   log.info(customer.toString());
	   
	   Product obj = ctx.getBean("Sony", Product.class);
	   log.info(obj.toString());
	   
	   Invoice inv = ctx.getBean("invoice",Invoice.class);
	   log.info(inv.toString());
	   
	   Bill bill = ctx.getBean(Bill.class);
	   log.info(bill.toString());
	   
	   OrderBook orderBook = ctx.getBean(OrderBook.class);
	   log.info(orderBook.toString());
	   
	   List<Invoice> list= orderBook.getInvList();
	   list.forEach(System.out::println);
		ctx.close();
	}

}
