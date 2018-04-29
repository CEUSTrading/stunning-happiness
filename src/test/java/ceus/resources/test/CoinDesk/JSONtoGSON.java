package ceus.resources.test.CoinDesk;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.google.appengine.repackaged.com.google.gson.Gson;

import ceus.model.CoinDesk.Bpi;
import ceus.model.CoinDesk.CourrentData;
import ceus.model.CoinDesk.EUR;
import ceus.model.CoinDesk.Time;

public class JSONtoGSON {

	@Test
	public void test1() {
		String s = "{\"time\":{\"updated\":\"Apr 27, 2018 09:33:00 UTC\",\"updatedISO\":\"2018-04-27T09:33:00+00:00\",\"updateduk\":\"Apr 27, 2018 at 10:33 BST\"},\"disclaimer\":\"This data was produced from the CoinDesk Bitcoin Price Index (USD). Non-USD currency data converted using hourly conversion rate from openexchangerates.org\",\"bpi\":{\"USD\":{\"code\":\"USD\",\"rate\":\"9,251.5025\",\"description\":\"United States Dollar\",\"rate_float\":9251.5025},\"EUR\":{\"code\":\"EUR\",\"rate\":\"7,663.8244\",\"description\":\"Euro\",\"rate_float\":7663.8244}}}";
		Gson g =  new Gson();
		CourrentData cd = g.fromJson(s, CourrentData.class);
		System.out.println(g.toJson(cd.getTime()));
		System.out.println(g.toJson(cd.getDisclaimer()));
		System.out.println(g.toJson(cd.getBpi()));
		Bpi bpi = cd.getBpi();
		System.out.println(g.toJson(bpi.getEUR()));
		System.out.println(g.toJson(bpi.getUSD()));
		EUR eur = bpi.getEUR();
		System.out.println("EUR: "+eur);
		
		Double rate = null;
		rate = eur.getRateFloat();
		System.out.println("RATE_FLOAT: "+rate);
		assertNotNull(rate);
	}
	@Test
	public void test2() {
		String s = "{\"time\":{\"updated\":\"Apr 27, 2018 09:33:00 UTC\",\"updatedISO\":\"2018-04-27T09:33:00+00:00\",\"updateduk\":\"Apr 27, 2018 at 10:33 BST\"},\"disclaimer\":\"This data was produced from the CoinDesk Bitcoin Price Index (USD). Non-USD currency data converted using hourly conversion rate from openexchangerates.org\",\"bpi\":{\"USD\":{\"code\":\"USD\",\"rate\":\"9,251.5025\",\"description\":\"United States Dollar\",\"rate_float\":9251.5025},\"EUR\":{\"code\":\"EUR\",\"rate\":\"7,663.8244\",\"description\":\"Euro\",\"rate_float\":7663.8244}}}";
		Gson g =  new Gson();
		Bpi b = g.fromJson(s, Bpi.class);
		Time t = g.fromJson(s, Time.class);
		String d = g.fromJson(s, String.class);
		assertNotNull(b);
		assertNotNull(t);
		assertNotNull(d);
	}
	
}
