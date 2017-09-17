package org.stajprojesi.MarketOtomasyonu.Model;

public class UrunKayitModel {
			private String ad, fiyat, miktar, barkod, sube;

			public UrunKayitModel() {
				super();
			}

			public UrunKayitModel(String ad, String fiyat, String miktar, String barkod, String sube) {
				super();
				this.ad = ad;
				this.fiyat = fiyat;
				this.miktar = miktar;
				this.barkod = barkod;
				this.sube = sube;
			}

			public String getAd() {
				return ad;
			}

			public void setAd(String ad) {
				this.ad = ad;
			}

			public String getFiyat() {
				return fiyat;
			}

			public void setFiyat(String fiyat) {
				this.fiyat = fiyat;
			}

			public String getMiktar() {
				return miktar;
			}

			public void setMiktar(String miktar) {
				this.miktar = miktar;
			}

			public String getBarkod() {
				return barkod;
			}

			public void setBarkod(String barkod) {
				this.barkod = barkod;
			}

			public String getSube() {
				return sube;
			}

			public void setSube(String sube) {
				this.sube = sube;
			}
			
			
}
