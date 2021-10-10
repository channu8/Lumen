package com.training.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Invoice;

import lombok.Data;


@Data
@Component
public class OrderBook {

	@Autowired
	private List<Invoice> invList;
	
}
