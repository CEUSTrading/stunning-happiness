package ceus.model.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ceus.utility.Place;


public class MapPlaceRepository implements PlaceRepository {

	Map<String, Place> placesMap = new HashMap<>();
	private static MapPlaceRepository instance = null;
	private int index = 0; //Las ids tendrán un formato tal que "l"+index
	
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
		l1.setLat("-5.985418");
		l1.setLon("37.350581");
		l1.setName("CryptOle");
		l1.setTwitter("CryptOle");
		addPlace(l1);

	}
	
	public Collection<Place> getAllPlaces(){
		return placesMap.values();
	}
	
	public Place getPlace(String id){
		return placesMap.get(id);
	}
	
	public Collection<Place> getPlacesByLocation(String lon1, String lon2, String lat1, String lat2){
		//Lon1, lat1 son arriba a la izquierda. Lon2, lat2 son abajo a la derecha
		int ln1 = Integer.parseInt(lon1);
		int ln2 = Integer.parseInt(lon2);
		int lt1 = Integer.parseInt(lat1);
		int lt2 = Integer.parseInt(lat2);
		Collection<Place> res = new ArrayList<>();
		for(Place l: placesMap.values()) {
			int lon = Integer.parseInt(l.getLon());
			int lat = Integer.parseInt(l.getLat());
			if(lon > ln1 && lon < ln2) {
				if(lat > lt1 && lat < lt2) {
					res.add(l);
				}
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
	}
}
