package com.yash.employeedemo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yash.employeedemo.dao.EmployeeDAO;
import com.yash.employeedemo.model.Employee;
import com.yash.employeedemo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	public int insert(Employee employee) {
		return employeeDAO.insert(employee);
	}

	public List<Employee> getAllEmployees() {
		return employeeDAO.listAllEmployees();
	}

	public boolean insertFile(MultipartFile file) {
		return employeeDAO.uploadEmployeesByExcel(file);
	}

}