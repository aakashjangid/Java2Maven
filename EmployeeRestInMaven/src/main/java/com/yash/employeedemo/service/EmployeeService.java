package com.yash.employeedemo.service;

import java.util.List;

import com.yash.employeedemo.model.Employee;

public interface EmployeeService {

	public int insert(Employee employee);
	
	public List<Employee> getAllEmployees();
	
}
