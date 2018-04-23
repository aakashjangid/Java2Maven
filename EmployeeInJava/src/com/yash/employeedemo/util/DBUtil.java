package com.yash.employeedemo.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {
	
	public PreparedStatement getStatement(String sql) {
		try {
			Context ctx=new InitialContext();                        
			DataSource ds=(DataSource)ctx.lookup("java:/comp/env/jdbc/mydb");   
			Connection connection=ds.getConnection();                    
			return connection.prepareStatement(sql);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}