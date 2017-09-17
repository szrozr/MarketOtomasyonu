package org.stajprojesi.MarketOtomasyonu.resources;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.stajprojesi.MarketOtomasyonu.DAO.UrunDao;
import org.stajprojesi.MarketOtomasyonu.DAO.UrunEkleDAO;
import org.stajprojesi.MarketOtomasyonu.Model.SonucModel;
import org.stajprojesi.MarketOtomasyonu.Model.UrunKayitModel;
import org.stajprojesi.MarketOtomasyonu.Model.UrunModel;

@Path("/urunler")
public class UrunResource {
	
	 ArrayList<UrunModel> urunler = new ArrayList<>();
	  UrunDao urundao = new UrunDao();
	  SonucModel sonucmodel = new SonucModel();
	  
	  UrunEkleDAO urunekle = new UrunEkleDAO();
	  
	  
	
	  @GET
	  @Produces(MediaType.APPLICATION_JSON)
	  public ArrayList<UrunModel> getUrun() throws ClassNotFoundException {
		 return  urunler = urundao.getUrun();
	  }
	  
	  
	  @POST
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)
	  public SonucModel urunEkle(UrunKayitModel urun) throws ClassNotFoundException {
       sonucmodel = urunekle.urunEkle(urun.getAd(), urun.getFiyat(), urun.getMiktar(), urun.getBarkod(), urun.getSube());
	   return sonucmodel;
}
	  
}
