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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((billingAddress == null) ? 0 : billingAddress.hashCode());
		result = prime * result + ((shippingAddress == null) ? 0 : shippingAddress.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (billingAddress == null) {
			if (other.billingAddress != null)
				return false;
		} else if (!billingAddress.equals(other.billingAddress))
			return false;
		if (shippingAddress == null) {
			if (other.shippingAddress != null)
				return false;
		} else if (!shippingAddress.equals(other.shippingAddress))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [billingAddress=" + billingAddress + ", shippingAddress=" + shippingAddress + "]";
	}
	
	
}
