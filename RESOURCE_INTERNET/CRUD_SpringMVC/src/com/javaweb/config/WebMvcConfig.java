package com.javaweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// This class is annotated with the @Configuration  annotation to tell Spring framework that this is a configuration class.
@Configuration
// The @ComponentScan annotation tells Spring to scan for configuration classes in the "com.javaweb" package
@ComponentScan("com.javaweb ")
public class WebMvcConfig {
	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	// You can add more Spring MVC configurations here.
}