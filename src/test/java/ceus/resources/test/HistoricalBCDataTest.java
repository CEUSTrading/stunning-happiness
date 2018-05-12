package ceus.resources.test;

import java.util.Date;
import java.util.Map;

import org.junit.Test;

import ceus.controller.HistoricalBCDataController;
import ceus.model.BlockChain.Historical.HistoricalData;
import ceus.resources.HistoricalBCData;

public class HistoricalBCDataTest {

	@Test
	public void testHistoricalBlockchainData() {
		
		HistoricalData h = HistoricalBCData.getHistoricalDataDef();
		System.out.println("Recogiendo valores");
		Map<String, String> r = HistoricalBCDataController.getMapUSD(h);
		for(String d : r.keySet()) {
			System.out.println(d+" -> "+r.get(d));
		}
		
	}
	
}
