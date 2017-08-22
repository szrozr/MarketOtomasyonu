package org.stajprojesi.MarketOtomasyonu;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Nesne {
	
	int id;
	String ad;
	String soyad;
	
	public Nesne() {
		
	}
	
	public Nesne(String ad, String soyad, int id) {
		
		this.ad = ad;
		this.soyad = soyad;
		this.id=id;
	}



	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}




	
}
