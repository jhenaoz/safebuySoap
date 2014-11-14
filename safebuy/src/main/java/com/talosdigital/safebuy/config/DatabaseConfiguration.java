package com.talosdigital.safebuy.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DatabaseConfiguration implements EnvironmentAware{

	private RelaxedPropertyResolver propertyResolver;
	
	@Override
	public void setEnvironment(Environment environment) {
		this.propertyResolver = new RelaxedPropertyResolver(environment);	
	}

	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){
		LocalContainerEntityManagerFactoryBean localContainerFactory = new LocalContainerEntityManagerFactoryBean();
		localContainerFactory.setDataSource(dataSource);
		localContainerFactory.setPackagesToScan("com.talosdigital.safebuy.model");
		localContainerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		localContainerFactory.setJpaProperties(additionalProperties());
		return localContainerFactory;
		
	}
//	@Bean
//	public JpaVendorAdapter vendorAdapter(){
//		return new HibernateJpaVendorAdapter();
//	}
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername(propertyResolver.getProperty("username"));
		dataSource.setPassword(propertyResolver.getProperty("password"));
		dataSource.setDriverClassName(propertyResolver.getProperty("driverClassName"));
		dataSource.setUrl(propertyResolver.getProperty("url"));
		return dataSource;
	}
	
//	@Bean
//	public JpaTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean emf){
//		JpaTransactionManager transactionManager = new JpaTransactionManager();
//		transactionManager.setEntityManagerFactory((EntityManagerFactory) emf.nativeEntityManagerFactory);
//		// No idea it this cast will work....... :( ^^^^^^^^^^^^^^^^^^^
//		//note: that think work no idea why
//		return transactionManager;
//	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}
	
	Properties additionalProperties(){
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		properties.setProperty("hibernate.show_sql", "true");
		return properties;
	}
	
}
