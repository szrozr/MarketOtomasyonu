package org.stajprojesi.MarketOtomasyonu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.stajprojesi.MarketOtomasyonu.DataBase.DatabaseConnection;
import org.stajprojesi.MarketOtomasyonu.Model.SonucModel;

public class MusteriEkleDAO {
	
	SonucModel sonucmodel = new SonucModel();
	
	public SonucModel musteriEkle(String ad, String soyad, String telefon, String adres, String subeid) throws ClassNotFoundException {
		Connection con = null;
		String sql = "insert into customers(name,surname,tel,address,branch_id) values (?,?,?,?,?)";
		int i=0;
		sonucmodel.setSonuc("işlem yapılmadı");
		
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ad);
			ps.setString(2, soyad);
			ps.setString(3, telefon);
			ps.setString(4, adres);
			ps.setString(5, subeid);
			
			i = ps.executeUpdate();
			
			if(i>0) {
				sonucmodel.setSonuc("kayıtlar eklendi");
			}
			
			else {
				sonucmodel.setSonuc("kayıtlar eklenemedi!");
			}
		}catch(SQLException e) {
			 e.printStackTrace();
	            throw new RuntimeException(e);
		}finally {
			DatabaseConnection.close(con);
		}
		
		return sonucmodel;
	}

}
