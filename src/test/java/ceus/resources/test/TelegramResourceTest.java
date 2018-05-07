package ceus.resources.test;

import static org.junit.Assert.assertTrue;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Test;

import com.google.appengine.repackaged.org.joda.time.LocalDateTime;

import ceus.model.BlockchainPrice.EUR;
import ceus.resources.BlockchainPriceResource;
import ceus.resources.TelegramResource;

public class TelegramResourceTest {
	
//	@Test
//	public void testPostMessage() {
//		Boolean success = TelegramResource.postMessage("Prueba en JUnit");
//		
//		assertTrue("The message was posted", success);
//	}
	
	@Test
	public void testTelegramCombined() {
		EUR price = BlockchainPriceResource.getPrices().getEUR();
		Integer m = LocalDateTime.now().getMinuteOfHour();
		String minutes = m < 10? "0" + m : m.toString();
		String message = "El precio de 1BTC a las " + LocalDateTime.now().getHourOfDay() + ":" 
				+ minutes + " es de " + price.getLast() + price.getSymbol() + "\n"
				+ "Más información en cryptoeus.appspot.com";
//		ZonedDateTime z = ZonedDateTime.now(ZoneId.of("Europe/Madrid"));
//		Integer m = z.getMinute();
//		String minutes = m < 10? "0" + m : m.toString();
//		String message = "El precio de 1BTC a las " + z.getHour() + ":" 
//				+ minutes + " es de " + price.getLast() + price.getSymbol() + "\n"
//				+ "Más información en cryptoeus.appspot.com";
		
		Boolean success = TelegramResource.postMessage(message);
		
		assertTrue("The message was posted", success);
		System.out.println(message);
	}

}
