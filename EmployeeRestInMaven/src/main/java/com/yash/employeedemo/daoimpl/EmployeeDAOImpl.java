package com.yash.employeedemo.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yash.employeedemo.dao.EmployeeDAO;
import com.yash.employeedemo.model.Employee;
import com.yash.employeedemo.rowmapper.EmployeeMapper;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int insert(Employee employee) {
		int success = 0;
		String sql = "INSERT INTO employees(name, salary, address) VALUES(?,?,?)";
		try {
			success = jdbcTemplate.update(sql, employee.getName(), employee.getSalary(), employee.getAddress());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	public List<Employee> listAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT * FROM employees";
		try {
			employees = jdbcTemplate.query(sql, new EmployeeMapper());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

}