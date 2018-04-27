package com.yash.employeedemo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.yash.employeedemo.model.Employee;

public interface EmployeeService {

	public int insert(Employee employee);
	
	public List<Employee> getAllEmployees();

	public boolean insertFile(MultipartFile file);
	
}
