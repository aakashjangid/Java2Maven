package com.yash.employeedemo.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class DBUtil {
	
	private static final Logger LOGGER=Logger.getLogger(DBUtil.class);
	
	public PreparedStatement getStatement(String sql) {
		try {
			Context ctx=new InitialContext();                        
			DataSource ds=(DataSource)ctx.lookup("java:/comp/env/jdbc/mydb");   
			LOGGER.info(ds);
			Connection connection=ds.getConnection();
			LOGGER.info(connection);
			return connection.prepareStatement(sql);
		}catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/employeedb1","root","root");
//			return connection.prepareStatement(sql);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
		return null;
	}

}