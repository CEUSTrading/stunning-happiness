package ceus.api.resources;

import java.net.URI;
import java.util.Collection;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.spi.BadRequestException;

import ceus.model.repository.MapPlaceRepository;
import ceus.model.repository.PlaceRepository;
import ceus.utility.Place;

@Path("/places")
public class PlaceResource {

	public static PlaceResource _instance = null;
	static PlaceRepository repository;
	private static final Logger log = Logger.getLogger(PlaceResource.class.getName());

	private PlaceResource() {
		repository = MapPlaceRepository.getInstance();
	}

	public static PlaceResource getInstance() {
		log.info("Instanciating the repository");
		if (_instance == null)
			_instance = new PlaceResource();
		return _instance;
	}
	
	@GET
	@Produces("application/json")
	public static Collection<Place> getAll(){ //Devuelve todos los Places del repo
		log.info("Retrieving all the places in the repo");
		return repository.getAllPlaces();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public static Place getById(@PathParam("id") String id) { //Devuelve el Place con id especificada
		log.info("Retrieving the place with id " + id);
		return repository.getPlace(id);
	}
	
	@GET
	@Path("/{city}")
	@Produces("application/json")
	public static Collection<Place> getByCity(@PathParam("city") String city) { //Devuelve todos los places de la ciudad
		log.info("Retrieving all the places in " + city);
		return repository.getPlacesByCity(city);
	}
	
	@GET
	@Path("/location?lat1={lat1}&lat2={lat2}&lon1={lon1}&lon2={lon2}")
	@Produces("application/json")
	public static Collection<Place> getByLocation(@PathParam("lat1") String lat1, 
			@PathParam("lat2") String lat2, @PathParam("lon1") String lon1, @PathParam("lon2") String lon2){
			//Devuelve todos los Places del cuadrado formado por lon1, lon2, lat1, lat2
		log.info("Retrieving all the places in between latitudes" + lat1 + " and " + lat2 +
				" and longitudes " + lon1 + " and " + lon2);
		return repository.getPlacesByLocation(lon1, lon2, lat1, lat2);
	}
	
	@POST
	@Consumes("application/json")
	//@Produces("application/json")
	public Response addPlace(/*@Context UriInfo uriInfo,*/ Place l) { //añade un place
		if(l.getName() == null || "".equals(l.getName())) {
			throw new BadRequestException("The name of the place can't be empty");
		}
		if(l.getLon() == null || "".equals(l.getLon())) {
			throw new BadRequestException("The longitude of the place can't be empty");
		}
		if(l.getLat() == null || "".equals(l.getLat())) {
			throw new BadRequestException("The latitude of the place can't be empty");
		}
		if(l.getCity() == null || "".equals(l.getCity())) {
			throw new BadRequestException("The city of the place can't be empty");
		}
		log.warning("A new place has been added to the repository");
		repository.addPlace(l);
//		
//		//This is the response
//		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
//		URI uri = ub.build(l.getId());
//		ResponseBuilder resp = Response.created(uri);
//		resp.entity(l);			
//		return resp.build();
		return Response.ok().build();
	}
	
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public Response updatePlace(Place l) { //actualiza un place
		Place oldplace = repository.getPlace(l.getId());
		if(oldplace == null) {
			throw new BadRequestException("The place with id " + l.getId() + " wasn't found");
		}
		
		//Actualizamos de uno en uno en oldplace
		if(l.getCategory() != null) {
			oldplace.setCategory(l.getCategory());
		}
		if(l.getCity() != null) {
			oldplace.setCity(l.getCity());
		}
		if(l.getEmail() != null) {
			oldplace.setEmail(l.getEmail());
		}
		if(l.getFacebook() != null) {
			oldplace.setFacebook(l.getFacebook());
		}
		if(l.getLat() != null) {
			oldplace.setLat(l.getLat());
		}
		if(l.getLon() != null) {
			oldplace.setLon(l.getLon());
		}
		if(l.getName() != null) {
			oldplace.setName(l.getName());
		}
		if(l.getTwitter() != null) {
			oldplace.setTwitter(l.getTwitter());
		}
		log.warning("The place with id " + l.getId() + " has been updated");
		//return Response.noContent().build();
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removePlace(@PathParam("id") String id) { //borra el Place de id especificada
		Place toremove = repository.getPlace(id);
		if(toremove == null) {
			throw new BadRequestException("The place with id " + id + " wasn't found");
		} else {
			repository.deletePlace(id);
			log.warning("The place with id " + id + " has been deleted");
		}
		
		//return Response.noContent().build();
		return Response.ok().build();
	}

}
