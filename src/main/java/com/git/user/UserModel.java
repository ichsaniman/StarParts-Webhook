package com.git.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

import com.dev.configuration.DBEngine;

public class UserModel {
	public static boolean checkUser(String phone, DataSourceProperties ds) {
		boolean result = false;
		try {
			String sql = "SELECT * FROM \"SP_OUTLET\" WHERE \"OUTLET_PHONE\" = '"+phone+"'";
			Connection con = DBEngine.getConnection(ds);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}
}
