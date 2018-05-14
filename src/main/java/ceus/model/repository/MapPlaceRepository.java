package ceus.model.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ceus.utility.Place;
import twitter4j.api.PlacesGeoResources;


public class MapPlaceRepository implements PlaceRepository {

	Map<String, Place> placesMap = new HashMap<>();
	private static MapPlaceRepository instance = null;
	private static Integer index = 0;
	
	public static MapPlaceRepository getInstance() {
		if(instance == null) {
			instance = new MapPlaceRepository();
			instance.init();
		}
		
		return instance;
	}

	private void init() {
		// Este método inicializará el map
		Place l1 = new Place();
		l1.setCategory("atm");
		l1.setCity("Sevilla");
		l1.setEmail("cryptole@gmail.com");
		l1.setFacebook("CryptOle");
		l1.setLat("37.350581");
		l1.setLon("-5.985418");
		l1.setName("CryptOle");
		l1.setTwitter("CryptOle");
		addPlace(l1);
		
		Place l2 = new Place();
		l2.setCategory("university");
		l2.setCity("Sevilla");
		l2.setEmail("cryptous@us.es");
		l2.setFacebook("ETSII");
		l2.setLat("37.358552");
		l2.setLon("-5.987006");
		l2.setName("ETS - I. Informatica");
		l2.setTwitter("ETS - I. Informatica");
		addPlace(l2);

		Place l3 = new Place();
		l3.setCategory("stadium");
		l3.setCity("Lisboa");
		l3.setEmail("alticearena@gmail.com");
		l3.setFacebook("Altice Arena");
		l3.setLat("38.768297");
		l3.setLon("-9.094309");
		l3.setName("Altice Arena");
		l3.setTwitter("alticea");
		addPlace(l3);
		
		Place l4 = new Place();
		l4.setCategory("bar");
		l4.setCity("Reikiavik");
		l4.setEmail("isbjorn@gmail.com");
		l4.setFacebook("Isbjorn Beer and Food");
		l4.setLat("64.144256");
		l4.setLon("-21.931065");
		l4.setName("Isbjorn Beer and Food");
		l4.setTwitter("isbjornbandf");
		addPlace(l4);
		
		Place l5 = new Place();
		l5.setCategory("circuit");
		l5.setCity("Melbourne");
		l5.setEmail("contact@albertpark.au");
		l5.setFacebook("Albert Park Circuit");
		l5.setLat("-37.848182");
		l5.setLon("144.970651");
		l5.setName("Albert Park Circuit");
		addPlace(l5);
		
		Place l6 = new Place();
		l6.setCategory("bar");
		l6.setCity("Ourolac");
		l6.setEmail("ourobar@gmail.com");
		l6.setFacebook("Bar do Divinio");
		l6.setLat("-18.134133");
		l6.setLon("-50.619564");
		l6.setName("Bar do Diviio");
		l6.setTwitter("capoeiradomorte");
		addPlace(l6);
	}
	
	public Collection<Place> getAllPlaces(){
		return placesMap.values();
	}
	
	public Place getPlace(String id){
		return placesMap.get(id);
	}
	
	public Collection<Place> getPlacesByLocation(String lon1, String lon2, String lat1, String lat2){
		//Lon1, lat1 son arriba a la izquierda. Lon2, lat2 son abajo a la derecha
		double ln1 = Double.parseDouble(lon1);
		double ln2 = Double.parseDouble(lon2);
		double lt1 = Double.parseDouble(lat1);
		double lt2 = Double.parseDouble(lat2);
		Collection<Place> res = new ArrayList<>();
		for(Place l: placesMap.values()) {
			double lon = Double.parseDouble(l.getLon());
			double lat = Double.parseDouble(l.getLat());
			if(lon > ln1 && lon < ln2) {
				if(lat > lt1 && lat < lt2) {
					res.add(l);
				}
			}
		}
		return res;
	}
	
	public Collection<Place> getPlacesByCity(String city){
		Collection<Place> res = new ArrayList<>();
		for(Place l: placesMap.values()) {
			if(city.equals(l.getCity())) {
				res.add(l);
			}
		}
		return res;
	}
	
	public void addPlace(Place l) {
		String id = "l" + index;
		l.setId(id);
		placesMap.put(id, l);
		index++;
	}
	
	public void updatePlace(Place l) {
		placesMap.put(l.getId(), l);
	}
	
	public void deletePlace(String id) {
		placesMap.remove(id);
		placesMap.keySet().remove(id);
	}
}
