package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="college_details")

@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
public class College {

	@Id
	@Column(name="id")
	int id;
	@Column(name="collegename")
	String collegeName;
	@Column(name="principalname")
	String principalName;
	@Column(name="location")
	String location;
}
