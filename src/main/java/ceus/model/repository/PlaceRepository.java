package ceus.model.repository;

import java.util.Collection;

import ceus.utility.Place;

public interface PlaceRepository {
	
	public Collection<Place> getAllPlaces(); //GET
	public Place getPlace(String id); //GET
	public Collection<Place> getPlacesByLocation(String lon1, String lon2, String lat1, String lat2);
	public void addPlace(Place l); //POST
	public void updatePlace(Place l); //PUT
	public void deletePlace(String id); //DELETE
	
}
