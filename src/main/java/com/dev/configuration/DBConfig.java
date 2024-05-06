package com.dev.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Configuration
public class DBConfig {
	
	@Value("${spring.datasource.url}")
	private static String url;
	
	@Value("${spring.datasource.username}")
	private static String id;
	
	@Value("${spring.datasource.password}")
	private static String pass;
	
	
	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		DBConfig.url = url;
	}

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		DBConfig.id = id;
	}

	public static String getPass() {
		return pass;
	}

	public static void setPass(String pass) {
		DBConfig.pass = pass;
	}
	
	
	
	
	
	
	
	
}
