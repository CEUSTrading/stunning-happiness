package ceus.resources.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ceus.resources.BlockchainPriceResource;
import ceus.resources.ExchangeLayerResource;
import ceus.utility.TwitterPost;
import twitter4j.TwitterException;

public class TwitterPostTest {

	@Test
	public void test1() throws TwitterException {
		Double valor = Math.floor(ExchangeLayerResource.getLayer().getQuotes().getUSDEUR() * BlockchainPriceResource.getPrices().getUSD().getLast()*100)/100;
		boolean a = TwitterPost.publicarTweet(valor);
		assertTrue(a);
	}
	
}
