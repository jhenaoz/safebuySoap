package com.talosdigital.safebuy.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.web.servlet.DispatcherServlet;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;

@ComponentScan("com.talosdigital.safebuy")
@EnableAutoConfiguration
public class Application {
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
//	@Bean
//	public InternalResourceViewResolver viewResolver(){
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setViewClass(JstlView.class);
//		return viewResolver;
//	}
	
//	@Bean
//	public ServletRegistrationBean distpacher(DispatcherServlet safebuy){
//	    ServletRegistrationBean servlet = new ServletRegistrationBean(
//	            safebuy);
//	    
//	    servlet.addUrlMappings("/");
//	    servlet.addUrlMappings("/ws/*");
//	    //ASK WHY WHEN I CHANGE THE URL MAPPINGS DOESN'T WORK
//	    return servlet;
//	}
	
//	@Bean
//	public DispatcherServlet dispatcherServlet(){
//		return new DispatcherServlet();
//	}
}
