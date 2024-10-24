package com.db;

import java.sql.*;

public class DBConnect {
	
	private static Connection connection = null;
	
	
	public static Connection connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_db", "root", "12345678");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
	public static void destroy() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
