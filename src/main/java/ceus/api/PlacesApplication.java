package ceus.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import ceus.api.resources.PlaceResource;
import ceus.api.resources.PricesResource;

public class PlacesApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();
	
	public PlacesApplication() {
		singletons.add(PlaceResource.getInstance());
		singletons.add(PricesResource.getInstance());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
