package com.revature.data;

import com.revature.beans.Customer;
import com.revature.beans.Login;

public interface CustomerDao {

	public Customer get(Login customer);

//	public void insert(Customer customer);
//	public Set<Customer> getCustomers();
//	public void update(Customer customer);
//	public void delete(Customer customer);
//	public List<Customer> list();
}


