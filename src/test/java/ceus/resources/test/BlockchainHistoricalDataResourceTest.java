package ceus.resources.test;

import java.util.Map;

import org.junit.Test;

import com.google.appengine.repackaged.org.joda.time.LocalDate;

import ceus.controller.BlockchainHistoricalDataController;
import ceus.model.blockchain.historical.HistoricalData;
import ceus.resources.BlockchainHistoricalDataResource;

public class BlockchainHistoricalDataResourceTest {

	@Test
	public void testHistoricalBlockchainData() {
		
		HistoricalData h = BlockchainHistoricalDataResource.getHistoricalDataDef();
		System.out.println("Recogiendo valores");
		Map<LocalDate, String> r = BlockchainHistoricalDataController.getMapUSD(h);
		for(LocalDate d : r.keySet()) {
			System.out.println(d+" -> "+r.get(d));
		}
		
	}
	
}
