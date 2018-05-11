package ceus.resources;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import ceus.model.layer.ExchangeData;

public class ExchangeLayerResource {

	private static final Logger log = Logger.getLogger(ExchangeLayerResource.class.getName());
	private static final String url = "http://www.apilayer.net/api/live?access_key=74d284cd5c08d7438ad2a150fdbe4673&format=1&currencies=EUR,GBP,KRW,JPY";
	
	
	public static ExchangeData getLayer() {
		
		ClientResource cr = new ClientResource(url);
		log.log(Level.FINE, "Recogiendo valores de cambio actualizados.");
		
		return cr.get(ExchangeData.class);
		
	}
	
}
