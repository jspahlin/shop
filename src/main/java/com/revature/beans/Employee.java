package com.revature.beans;

import javax.persistence.Entity;

@Entity
public class Employee extends Customer {

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String username, String password, String email, String billingAddress,
			String shippingAddress) {
		super(id, username, password, email, billingAddress, shippingAddress);
	}
	
	
	@Override
	public String toString() {
		return "Employee [getBillingAdress()=" + getBillingAdress() + ", getShippingAddress()=" + getShippingAddress()
				+ ", getId()=" + getId() + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword()
				+ ", getEmail()=" + getEmail() + "]";
	}



}
