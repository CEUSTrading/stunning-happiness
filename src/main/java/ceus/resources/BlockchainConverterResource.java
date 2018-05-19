package ceus.resources;

import org.jboss.resteasy.logging.Logger;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class BlockchainConverterResource {

	private static final Logger log = Logger.getLogger(BlockchainConverterResource.class);
	private static final String url = "https://blockchain.info/tobtc?";

	public static String getConversion(String mon, String cant) {
		String res = null;
		try {
			log.info("Converting " + cant + " " + mon + " to BTC.");
			String uri = url + "currency=" + mon + "&value=" + cant;
			ClientResource cr = new ClientResource(uri);
			res = cr.get(String.class);
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the conversion info: " + re);
		}
		return res;
	}

}
