package ceus.resources;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import ceus.model.google.geocoding.GeocodingSearchLatLon;
import ceus.model.google.geocoding.Location;

public class GeocodingResource {
	
	private static String YOUR_API_KEY="AIzaSyCIxX8GwG003OjPask0y4Xvkcj16wfwigQ";
	private static final Logger log = Logger.getLogger(Location.class.getName());
	private static final String url = "https://maps.googleapis.com/maps/api/geocode/json?";
	
	public static GeocodingSearchLatLon getLocationInfo(String City) {
		String sCity = City.replace(" ", "+");
		GeocodingSearchLatLon res= null;
		
		try {
		String uri = url+"address="+sCity+"&key=" + YOUR_API_KEY;

		log.log(Level.INFO, "Retrieving information of the location"+City+" from Geocoding");
		
		ClientResource cr = new ClientResource(uri);
		res = cr.get(GeocodingSearchLatLon.class);
		} catch (ResourceException re) {
			log.log(Level.INFO, "Error when retrieving the location info"+ res);
			System.err.println("Error when retrieving the location info: " + re);
		}
		return res;
	}
		
		public static GeocodingSearchLatLon getLocationInfo(String lat, String lon) {
		GeocodingSearchLatLon res= null;
		
		try {
		String uri = url+"latlng="+lat+","+lon+"&key=" + YOUR_API_KEY;

		log.log(Level.INFO, "Retrieving information of the address"+lat+","+lon+" from Geocoding");
		
		ClientResource cr = new ClientResource(uri);
		res = cr.get(GeocodingSearchLatLon.class);
		} catch (ResourceException re) {
			log.log(Level.INFO, "Error when retrieving the location info"+ res);
			System.err.println("Error when retrieving the location info: " + re);
		}
		return res;
	}
	
}
