package org.stajprojesi.MarketOtomasyonu.Model;

public class MusteriEkleModel {
		private String ad, soyad, telefon, adres, subeid;

		public MusteriEkleModel() {
			super();
		}

		public MusteriEkleModel(String ad, String soyad, String telefon, String adres, String subeid) {
			super();
			this.ad = ad;
			this.soyad = soyad;
			this.telefon = telefon;
			this.adres = adres;
			this.subeid = subeid;
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

		public String getTelefon() {
			return telefon;
		}

		public void setTelefon(String telefon) {
			this.telefon = telefon;
		}

		public String getAdres() {
			return adres;
		}

		public void setAdres(String adres) {
			this.adres = adres;
		}

		public String getSubeid() {
			return subeid;
		}

		public void setSubeid(String subeid) {
			this.subeid = subeid;
		}
		
		
}
