package ceus.resources.test;

import static org.junit.Assert.assertTrue;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Test;

import com.google.appengine.repackaged.org.joda.time.LocalDateTime;

import ceus.resources.BlockchainPriceResource;
import ceus.resources.ExchangeLayerResource;
import ceus.resources.TelegramResource;

public class TelegramResourceTest {
	
	@Test
	public void testTelegramCombined() {
		Double price = BlockchainPriceResource.getPrices().getUSD().getLast() * ExchangeLayerResource.getLayer().getQuotes().getUSDEUR();
		Double value = Math.floor(price*100)/100;
		boolean success = TelegramResource.postMessage(value);
		
		assertTrue("The message was posted", success);
		System.out.println(value);
	}

}
