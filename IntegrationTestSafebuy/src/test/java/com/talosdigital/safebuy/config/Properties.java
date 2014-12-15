package com.talosdigital.safebuy.config;

public class Properties {
	
//SOAP Configuration------------------------------------------------------------
	public static final String URL = "http://localhost:8080/ws/";
	public static final String NAMESPACE = "http://talosdigital.com/buyer" ;
	
//Database Configuration--------------------------------------------------------
	public static final String JDBC_DRIVER = "org.postgresql.Driver";  
	public static final String DB_URL = "jdbc:postgresql://localhost:5432/safebuy";
	public static final String USER = "postgres";
	public static final String PASS = "postgres";
}
