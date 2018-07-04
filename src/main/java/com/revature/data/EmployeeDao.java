package com.revature.data;

import java.util.List;
import java.util.Set;

import com.revature.beans.Employee;
import com.revature.beans.Login;

public interface EmployeeDao {
		public void save(Employee employee);
		public Employee get(Login employee);
		public Set<Employee> getEmployees();
		public void update(Employee employee);
		public void delete(Employee employee);
		public List<Employee> list();
}


