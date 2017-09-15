package org.stajprojesi.MarketOtomasyonu.Model;

public class MusteriModel {
   
	private int customer_id, branch_id;
    private String name, surname, tel, address;
    
    
    
    
	public MusteriModel() {
		super();
	}




	public MusteriModel(int customer_id, int branch_id, String name, String surname, String tel, String address) {
		super();
		this.customer_id = customer_id;
		this.branch_id = branch_id;
		this.name = name;
		this.surname = surname;
		this.tel = tel;
		this.address = address;
	}




	public int getCustomer_id() {
		return customer_id;
	}




	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}




	public int getBranch_id() {
		return branch_id;
	}




	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getSurname() {
		return surname;
	}




	public void setSurname(String surname) {
		this.surname = surname;
	}




	public String getTel() {
		return tel;
	}




	public void setTel(String tel) {
		this.tel = tel;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}
    
    
    
    
}
