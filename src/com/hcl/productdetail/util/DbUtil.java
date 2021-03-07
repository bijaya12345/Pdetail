package com.hcl.productdetail.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/products";
	public static final String USER_NAME = "root";
	public static final String PASSWORD = "root";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_NAME);
		return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
	}

}
