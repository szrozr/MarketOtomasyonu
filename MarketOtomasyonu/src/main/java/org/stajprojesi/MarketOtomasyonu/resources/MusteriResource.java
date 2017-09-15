package org.stajprojesi.MarketOtomasyonu.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.stajprojesi.MarketOtomasyonu.DAO.MusteriDAO;
import org.stajprojesi.MarketOtomasyonu.Model.MusteriModel;
import org.stajprojesi.MarketOtomasyonu.Model.MusteriNo;

@Path("/musteriler")
public class MusteriResource {

	
	MusteriModel musteri = new MusteriModel();
	MusteriDAO musteridao = new MusteriDAO();

	//MusteriNo musteri = new MusteriNo();
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public MusteriModel  getMusteri(MusteriNo musteri_no) throws ClassNotFoundException {
	     musteri = musteridao.getMusteri(musteri_no.getMusteriNo());
	     return musteri;
	}
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<MusteriModel> getMusteri () throws ClassNotFoundException{
		return musteriler = musteridao.getMusteri();		
	}*/
}
