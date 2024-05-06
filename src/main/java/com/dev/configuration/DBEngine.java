package com.dev.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;


public class DBEngine {
	
	
	
	 
	
	public static Connection getConnection(DataSourceProperties ds) {
		 Connection conn = null;
	        try {
	        	String url = ds.determineUrl();
	        	String id = ds.determineUsername();
	        	String pass = ds.determinePassword();
	        	System.out.println(url);
	            conn = DriverManager.getConnection(url, id, pass);
//	            System.out.println("Connected to the PostgreSQL server successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return conn;
	    }
}
