package com.yash.employeedemo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.employeedemo.model.Employee;
import com.yash.employeedemo.service.EmployeeService;
import com.yash.employeedemo.serviceimpl.EmployeeServiceImpl;

@WebServlet("/AddEmployeeController")
public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService;

	public AddEmployeeController() {
		super();
		employeeService = new EmployeeServiceImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		double salary = Double.parseDouble(request.getParameter("salary"));
		String address = request.getParameter("address");
		Employee employee = new Employee(name, salary, address);
		int success = employeeService.insert(employee);
		if (success == 1) {
			getServletContext().getRequestDispatcher("/ListEmployeesController").forward(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

}