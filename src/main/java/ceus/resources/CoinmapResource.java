package ceus.resources;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import ceus.model.map.Venues;

public class CoinmapResource {

	private static final Logger log = Logger.getLogger(Venues.class.getName());
	private static final String url = "http://coinmap.org/api/v1/venues/";

	public static Venues getAllVenues() throws UnsupportedEncodingException {
		Venues res = null;

		String uri = url;
		try {

			log.log(Level.INFO, "Retrieving all venues from CoinMap");

			ClientResource cr = new ClientResource(uri);
			res = cr.get(Venues.class);
		} catch (ResourceException re) {
			log.log(Level.INFO, "Error when retrieving the venues info" + res);
			System.err.println("Error when retrieving the venues info: " + re);
		}
		return res;
	}

	public static Venues getVenuesInLocation(String lon1, String lon2, String lat1, String lat2) {
		Venues res = null;
		String uri = url + "?lon1=" + lon1 + "&lon2=" + lon2 + "&lat1=" + lat1 + "&lat2=" + lat2;

		try {

			log.log(Level.INFO, "Retrieving venues in between longitudes " + lon1 + " and " + lon2 + " and latitudes "
					+ lat1 + " and " + lat2 + " from CoinMap");

			ClientResource cr = new ClientResource(uri);
			res = cr.get(Venues.class);
		} catch (ResourceException re) {
			log.log(Level.INFO, "Error when retrieving the venues info" + res);
			System.err.println("Error when retrieving the venues info: " + re);
		}
		return res;
	}
}
