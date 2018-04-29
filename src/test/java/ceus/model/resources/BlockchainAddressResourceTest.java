package ceus.model.resources;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ceus.model.BlockchainAddress.Address;

public class BlockchainAddressResourceTest {
	
	@Test
	public void testGetInfoMainAddress() {
		Address info = BlockchainAddressResource.getInfoFromAddress("1BjVRkWWApsgbGF1ArMir8Z7m3UzjyVagq");
		assertNotNull("No information retrieved", info);
		
		System.out.println("Listing all the information from the address");
		System.out.println("Address: " + info.getAddress());
		System.out.println("Total sent: " + info.getTotalSent());
		System.out.println("Total received: " + info.getTotalReceived());
		System.out.println("Final balance: " + info.getFinalBalance());
	}
	
	@Test
	public void testGetInfoTestAddress() {
		Address info = BlockchainAddressResource.getInfoFromAddress("mgyJ5qjF5N7hhvW7aQV9cb3Jt3HpH4B9V1");
		assertNotNull("No information retrieved", info);
		
		System.out.println("Listing all the information from the address");
		System.out.println("Address: " + info.getAddress());
		System.out.println("Total sent: " + info.getTotalSent());
		System.out.println("Total received: " + info.getTotalReceived());
		System.out.println("Final balance: " + info.getFinalBalance());
	}

}
