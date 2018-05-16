package ceus.resources;

import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import ceus.model.blockchain.address.Address;

public class BlockchainAddressResource {

	private static final Logger log = Logger.getLogger(Address.class.getName());
	private static final String urlmain = "https://blockchain.info/es/rawaddr/";
	private static final String urltest = "https://testnet.blockchain.info/es/rawaddr/";
	
	public static Address getInfoFromAddress(String address) {
		String url = null;
		String firstChar = address.substring(0, 1);
		if (firstChar.equals("m") || firstChar.equals("2") || firstChar.equals("n")) {
			log.info("The address is from the testnet");
			url = urltest  + address;
			log.info("Retrieving info from " + url);
		} else {
			log.info("The address is from the mainnet");
			url = urlmain  + address;
			log.info("Retrieving info from " + url);
		}
		
		ClientResource cr = new ClientResource(url);
		Address res = cr.get(Address.class);
		
		return res;
	}
}
