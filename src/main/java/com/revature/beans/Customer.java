package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Customer extends Login {
	// Customer specific fields
	@Column
	private String billingAddress;
	private String shippingAddress;
	public String getBillingAdress() {
		return billingAddress;
	}
	public void setBillingAdress(String billingAdress) {
		this.billingAddress = billingAdress;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int id, String username, String password, String email, String billingAddress, String shippingAddress) {
		super(id, username, password, email);
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
	}
	@Override
	public String toString() {
		return "Customer [billingAddress=" + billingAddress + ", shippingAddress=" + shippingAddress + ", getId()="
				+ getId() + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword() + ", getEmail()="
				+ getEmail() + ", getClass()=" + getClass() + "]";
	}
	
}
