package ceus.resources;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import ceus.model.Map.Venues;

public class CoinmapResource {
	
	 private static final Logger log = Logger.getLogger(Venues.class.getName());
	
	public Venues getAllVenues() throws UnsupportedEncodingException{
		
		String url = "http://coinmap.org/api/v1/venues/";
		
		log.log(Level.INFO, "Retrieving all venues from CoinMap");
		
		ClientResource cr = new ClientResource(url);
		Venues res = cr.get(Venues.class);
		
		return res;
	}
	
	public Venues getVenuesInLocation(String lon1, String lon2, String lat1, String lat2) {
		
		String url = "http://coinmap.org/api/v1/venues/?lon1=" + lon1 + "&lon2=" + lon2 + "&lat1=" + lat1 + "&lat2=" + lat2;
		
		log.log(Level.INFO, "Retrieving venues in between longitudes " + lon1 + " and " + lon2 + 
				" and latitudes " + lat1 + " and " + lat2 + " from CoinMap");
		
		ClientResource cr = new ClientResource(url);
		Venues res = cr.get(Venues.class);
		
		return res;
	}
}
