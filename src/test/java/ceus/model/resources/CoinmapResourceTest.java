package ceus.model.resources;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

import ceus.model.map.Venue;
import ceus.model.map.Venues;

public class CoinmapResourceTest {
	
	static CoinmapResource cmr1 = new CoinmapResource();
	static CoinmapResource cmr2 = new CoinmapResource();
	
	@Test
	public void testGetAll() throws UnsupportedEncodingException {
		Venues allVenues = cmr1.getAllVenues();
		assertNotNull("The collection of venues is null", allVenues);
		
		System.out.println("\nListing the first 1000 venues");
		List<Venue> venueList = allVenues.getVenues();
		
		for(int i = 0; i < 1000; i++) {
			System.out.println("Venue " + (i+1) + ": " + venueList.get(i).getName());
		}
	}
	
	@Test
	public void testGetVenuesInLocation() {
		Venues venuesInLocation = cmr2.getVenuesInLocation("0.0", "10.0", "20.0", "40.0");
		assertNotNull("The collection of venues is null", venuesInLocation);
		
		System.out.println("\nListing venues between longitudes 0.0 and 10.0, and latitudes 20.0 and 40.0");
		List<Venue> venueList = venuesInLocation.getVenues();
		
		for(int i = 0; i < venueList.size(); i++) {
			System.out.println("Venue " + (i+1) + ": " + venueList.get(i).getName());
		}
	}
}
