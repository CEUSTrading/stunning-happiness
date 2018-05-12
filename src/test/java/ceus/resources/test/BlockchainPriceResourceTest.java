package ceus.resources.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ceus.model.BlockchainPrice.Price;
import ceus.resources.BlockchainPriceResource;

public class BlockchainPriceResourceTest {
	
	@Test
	public void testGetPrices() {
		Price allPrices = BlockchainPriceResource.getPrices();
		
		assertNotNull("Information retrieved: ", allPrices);
		//System.out.println("1BTC equals to " + allPrices.getEUR().getLast() + allPrices.getEUR().getSymbol());
		System.out.println("1BTC equals to " + allPrices.getUSD().getLast() + allPrices.getUSD().getSymbol());
		//System.out.println("1BTC equals to " + allPrices.getGBP().getLast() + allPrices.getGBP().getSymbol());
	}

}
