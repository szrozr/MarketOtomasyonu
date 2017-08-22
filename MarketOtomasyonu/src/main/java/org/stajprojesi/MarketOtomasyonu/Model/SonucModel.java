package org.stajprojesi.MarketOtomasyonu.Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SonucModel {
 private String sonuc;

 
 
 public SonucModel(String sonuc) {
	
	this.sonuc = sonuc;
}



public SonucModel() {
	
}

public String getSonuc() {
	return sonuc;
}

public void setSonuc(String sonuc) {
	this.sonuc = sonuc;
}
 
 
}
