package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="donor")
public class Donor {

	
	@Id
	@Column(name = "donorId")
	int donorId;
	@Column(name = "donorname")
	String donorName;
	@Column(name = "mobilenumber")
	long mobileNumber;
	@Column(name = "bloodgroup")
	String bloodGroup;
	@Column(name = "lastdonationdate")
	LocalDate lastDonationDate;
	@Column(name = "address")
	String address;
}
