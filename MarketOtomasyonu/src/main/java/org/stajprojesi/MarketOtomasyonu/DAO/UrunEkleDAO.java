package org.stajprojesi.MarketOtomasyonu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.stajprojesi.MarketOtomasyonu.DataBase.DatabaseConnection;
import org.stajprojesi.MarketOtomasyonu.Model.SonucModel;

public class UrunEkleDAO {
	
	private SonucModel sonuc = new SonucModel(); 
      
	public SonucModel urunEkle(String ad, String fiyat, String miktar, String barkod, String sube) throws ClassNotFoundException {
		Connection con = null;
	    String sql = "Insert into products(product_name, price, quantity, barkod_no, branch_id) values (?,?,?,?,?);";
	    int i=0;
	    
	    
	    try {
	    	 con = DatabaseConnection.getConnection();
	    	 PreparedStatement ps = con.prepareStatement(sql);
	    	 ps.setString(1, ad);
	    	 ps.setString(2, fiyat);
	    	 ps.setString(3, miktar);
	    	 ps.setString(4, barkod);
	    	 ps.setString(5, sube);
	    	 
	    	i = ps.executeUpdate();
	    	
	    	if(i>0) {
	    	   sonuc.setSonuc("kayit yapıldı");
	    	   
	    	}
	    	else {
	    		sonuc.setSonuc("kayıt yapılamadı");
	    	}
	    	 
	    	 
	    }catch(SQLException e) {
			 e.printStackTrace();
	            throw new RuntimeException(e);
		}finally {
			DatabaseConnection.close(con);
		}
	    
	    
	    return sonuc;
	    
	}
}
