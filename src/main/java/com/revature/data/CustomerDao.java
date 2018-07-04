package com.revature.data;

import java.util.List;
import java.util.Set;

import com.revature.beans.Customer;
import com.revature.beans.Login;

public interface CustomerDao {


		public void insert(Customer customer);
		public Customer get(Login customer);
		public Set<Customer> getCustomers();
		public void update(Customer customer);
		public void delete(Customer customer);
		public List<Customer> list();
}


