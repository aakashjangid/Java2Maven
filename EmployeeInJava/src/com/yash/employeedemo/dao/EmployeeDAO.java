package com.yash.employeedemo.dao;

import java.util.List;

import com.yash.employeedemo.model.Employee;

public interface EmployeeDAO {

	public int insert(Employee employee);
	
	public List<Employee> listAllEmployees();
	
}
