package com.javaweb.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Create the domain class Customer to map with the table customer in the database

// use the annotation @Entity to map this class to the table customer (the class has same name as the table
@Entity
public class Customer {
	// he field id is annotated with @Id and @GeneratedValue annotations to indicate that this field is primary key and its value is auto generated. 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String address;

	protected Customer() {
	}

	protected Customer(String name, String email, String address) {
		this.name = name;
		this.email = email;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

}
