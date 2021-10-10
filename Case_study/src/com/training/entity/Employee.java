package com.training.entity;

import java.time.LocalDate;

public class Employee {
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private String address;
	private String emailAddress;
	private long phoneNumber;
	private LocalDate birthday;
	private LocalDate weddingAnniversary;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee( String firstName, long phoneNumber) {
		super();
		this.firstName = firstName;
		this.phoneNumber = phoneNumber;
		}
	public Employee( String firstName,String emailAddress) {
		super();
		this.firstName = firstName;
		this.emailAddress = emailAddress;
		}

	
	public Employee(int employeeId, String firstName, String lastName, String address, String emailAddress,
			long phoneNumber, LocalDate birthday, LocalDate weddingAnniversary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		this.weddingAnniversary = weddingAnniversary;
	}




	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public LocalDate getWeddingAnniversary() {
		return weddingAnniversary;
	}

	public void setWeddingAnniversary(LocalDate weddingAnniversary) {
		this.weddingAnniversary = weddingAnniversary;
	}

	

	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber
				+ ", birthday=" + birthday + ", weddingAnniversary=" + weddingAnniversary + "]";
	}
	
	
	
	

}
