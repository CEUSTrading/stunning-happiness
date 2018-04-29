package ceus.resources;

import org.jboss.resteasy.logging.Logger;
import org.restlet.resource.ClientResource;

public class BlockchainConverterResource {
	
	private static final Logger log = Logger.getLogger(BlockchainConverterResource.class);
	private static final String url = "https://blockchain.info/tobtc?";
	
	public static String getConversion(String mon, String cant) {
		log.info("Converting " + cant + " " + mon + " to BTC.");
		String uri = url + "currency=" + mon + "&value=" + cant;
		ClientResource cr = new ClientResource(uri);
		String res = cr.get(String.class);
		return res;
	}
	
}
