package ceus.resources.test;

import java.util.Date;
import java.util.Map;

import org.junit.Test;

import ceus.controller.BlockchainHistoricalDataController;
import ceus.model.blockchain.historical.HistoricalData;
import ceus.resources.BlockchainHistoricalDataResource;

public class BlockchainHistoricalDataResourceTest {

	@Test
	public void testHistoricalBlockchainData() {
		
		HistoricalData h = BlockchainHistoricalDataResource.getHistoricalDataDef();
		System.out.println("Recogiendo valores");
		Map<String, String> r = BlockchainHistoricalDataController.getMapUSD(h);
		for(String d : r.keySet()) {
			System.out.println(d+" -> "+r.get(d));
		}
		
	}
	
}
