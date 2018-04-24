package com.yash.employeedemo.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.yash.employeedemo.model.Employee;

public class EmployeeDAOTest {
	
	@Mock
	private EmployeeDAO employeeDAO;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);		
	}

	@Test
	public void testInsert_whenPassingEmployeeObject() {
		Employee employee = new Employee("Test", 15100, "Indore");
		when(employeeDAO.insert(employee)).thenReturn(1);
		int result = employeeDAO.insert(employee);
		assertEquals(1, result);
	}
	
	@Test
	public void testInsert_whenPassingNull() {
		Employee employee = new Employee("Test", 15100, "Indore");
		when(employeeDAO.insert(employee)).thenReturn(1);
		int result = employeeDAO.insert(null);
		assertEquals(0, result);
	}

	@Test
	public void testListAllEmployees() {
		
	}

}