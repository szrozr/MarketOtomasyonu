package org.stajprojesi.MarketOtomasyonu.Model;

public class UrunModel {
	
	private int id;
	private String product_name, price, quantity, branch_id, barkod_no;
	
	
	public UrunModel() {
		super();
	}


	public UrunModel(int id, String product_name, String price, String quantity, String branch_id, String barkod_no) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.price = price;
		this.quantity = quantity;
		this.branch_id = branch_id;
		this.barkod_no = barkod_no;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public String getBranch_id() {
		return branch_id;
	}


	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}


	public String getBarkod_no() {
		return barkod_no;
	}


	public void setBarkod_no(String barkod_no) {
		this.barkod_no = barkod_no;
	}
	
	
	
	
	
	
}
