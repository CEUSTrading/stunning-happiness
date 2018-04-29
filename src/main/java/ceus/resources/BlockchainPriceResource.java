package ceus.resources;

import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import ceus.model.BlockchainPrice.Price;

public class BlockchainPriceResource {

	private static final Logger log = Logger.getLogger(BlockchainPriceResource.class.getName());
	private static final String url = "https://blockchain.info/es/ticker";

	public static Price getPrices() {
		log.info("Retrieving all the information from Blockchain.info");
		ClientResource cr = new ClientResource(url);
		
		Price res = cr.get(Price.class);
		return res;
	}

}
