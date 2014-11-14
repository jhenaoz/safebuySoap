package com.talosdigital.safebuy.config;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

public class WebServiceConfiguration {
	
	@Bean
	public ServletRegistrationBean DispatcherServlet(ApplicationContext appContext){
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(appContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/ws/*");
		
	}
	
	@Bean
	public DefaultWsdl11Definition defaultWsdlDefinition(XsdSchema buyerSchema){
		DefaultWsdl11Definition wsdlDefinition = new DefaultWsdl11Definition();
		wsdlDefinition.setPortTypeName("BuyerPort");
		wsdlDefinition.setLocationUri("/ws");
		wsdlDefinition.setTargetNamespace("");
		wsdlDefinition.setSchema(buyerSchema);
		return wsdlDefinition;
	}
	
	@Bean
	public XsdSchema buyerSchema(){
		return new SimpleXsdSchema(new ClassPathResource("buyer.xsd"));
	}
}
