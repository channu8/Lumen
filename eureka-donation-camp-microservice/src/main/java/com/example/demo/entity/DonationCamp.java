package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="bloodcamp")
public class DonationCamp {
	
	@Id
	@Column(name="bloodcampid")
	int bloodCampId;
	@Column(name="bloodcampname")
	String bloodCampName;
	@Column(name="organisers")
	String organisers;
	@Column(name="eventdate")
	LocalDate eventDate;
	@Column(name="location")
	String location;

	
}
