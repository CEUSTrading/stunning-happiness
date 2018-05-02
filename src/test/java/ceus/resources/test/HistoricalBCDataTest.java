package ceus.resources.test;

import java.time.LocalDateTime;
import java.util.Map;

import org.junit.Test;

import ceus.controller.HistoricalBCDataController;
import ceus.model.BlockChain.Historical.HistoricalData;
import ceus.resources.HistoricalBCData;

public class HistoricalBCDataTest {

	@Test
	public void test1() {
		
		HistoricalData h = HistoricalBCData.getHistoricalDataDef();
		System.out.println("Recogiendo valores");
		Map<Integer, Double> r = HistoricalBCDataController.getMapUSD(h);
		for(Integer d : r.keySet()) {
			System.out.println("Dia: "+d+" -> "+r.get(d));
		}
		
	}
	
}
