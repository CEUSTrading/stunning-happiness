package ceus.resources.geocoding;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import ceus.model.Geocoding.GeocodingSearchLatLon;
import ceus.model.Geocoding.Location;

public class GeocodingResource {
	
	private String YOUR_API_KEY="AIzaSyCIxX8GwG003OjPask0y4Xvkcj16wfwigQ";
	private static final Logger log = Logger.getLogger(Location.class.getName());

	public GeocodingSearchLatLon getLocationInfo(String City) {
		String sCity = City.replace(" ", "+");
		GeocodingSearchLatLon res= null;
		
		try {
		String url = "https://maps.googleapis.com/maps/api/geocode/json?address="+sCity+"&key=" + YOUR_API_KEY;

		log.log(Level.INFO, "Retrieving information of the location"+City+" from Geocoding");
		
		ClientResource cr = new ClientResource(url);
		res = cr.get(GeocodingSearchLatLon.class);
		System.out.println(res);
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the location info: " + re);
		}
		return res;
	}
}
