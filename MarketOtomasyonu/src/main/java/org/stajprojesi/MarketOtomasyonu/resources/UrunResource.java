package org.stajprojesi.MarketOtomasyonu.resources;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.stajprojesi.MarketOtomasyonu.DAO.UrunDao;
import org.stajprojesi.MarketOtomasyonu.Model.UrunModel;

@Path("/urunler")
public class UrunResource {
	
	 ArrayList<UrunModel> urunler = new ArrayList<>();
	  UrunDao urundao = new UrunDao();
	
	  @GET
	  @Produces(MediaType.APPLICATION_JSON)
	  public ArrayList<UrunModel> getUrun() throws ClassNotFoundException {
		 return  urunler = urundao.getUrun();
	  }
}
