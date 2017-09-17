package org.stajprojesi.MarketOtomasyonu.Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginModel {
	
	
  private String username;
  private String password;
  private String purpose;
  
  private String name = "";
  private String surname = "";
  private String newPassword = "";
  private String newPassword1 = "";
  
  
  
  
  
public LoginModel() {
	super();
}





public LoginModel(String username, String password, String purpose) {
	super();
	this.username = username;
	this.password = password;
	this.purpose = purpose;
}



public LoginModel(String username, String password, String purpose, String name, String surname, String newPassword, String newPassword1) {
	super();
	this.username = username;
	this.password = password;
	this.purpose = purpose;
	this.name = name;
	this.surname = surname;
	this.newPassword = newPassword;
	this.newPassword1 = newPassword1;
}





public String getUsername() {
	return username;
}




public void setUsername(String username) {
	this.username = username;
}




public String getPassword() {
	return password;
}




public void setPassword(String password) {
	this.password = password;
}




public String getPurpose() {
	return purpose;
}




public void setPurpose(String purpose) {
	this.purpose = purpose;
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





public String getNewPassword() {
	return newPassword;
}





public void setNewPassword(String newPassword) {
	this.newPassword = newPassword;
}





public String getNewPassword1() {
	return newPassword1;
}





public void setNewPassword1(String newPassword1) {
	this.newPassword1 = newPassword1;
}



 
  
}
