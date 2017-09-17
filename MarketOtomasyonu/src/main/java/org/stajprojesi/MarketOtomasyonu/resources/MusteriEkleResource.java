package org.stajprojesi.MarketOtomasyonu.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.stajprojesi.MarketOtomasyonu.DAO.MusteriEkleDAO;
import org.stajprojesi.MarketOtomasyonu.Model.MusteriEkleModel;
import org.stajprojesi.MarketOtomasyonu.Model.SonucModel;

@Path("/musteriekle")
public class MusteriEkleResource {

	SonucModel sonucmodel = new SonucModel();
	MusteriEkleDAO musteriekledao = new MusteriEkleDAO();
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SonucModel musteriEkleme(MusteriEkleModel musteribilgileri) throws ClassNotFoundException 
	{
		sonucmodel = musteriekledao.musteriEkle(musteribilgileri.getAd(), musteribilgileri.getSoyad(), musteribilgileri.getTelefon(), musteribilgileri.getAdres(), musteribilgileri.getSubeid());
		
		return sonucmodel;
	}
}
