package com.yash.employeedemo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBUtil {
	
	public PreparedStatement getStatement(String sql) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/employeedb1","root","root");
			return connection.prepareStatement(sql);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}