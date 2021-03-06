package com.decorpot.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.decorpot.spring.config", "com.decorpot.spring.controller", "com.decorpot.*" })
public class WebConfig extends WebMvcConfigurerAdapter {
 
    @Bean
    public InternalResourceViewResolver jspViewResolver() {
    	System.out.println("WebConfig:InternalResourceViewResolver");
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        return bean;
    }
 
    @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	System.out.println("WebConfig:addResourceHandlers");
		registry.addResourceHandler("/resources/**")
		.addResourceLocations("/resources/")
		.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/views/**").addResourceLocations("/views/**");
	}
    
    @Bean
	public DataSource getDataSource() {
    	System.out.println("WebConfig:getDataSource");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://decorpotdb.cdah17t6tkzr.us-west-2.rds.amazonaws.com");
		dataSource.setUsername("decorpot");
		dataSource.setPassword("Interior1");
		System.out.println("datasource = "+dataSource);
		return dataSource;
	}
}
