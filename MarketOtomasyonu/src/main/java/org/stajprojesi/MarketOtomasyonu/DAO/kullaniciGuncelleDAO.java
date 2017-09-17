package org.stajprojesi.MarketOtomasyonu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.stajprojesi.MarketOtomasyonu.DataBase.DatabaseConnection;

public class kullaniciGuncelleDAO {
	
	
    public int kullaniciGuncelle(String ad, String soyad, String kullanici_adi, String yeni_sifre ) throws ClassNotFoundException {
    	Connection con = null;
    	String sql = "update users set firstname=?, lastname=?, username=?, password=? where username = ?";
    	int i=10;
    	
    	try {
    		con = DatabaseConnection.getConnection();
    		PreparedStatement ps = con.prepareStatement(sql);
    		
    		ps.setString(1, ad);
    		ps.setString(2, soyad);
    		ps.setString(3, kullanici_adi);
    		ps.setString(4, yeni_sifre);
    		ps.setString(5, kullanici_adi);
    		
    	     i = ps.executeUpdate();
    	    
    	    if(i>0) {
    	    	System.out.println("kayıt başarılı");
    	    	
    	    	
    	    }
    	    else
    	    {
    	    	
    	    	System.out.println("kayıt başarısız");
    	   
    	    }
    	    	
    	}catch(SQLException e) {
			 e.printStackTrace();
	            throw new RuntimeException(e);
		}finally {
			DatabaseConnection.close(con);
		}
    	
    	return i;
    		
    	}
    }

