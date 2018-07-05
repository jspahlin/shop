package com.revature.controller;

import org.springframework.stereotype.Component;

import com.revature.beans.Admin;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.beans.Login;

@Component
public class UserAndRole {
	public Login user;
	public String role;
	
	public UserAndRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	UserAndRole(Login user) {
		this.user = user;
		if(user instanceof Admin) {
			this.role = "ADMIN";
		} else if (user instanceof Employee) {
			this.role = "EMPLOYEE";
		} else if (user instanceof Customer) {
			this.role = "CUSTOMER";
		} else if (user instanceof Login) {
			this.role = "LOGIN";
		} else {
			this.role = "HUH";
		}
	}

	public Login getUser() {
		return user;
	}

	public void setUser(Login user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
