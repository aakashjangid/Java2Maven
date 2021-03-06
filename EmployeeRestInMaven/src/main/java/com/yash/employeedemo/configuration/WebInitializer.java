package com.yash.employeedemo.configuration;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebConfiguration.class };
	}

	
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}


	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{ };
	}

	
	@Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

        // upload temp file will put here
        File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));

        // register a MultipartConfigElement
        MultipartConfigElement multipartConfigElement =
                new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
                        5000000, 5000000 * 2, 5000000 / 2);

        registration.setMultipartConfig(multipartConfigElement);
    }

}