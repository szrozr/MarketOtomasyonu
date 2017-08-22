package org.stajprojesi.MarketOtomasyonu;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/myresource")
public class MyResource {

	
	private List<Nesne> liste = new ArrayList<>();
	
	
	@PostConstruct
	public void init() {
		Nesne nesne = new Nesne("sezer","özer",1);
    	liste.add(nesne);
	}
	
	@GET @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Nesne findById(@PathParam("id") String id) {
	 
		return liste.get(0);
	}

	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
   public List<Nesne> deneme(){	
    	return liste;
    	
    }
}
