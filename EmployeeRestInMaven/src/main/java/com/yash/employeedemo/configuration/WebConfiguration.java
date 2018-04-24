package com.yash.employeedemo.configuration;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.yash")
public class WebConfiguration {
	
	@Bean
	public DataSource dataSource() {
		try {
			return (DataSource) new JndiTemplate().lookup("java:/comp/env/jdbc/mydb");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}