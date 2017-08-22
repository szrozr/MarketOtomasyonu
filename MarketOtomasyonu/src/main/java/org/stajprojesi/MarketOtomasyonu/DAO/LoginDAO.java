package org.stajprojesi.MarketOtomasyonu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.stajprojesi.MarketOtomasyonu.DataBase.DatabaseConnection;

public class LoginDAO {
		
	
	
	public Boolean sonucDonder(String username,String password) throws ClassNotFoundException {
		Connection c = null;
		String sql = "Select * from users where username=? and password=?";
		
		try {
			c=DatabaseConnection.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs =  ps.executeQuery();
			
			if(rs.next())
				return true;
			
			else
				return false;
		} catch(SQLException e) {
			 e.printStackTrace();
	            throw new RuntimeException(e);
		}finally {
			DatabaseConnection.close(c);
		}
	
	}
}
