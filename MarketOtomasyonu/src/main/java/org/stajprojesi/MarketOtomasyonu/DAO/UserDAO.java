package org.stajprojesi.MarketOtomasyonu.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.stajprojesi.MarketOtomasyonu.DataBase.DatabaseConnection;
import org.stajprojesi.MarketOtomasyonu.Model.UserModel;

public class UserDAO {
	
	public UserModel getUser(String user_name) throws ClassNotFoundException {
		UserModel user = new UserModel();
		
		Connection c = null;
		String sql = "Select password from users where username = ? ";
		
		try {
		c=	DatabaseConnection.getConnection();
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, user_name);
		ResultSet rs = ps.executeQuery();
		
		//Statement s = c.createStatement();
		//ResultSet rs = s.executeQuery(sql);
		if(rs.next())
		{
			//user.setId(rs.getInt("user_id"));
			//user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			//user.setFirstname(rs.getString("firstname"));
			//user.setLastname(rs.getString("lastname"));
			//user.setRole(rs.getString("role"));
		}
		}catch(SQLException e) {
			 e.printStackTrace();
	            throw new RuntimeException(e);
		}finally {
			DatabaseConnection.close(c);
		}
		
		return user;
		
	}
}
