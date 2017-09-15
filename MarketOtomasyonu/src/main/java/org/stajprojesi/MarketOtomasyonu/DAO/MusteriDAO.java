package org.stajprojesi.MarketOtomasyonu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.stajprojesi.MarketOtomasyonu.DataBase.DatabaseConnection;
import org.stajprojesi.MarketOtomasyonu.Model.MusteriModel;

public class MusteriDAO {
	
	MusteriModel musteriModel = new MusteriModel();
	
	
	public MusteriModel getMusteri(int musteri_no) throws ClassNotFoundException{		
		
		Connection con = null;
		String sql = "Select * from customers where customer_id = ?";
		
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement ps = null;
			ps = con.prepareStatement(sql);
			ps.setInt(1, musteri_no);
		    ResultSet rs = ps.executeQuery();
		    
		    
		    while(rs.next()) {
		    	MusteriModel musteriler = new MusteriModel();
		    	musteriler.setCustomer_id(rs.getInt("customer_id"));
		    	musteriler.setName(rs.getString("name"));
		    	musteriler.setSurname(rs.getString("surname"));
		    	musteriler.setTel(rs.getString("tel"));
		    	musteriler.setAddress(rs.getString("address"));
		    	musteriler.setBranch_id(rs.getInt("branch_id"));
		    	
		      this.musteriModel = musteriler;
		    }
			
		}catch (SQLException e) {
				e.printStackTrace();
			    throw new RuntimeException(e);
	
			}finally {
				DatabaseConnection.close(con);
			}
				return musteriModel;
	}

}
