package com.example.CarAudioShop.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.CarAudioShop.data.WoofersDAO;
import com.example.CarAudioShop.model.Woofers;

@Path("/woofers")
@Stateless
@LocalBean
public class WoofersWS {

	@EJB
	private WoofersDAO woofersDao;
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findAllWoofers() {
		List<Woofers> woofers=woofersDao.getAllWoofers();
		return Response.status(200).entity(woofers).build();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/{id}")
	public Response findWooferById(@PathParam("id") int id) {
		Woofers woofer = woofersDao.getWoofer(id);
		if(woofer==null){
			return Response.status(404).build();
		}
		return Response.status(200).entity(woofer).build();

	}
	
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Response saveWoofer(Woofers woofer) {
		woofersDao.save(woofer);
		return Response.status(201).entity(woofer).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateWoofer(Woofers woofer,@PathParam("id") int id) {
		woofersDao.update(woofer);
		woofersDao.delete(id);
		return Response.status(200).entity(woofer).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteWoofer(@PathParam("id") int id) {
		woofersDao.delete(id);
		return Response.status(204).build();
	}
	
	@GET
	@Path("/search/{query}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findBySpeakerModel(@PathParam("query") String query) {
		System.out.println("findByModel: " + query);
		List<Woofers> woofers=woofersDao.getWoofersByModel(query);
		return Response.status(200).entity(woofers).build();
	}

}
