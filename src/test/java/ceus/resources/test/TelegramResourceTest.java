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
		Double value = (Math.floor(BlockchainPriceResource.getPrices().getUSD().getLast()*ExchangeLayerResource.getLayer().getQuotes().getUSDEUR())*100)/100;
		boolean success = TelegramResource.postMessage(value);
		
		assertTrue("The message was posted", success);
		String message = "El precio de 1BTC en este instante es de " + value + "€\n"
				+ "Más información en cryptoeus.appspot.com";
		System.out.println(message);

	}

}
