package com.example.demo.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Component
@FieldDefaults(level= AccessLevel.PRIVATE)
public class DonationCamp {

	int bloodCampId;
	String bloodCampName;
	String organisers;
	@DateTimeFormat(iso=ISO.DATE)
	LocalDate eventDate;
	String location;
}
