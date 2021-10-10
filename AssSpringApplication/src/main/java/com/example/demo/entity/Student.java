package com.example.demo.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults (level = AccessLevel.PRIVATE )
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	int id;
	String customerName;
	long phoneNumber;
	
	
	
	
	
}
