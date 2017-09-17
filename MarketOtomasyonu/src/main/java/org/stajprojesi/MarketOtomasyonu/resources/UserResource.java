package org.stajprojesi.MarketOtomasyonu.resources;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.stajprojesi.MarketOtomasyonu.DAO.UserDAO;
import org.stajprojesi.MarketOtomasyonu.DAO.kullaniciGuncelleDAO;
import org.stajprojesi.MarketOtomasyonu.Model.LoginModel;
import org.stajprojesi.MarketOtomasyonu.Model.SonucModel;
import org.stajprojesi.MarketOtomasyonu.Model.UserModel;
import org.stajprojesi.MarketOtomasyonu.Model.shiroUserModel;

@Path("/user")
public class UserResource {
	
	   public static final String CURRENT_USER_KEY = "currentUser";

   private shiroUserModel shiroUser = new shiroUserModel();
   private UserModel usermodel = new UserModel();
   private Subject subject = SecurityUtils.getSubject();
	
	private SonucModel sonucmodel = new SonucModel("empty");
	
	private UserDAO userdao = new UserDAO();
	
		/*@GET
		@Produces(MediaType.APPLICATION_JSON)
		public String getUser()  {
			
			//Subject  subject= SecurityUtils.getSubject();
	        Session session = subject.getSession(false);
	        String message;
	        if(session != null) {
	            message = "Current user: " + session.getAttribute(CURRENT_USER_KEY);
	        } else {
	            message = "No current user, no session created";
	        }
	        
	        System.out.println(message);
	        
	        return message;
         }*/
	
	
 
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public SonucModel loginDeneme(LoginModel loginmodel) throws ClassNotFoundException {
			
			if(loginmodel.getPurpose().equals("guncelleme")) {
				System.out.println("purpose: " + loginmodel.getPurpose());
				    Session session = subject.getSession(false);
			        String userName;
			        if(session != null) {
			            userName = (String) session.getAttribute(CURRENT_USER_KEY);
			        } else {
			            userName = "guncelleme hatası";
			        }
			        
			        
			        System.out.println(loginmodel.getUsername());
			        System.out.println(loginmodel.getPassword());
			        System.out.println(loginmodel.getName());
			        System.out.println(loginmodel.getSurname());
			        System.out.println(loginmodel.getNewPassword());
			        System.out.println(loginmodel.getNewPassword1());
			        System.out.println("güncelleme userName: " + userName);
			        
			        if(loginmodel.getUsername().equals("") || loginmodel.getPassword().equals("") || loginmodel.getName().equals("") || loginmodel.getSurname().equals("")
			        		 || loginmodel.getNewPassword().equals("") || loginmodel.getNewPassword1().equals("")) {
			        	sonucmodel.setSonuc("tüm alanları doldurun!!");
			        	return sonucmodel;
			        }
			        
			        else if(!loginmodel.getNewPassword().equals(loginmodel.getNewPassword1())) {
			        	sonucmodel.setSonuc("şifreler uyuşmuyor!");
			        	return sonucmodel;
			        }
			        
			        else {
			        		UserModel userModel;
			        		userModel = userdao.getUser(userName);
			        		
			        		if(userModel.getPassword().equals(loginmodel.getPassword())) {
			        			String ad = loginmodel.getName();
			        			String soyad = loginmodel.getSurname();
			        			String kullanici_adi = loginmodel.getUsername();
			        			String yeni_sifre = loginmodel.getNewPassword();
			        			
			        			kullaniciGuncelleDAO kullaniciGuncelle = new kullaniciGuncelleDAO();
			        			int i = kullaniciGuncelle.kullaniciGuncelle(ad, soyad, kullanici_adi, yeni_sifre);
			        			
			        			if(i==10) {
			        				System.out.println("işlem yapılmadı");
			        			}
			        			
			        			sonucmodel.setSonuc("güncelleme başarılı!");
			        			return sonucmodel;
			        			
			        		}
			        		
			        		else if(!loginmodel.getUsername().equals(userName)) {
			        			sonucmodel.setSonuc("kullanıcı adınızı yanlış girdiniz!");
			        			return sonucmodel;
			        		}
			        		
			        		else  if(!loginmodel.getPassword().equals(usermodel.getPassword())){
			        			sonucmodel.setSonuc("şifrenizi yanlış girdiniz!");
			        			return sonucmodel;
			        			
			        		}
			        		
			        		
			             } 
			}	
			
			
			else if(loginmodel.getPurpose().equals("login")) {
				System.out.println("purpose: " + loginmodel.getPurpose());
				
				shiroUser.setUsername(loginmodel.getUsername());
				shiroUser.setPassword(loginmodel.getPassword());
				
				//sonuc=logindao.sonucDonder(username, password);
				
				
			     UsernamePasswordToken token = new UsernamePasswordToken(shiroUser.getUsername(), shiroUser.getPassword());
			     subject.login(token);
			     
			     
			    // UsernamePasswordToken token = new UsernamePasswordToken(username, password);
					String userName = token.getUsername();
					System.out.println("userName:" + userName);
			     
			        if(subject.hasRole("admin")) {
			        	
			        	 Session session = subject.getSession(true);
			             session.setAttribute(CURRENT_USER_KEY, "admin");
			        	
			        	sonucmodel.setSonuc("admin");
			        	return sonucmodel;
			        }
			        
			        
			        
			        else if(subject.hasRole("kasiyer")) {
			        	
			        	 Session session = subject.getSession(true);
			             session.setAttribute(CURRENT_USER_KEY, "kasiyer");
			            /* String username = (String) session.getAttribute(CURRENT_USER_KEY);
			             System.out.println("Session: " + username);*/
			        	 sonucmodel.setSonuc("kasiyer");
			        	 	Session session1 = subject.getSession(false);
				        	if(session1!=null) {
				        		String username = (String) session.getAttribute(CURRENT_USER_KEY);
				        		System.out.println("Session: " + username);
				        	}
				        	
				        	else if(session1 == null) {
				        		System.out.println("session boş");
				        	}
				        	
			        	 
			        	 return sonucmodel;
			        }
			}
						
			
		        
		        	
		        	//System.out.println("Session: " + username);
	             
			return sonucmodel;
			
		}	
}
