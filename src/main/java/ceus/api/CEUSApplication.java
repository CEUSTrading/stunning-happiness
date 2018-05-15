package ceus.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import ceus.api.resources.PlaceResource;
import ceus.api.resources.PriceResource;

public class CEUSApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();
	
	public CEUSApplication() {
		singletons.add(PlaceResource.getInstance());
		singletons.add(PriceResource.getInstance());
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
