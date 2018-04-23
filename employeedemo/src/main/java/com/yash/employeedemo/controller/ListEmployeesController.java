package com.yash.employeedemo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.employeedemo.model.Employee;
import com.yash.employeedemo.service.EmployeeService;
import com.yash.employeedemo.serviceimpl.EmployeeServiceImpl;

/**
 * Servlet implementation class ListEmployeesController
 */
@WebServlet("/ListEmployeesController")
public class ListEmployeesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService;
	
    public ListEmployeesController() {
        super();
        employeeService = new EmployeeServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> employees = employeeService.getAllEmployees();
		request.setAttribute("employees", employees);
		request.getRequestDispatcher("/listemployees.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Employee> employees = employeeService.getAllEmployees();
		req.setAttribute("employees", employees);
		req.getRequestDispatcher("/listemployees.jsp").forward(req, resp);
	}

}