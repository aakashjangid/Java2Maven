package com.yash.employeedemo.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.yash.employeedemo.dao.EmployeeDAO;
import com.yash.employeedemo.model.Employee;
import com.yash.employeedemo.util.DBUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private DBUtil dbUtil;
	private static final Logger LOGGER=Logger.getLogger(EmployeeDAOImpl.class);
	
	public EmployeeDAOImpl() {
		this.dbUtil = new DBUtil(); 
	}

	public int insert(Employee employee) {
		int success = 0;
		String sql = "INSERT INTO employees(name, salary, address) VALUES(?,?,?)";
		try {
			PreparedStatement pstmt = dbUtil.getStatement(sql);
			pstmt.setString(1, employee.getName());
			pstmt.setDouble(2, employee.getSalary());
			pstmt.setString(3, employee.getAddress());
			success = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return success;
	}

	public List<Employee> listAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee = null;
		String sql = "SELECT * FROM employees";
		try {
			PreparedStatement pstmt = dbUtil.getStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setSalary(rs.getDouble("salary"));
				employee.setAddress(rs.getString("address"));
				employees.add(employee);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return employees;
	}

}