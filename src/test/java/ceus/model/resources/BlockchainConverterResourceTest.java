package ceus.model.resources;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class BlockchainConverterResourceTest {
	
	@Test
	public void testConvert() {
		String res = BlockchainConverterResource.getConversion("EUR", "300");
		
		assertNotNull("Converting 300 EUR to BTC", res);
		System.out.println(res);
	}

}
