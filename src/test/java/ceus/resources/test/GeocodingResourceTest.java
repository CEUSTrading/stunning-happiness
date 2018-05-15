package ceus.resources.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ceus.model.google.geocoding.GeocodingSearchLatLon;
import ceus.model.google.geocoding.Location;
import ceus.resources.GeocodingResource;

public class GeocodingResourceTest {

	@Test
	public void test1() {
		
		GeocodingSearchLatLon g = GeocodingResource.getLocationInfo("Sevilla");
		
		Location l = g.getResults().get(0).getGeometry().getLocation();

		Double lat = l.getLat();
		Double lng = l.getLng();
		
		System.out.println("Lat: "+lat+"; Long:"+lng);
		
		assertNotNull(lat);
		assertNotNull(lng);
		
		
		
	}
	
}
