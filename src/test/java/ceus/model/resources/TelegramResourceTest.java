package ceus.model.resources;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.google.appengine.repackaged.org.joda.time.LocalDateTime;

import ceus.model.BlockchainPrice.EUR;

public class TelegramResourceTest {
	
//	@Test
//	public void testPostMessage() {
//		Boolean success = TelegramResource.postMessage("Prueba en JUnit");
//		
//		assertTrue("The message was posted", success);
//	}
	
	@Test
	public void testCombined() {
		EUR price = BlockchainPriceResource.getPrices().getEUR();
		String minutes = (String) (LocalDateTime.now().getMinuteOfHour() < 10? "0" + LocalDateTime.now().getMinuteOfHour() : LocalDateTime.now().getMinuteOfHour());
		String message = "El precio de 1BTC a las " + LocalDateTime.now().getHourOfDay() + ":" 
				+ minutes + " es de " + price.getLast() + "\n"
				+ "Más información en cryptoeus.appspot.com";
		
		Boolean success = TelegramResource.postMessage(message);
		
		assertTrue("The message was posted", success);
	}

}
