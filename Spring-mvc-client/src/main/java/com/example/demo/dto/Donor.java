package com.example.demo.dto;

import java.time.LocalDate;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Donor {
    
	//@UniqueElements 
	int donorId;
	//@Length(min=3,max=20,message="Name should be 3 to 20 characters")
	String donorName;
	//@Range(min=1000000000,max=99999999,message="Mobile Number should be 10 digits")
	long mobileNumber;
	
	String bloodGroup;
	@DateTimeFormat(iso=ISO.DATE)
	LocalDate lastDonationDate;
	String address;
}
