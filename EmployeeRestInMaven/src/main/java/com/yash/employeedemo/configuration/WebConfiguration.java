package com.yash.employeedemo.configuration;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableScheduling
@ComponentScan(basePackages="com.yash")
public class WebConfiguration {
	
	private static final Logger logger = Logger.getLogger(WebConfiguration.class);
	
	@Bean
	public DataSource dataSource() {
		try {
			return (DataSource) new JndiTemplate().lookup("java:/comp/env/jdbc/mydb");
		} catch (NamingException e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	
}