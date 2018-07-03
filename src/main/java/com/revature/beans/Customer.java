package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Customer extends Login {
	// Customer specific fields
	@Column
	private String billingAdress;
	private String shippingAddress;
	public String getBillingAdress() {
		return billingAdress;
	}
	public void setBillingAdress(String billingAdress) {
		this.billingAdress = billingAdress;
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
	public Customer(int id, String username, String password, String email) {
		super(id, username, password, email);
		// TODO Auto-generated constructor stub
	}
	public Customer(String billingAdress, String shippingAddress) {
		super();
		this.billingAdress = billingAdress;
		this.shippingAddress = shippingAddress;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((billingAdress == null) ? 0 : billingAdress.hashCode());
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
		if (billingAdress == null) {
			if (other.billingAdress != null)
				return false;
		} else if (!billingAdress.equals(other.billingAdress))
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
		return "Customer [billingAdress=" + billingAdress + ", shippingAddress=" + shippingAddress + "]";
	}
	
	
}
