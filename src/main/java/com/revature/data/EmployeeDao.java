package com.revature.data;

import java.util.List;
import java.util.Set;

import com.revature.beans.Employee;

public interface EmployeeDao {
	
		public void save(Employee employee);
		public Employee get(Employee employee);
		public Set<Employee> getEmployees();
		public void update(Employee employee);
		public void delete(Employee employee);
		public List<Employee> list();
	}


