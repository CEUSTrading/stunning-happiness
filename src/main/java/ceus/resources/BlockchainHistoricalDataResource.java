package ceus.resources;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import ceus.model.blockchain.historical.HistoricalData;

public class BlockchainHistoricalDataResource {

	private static final Logger log = Logger.getLogger(BlockchainHistoricalDataResource.class.getName());
	private static final String uri_ini = "https://blockchain.info/charts/market-price?timespan=";
	private static final String uri_fin = "days&format=json";

	public static HistoricalData getHistoricalDataDef() {
		HistoricalData res = null;
		String url = uri_ini + "30" + uri_fin;
		try {
			log.log(Level.INFO, "Consulta: " + url);
			ClientResource cr = new ClientResource(url);
			res = cr.get(HistoricalData.class);
		} catch (ResourceException re) {
			log.log(Level.INFO, "Error when retrieving the historical info");
			System.err.println("Error when retrieving the historical info: " + re);
		}
		return res;
	}

	public static HistoricalData getHistoricalData(Integer dias) {
		HistoricalData res = null;
		String url = uri_ini + dias + uri_fin;
		try {
			log.log(Level.INFO, "Consulta: " + url);
			ClientResource cr = new ClientResource(url);
			res = cr.get(HistoricalData.class);
		} catch (ResourceException re) {
			log.log(Level.INFO, "Error when retrieving the historical  days info");
			System.err.println("Error when retrieving the historical days info: " + re);
		}
		return res;
	}

}
