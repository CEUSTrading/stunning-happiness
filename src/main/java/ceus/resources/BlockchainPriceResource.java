package ceus.resources;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import ceus.model.blockchain.price.Price;

public class BlockchainPriceResource {

	private static final Logger log = Logger.getLogger(BlockchainPriceResource.class.getName());
	private static final String url = "https://blockchain.info/es/ticker";

	public static Price getPrices() {
		Price res = null;
		try {
			log.info("Retrieving all the information from Blockchain.info");
			ClientResource cr = new ClientResource(url);
			res = cr.get(Price.class);
		} catch (ResourceException re) {
			log.log(Level.INFO, "Error when retrieving the information from Blockchain.info");
			System.err.println("Error when retrieving the information from Blockchain.info: " + re);
		}
		return res;
	}

}
