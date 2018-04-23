package com.yash.employeedemo.serviceimpl;

import java.util.List;

import com.yash.employeedemo.dao.EmployeeDAO;
import com.yash.employeedemo.daoimpl.EmployeeDAOImpl;
import com.yash.employeedemo.model.Employee;
import com.yash.employeedemo.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	public EmployeeServiceImpl() {
		this.employeeDAO = new EmployeeDAOImpl();
	}

	@Override
	public int insert(Employee employee) {
		return employeeDAO.insert(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDAO.listAllEmployees();
	}

}