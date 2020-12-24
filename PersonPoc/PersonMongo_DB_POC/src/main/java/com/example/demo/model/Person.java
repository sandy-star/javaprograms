package com.example.demo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Person")
public class Person {

	@Id
	@Field(name = "id")
	private int pId;

	@Field(name = "firstName")
	private String firstName;

	@Field(name = "lastName")
	private String lastName;

	@Field(name = "dob")
	private Date creationDate = new Date();

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Person(int pId, String firstName, String lastName, Date creationDate) {
		super();
		this.pId = pId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.creationDate = creationDate;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
