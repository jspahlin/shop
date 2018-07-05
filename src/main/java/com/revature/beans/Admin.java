package com.revature.beans;
import javax.persistence.Entity;

@Entity
public class Admin extends Employee {

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int id, String username, String password, String email, String billingAddress,
			String shippingAddress) {
		super(id, username, password, email, billingAddress, shippingAddress);
	}



	@Override
	public String toString() {
		return "Admin [getBillingAdress()=" + getBillingAdress() + ", getShippingAddress()=" + getShippingAddress()
				+ ", getId()=" + getId() + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword()
				+ ", getEmail()=" + getEmail() + "]";
	}

}
