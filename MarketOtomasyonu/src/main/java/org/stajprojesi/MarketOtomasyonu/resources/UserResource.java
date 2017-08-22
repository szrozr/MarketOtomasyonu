package org.stajprojesi.MarketOtomasyonu.resources;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.stajprojesi.MarketOtomasyonu.DAO.UserDAO;
import org.stajprojesi.MarketOtomasyonu.Model.LoginModel;
import org.stajprojesi.MarketOtomasyonu.Model.SonucModel;
import org.stajprojesi.MarketOtomasyonu.Model.UserModel;

@Path("/user")
public class UserResource {

	private String username;
	private String password;
	
	
	private SonucModel sonucmodel = new SonucModel("empty");
	
	private UserDAO userdao = new UserDAO();
	
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public UserModel getUser() throws ClassNotFoundException {
			return userdao.getUser();
		}
		
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public SonucModel loginDeneme(LoginModel loginmodel) throws ClassNotFoundException {
			
			
			this.username = loginmodel.getUsername();
			this.password = loginmodel.getPassword();
			
			//sonuc=logindao.sonucDonder(username, password);
			
			 Subject currentUser = SecurityUtils.getSubject();
		     UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		        
		     currentUser.login(token);
		     
		        if(currentUser.hasRole("admin")) {
		        	sonucmodel.setSonuc("admin");
		        	return sonucmodel;
		        }
		        
		        
		        
		        else if(currentUser.hasRole("kasiyer")) {
		        	sonucmodel.setSonuc("kasiyer");
		        	return sonucmodel;
		        }
		        
			return sonucmodel;
			
		}
	
		
}
