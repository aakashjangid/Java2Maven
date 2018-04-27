package com.yash.employeedemo.daoimpl;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.yash.employeedemo.dao.EmployeeDAO;
import com.yash.employeedemo.model.Employee;
import com.yash.employeedemo.rowmapper.EmployeeMapper;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	private static final Logger logger = Logger.getLogger(EmployeeDAOImpl.class);

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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

	public boolean uploadEmployeesByExcel(MultipartFile file) {

		try {
			InputStream inputStream = new BufferedInputStream(file.getInputStream());

			Workbook workbook = WorkbookFactory.create(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			Row row;
			Employee employee;

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);
				String name = row.getCell(0).getStringCellValue();
				double salary = row.getCell(1).getNumericCellValue();
				String address = row.getCell(2).getStringCellValue();

				employee = new Employee(name, salary, address);
				insert(employee);
			}

			inputStream.close();
			return true;
		} catch (IOException e) {
			logger.error(e.getMessage());
		} catch (EncryptedDocumentException e) {
			logger.error(e.getMessage());
		} catch (InvalidFormatException e) {
			logger.error(e.getMessage());
		}

		return false;
	}

	@Scheduled(cron = "0 58 15 * * ?")
	public void scheduledBackup() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedbbackup", "root",
					"root");
			String sql = "INSERT INTO `employeedbbackup`.`backup` SELECT * FROM `employeedb1`.`employees` WHERE id NOT IN (SELECT backup.id FROM `employeedbbackup`.`backup`)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			statement.close();
			connection.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

}