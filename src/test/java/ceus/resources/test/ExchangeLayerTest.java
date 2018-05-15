package ceus.resources.test;

import org.junit.Test;

import ceus.model.layer.Quotes;
import ceus.resources.ExchangeLayerResource;

public class ExchangeLayerTest {

	@Test
	public void test1(){
		Quotes q = ExchangeLayerResource.getLayer().getQuotes();
		String e = "USDEUR: "+q.getUSDEUR();
		String y = "USDJPY: "+q.getUSDJPY();
		String l = "USDGBP: "+q.getUSDGBP();
		String w = "USDKRW: "+q.getUSDKRW();
		
		System.out.println(e);
		System.out.println(y);
		System.out.println(l);
		System.out.println(w);
	}
	
}
