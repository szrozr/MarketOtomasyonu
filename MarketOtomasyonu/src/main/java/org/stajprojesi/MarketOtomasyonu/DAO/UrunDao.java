package org.stajprojesi.MarketOtomasyonu.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.stajprojesi.MarketOtomasyonu.DataBase.DatabaseConnection;
import org.stajprojesi.MarketOtomasyonu.Model.UrunModel;

public class UrunDao {
	
		public ArrayList<UrunModel> getUrun() throws ClassNotFoundException {
			ArrayList<UrunModel> urunList = new ArrayList<>();
			

			Connection c = null;
		    String sql = "Select * from products";
		    
		    
		    try {
		         Connection con = DatabaseConnection.getConnection();
		         Statement st = con.createStatement();
		         ResultSet rs = st.executeQuery(sql);
		         
		         while(rs.next()) {
		        	
		        	 
		        UrunModel urunler = new UrunModel();
		         urunler.setId(rs.getInt("product_id"));
	        	 urunler.setProduct_name(rs.getString("product_name"));
	        	 urunler.setPrice(rs.getString("price"));
	        	 urunler.setQuantity(rs.getString("quantity"));
	        	 urunler.setBranch_id(rs.getString("branch_id"));
	        	 urunler.setBarkod_no(rs.getString("barkod_no"));
	        	 
		         urunList.add(urunler);
		        	
		         } 
		         
		    }catch (SQLException e) {
		        	 e.printStackTrace();
			            throw new RuntimeException(e);
				
				}finally {
					DatabaseConnection.close(c);
				}
				
				return urunList;
   
}
		}
