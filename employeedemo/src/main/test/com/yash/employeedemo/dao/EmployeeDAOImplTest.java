package com.yash.employeedemo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.yash.employeedemo.daoimpl.EmployeeDAOImpl;
import com.yash.employeedemo.model.Employee;

public class EmployeeDAOImplTest {

	private EmployeeDAO EmployeeDAO;
	
	@Before
	public void setUp() {
		EmployeeDAO = new EmployeeDAOImpl();
	}
	
	@Test
	public void testInsertWhenPassingEmployeeObject() {
		Employee employee = new Employee("Aakash",15500,"Indore");
		int result = EmployeeDAO.insert(employee);
		assertEquals(1, result);
	}
	
	@Test(expected=NullPointerException.class)
	public void testInsertWhenPassingNull() {
		int result = EmployeeDAO.insert(null);
		assertEquals(0, result);
	}
	
	@Test
	public void testInsertWhenPassingEmptyEmployeeObject() {
		Employee employee = new Employee();
		int result = EmployeeDAO.insert(employee);
		assertEquals(0, result);
	}

	@Test
	public void testListAllEmployeesReturnsTheListFromDB() {
		Employee employee = new Employee("Aakash",15500,"Indore");
		EmployeeDAO.insert(employee);
		List<Employee> employees = EmployeeDAO.listAllEmployees();
		assertFalse(employees.isEmpty());
	}
	
	@Test
	public void testListAllEmployeesReturnsTheLastElementAdded() {
		Employee employee = new Employee("Aakash",15500,"Indore");
		EmployeeDAO.insert(employee);
		List<Employee> employees = EmployeeDAO.listAllEmployees();
		int position = employees.size()-1;
		Employee lastEmployee = employees.get(position);
		assertEquals(employee.getName(), lastEmployee.getName());
	}
	
	@Test
	public void testListAllEmployeesBySizeOfTheReturningList() {
		Employee employee1 = new Employee("Aakash1",15500,"Indore");
		EmployeeDAO.insert(employee1);
		Employee employee2 = new Employee("Aakash2",15500,"Indore");
		EmployeeDAO.insert(employee2);
		List<Employee> employees = EmployeeDAO.listAllEmployees();
		assertEquals(2,employees.size());
	}

}