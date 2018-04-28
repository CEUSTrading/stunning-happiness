package ceus.model.resources;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TelegramResourceTest {
	
	@Test
	public void testPostMessage() {
		Boolean success = TelegramResource.postMessage("Prueba en JUnit");
		
		assertTrue("The message was posted", success);
	}

}
