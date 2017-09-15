package org.stajprojesi.MarketOtomasyonu.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/marketdb?user=root&password=asd123123");
			}catch (SQLException e) {
			throw e;
		}
		
	}
	
	
	public static void close(Connection connection)
	{
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
