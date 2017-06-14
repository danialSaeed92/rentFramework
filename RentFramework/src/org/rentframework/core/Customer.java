/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the MIT License (MIT);
 * 
 */
package org.rentframework.core;

import org.rentframework.factory.Person;


public class Customer implements Person {
	private int customerId;
	private String firstName;
	private String lastName;
	private String middleName;
	private Address address;
	private String email;

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Override
	public String getMiddleName() {
		return middleName;
	}

	@Override
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public Address getAddress() {
		return address;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String getEmail() {
		return email;
	}
	@Override
	public void setPersonId(int personId) {
		this.customerId = personId;
	}
	@Override
	public int getPersonId() {
		return customerId;
	}
	
	public String getFullName(){
		return getFirstName() +" "+ getMiddleName()+ " "+getLastName();
	}
	

}
