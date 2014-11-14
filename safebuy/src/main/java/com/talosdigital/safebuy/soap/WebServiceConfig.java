package com.talosdigital.safebuy.soap;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter{

	@Bean
	public ServletRegistrationBean dispatcherServlet(ApplicationContext applicationContext){
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet , "/ws/*");
	}
	
	
//	IMPORTANT NOTE:, FOR ACCCES THE WSDL DEFINITION GO TO THE URL BELOW
//	buyers, is the name of the bean
//	ws is the location uri
//	8080 is the tomcat or embebed server port
//	http://localhost:8080/ws/buyers.wsdl
	@Bean(name = "buyers")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema buyersSchema){
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("BuyersPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://talosdigital.com/buyer");
		wsdl11Definition.setSchema(buyersSchema);
		return wsdl11Definition;
	}
	
	@Bean
	public XsdSchema buyersSchema() {
		return new SimpleXsdSchema(new ClassPathResource("buyer.xsd"));
	}
	
//	@Bean
//	public XsdSchema buyerRetrieveSchema(){
//		return new SimpleXsdSchema(new ClassPathResource("xsd/buyerRetrive.xsd"));
//	}
//	
//	@Bean
//	public XsdSchema buyerCreateSchema(){
//		return new SimpleXsdSchema(new ClassPathResource("xsd/buyerCreate.xsd"));
//	}
//	@Bean
//	public XsdSchema buyerDeleteSchema(){
//		return new SimpleXsdSchema(new ClassPathResource("xsd/buyerDelete.xsd"));
//	}
}
