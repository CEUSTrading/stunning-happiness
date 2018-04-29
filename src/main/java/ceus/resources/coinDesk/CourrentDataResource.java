package ceus.resources.coinDesk;

import java.io.IOException;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import com.google.appengine.repackaged.com.google.gson.Gson;

import ceus.model.coinDesk.Bpi;
import ceus.model.coinDesk.CourrentData;
import ceus.model.coinDesk.EUR;
import ceus.model.coinDesk.USD;

public class CourrentDataResource {

	private static String uri = "https://api.coindesk.com/v1/bpi/currentprice/";

	/*
	 * public Double[] getTupleValor(String mon1, String mon2) {
	 * 
	 * Double[] res = {}; ClientResource cr = null; mon1.toUpperCase();
	 * mon2.toUpperCase();
	 * 
	 * if(mon1=="USD"||mon2=="USD") { try {
	 * 
	 * cr = new ClientResource(uri); Bpi bpi = cr.get(Bpi.class);
	 * 
	 * }catch(Exception e) {
	 * System.err.println("Error al consultar los datos de Coindesk. Params:{"
	 * +mon1+", "+mon2+"}. Query: "+uri); } }
	 * 
	 * return res;
	 * 
	 * }
	 */

	public Double getValor(String mon) throws ResourceException, IOException {
		Double res = null;
		ClientResource cr = null;
		mon.toUpperCase();

		if (mon.equals("USD")) {
			try {
				cr = new ClientResource(uri + mon);
				String s = cr.toString();
				System.out.println(s);
				Gson gson = new Gson();
				Bpi bpi = gson.fromJson(s, Bpi.class);
				res = new Double(bpi.getUSD().getRate());
				System.out.println(res);
				/*
				 * Bpi bpi = cr.get(Bpi.class); res = new Double(bpi.getUSD().getRate());
				 */
			} catch (Exception e) {
				System.err.println("Error al consultar los datos de Coindesk. Params:{" + mon + "}. Query: " + uri);
			}
		} else if (mon.equals("EUR")) {

			try {
				cr = new ClientResource(uri + mon);
				String s = cr.get().getText();
				System.out.println("JSON: "+s);
				Gson gson = new Gson();
				CourrentData cd = gson.fromJson(s, CourrentData.class);// gson.toJson(s, Bpi.class);//fromJson(s,
					// Bpi.class);
				String s1 = gson.toJson(cd);
				System.out.println(s1);
				Bpi b = gson.fromJson(s1, Bpi.class);
				System.out.println("VBPI: "+b);
				Bpi bpi = cd.getBpi();
				System.out.println("BPI: "+bpi.toString());
				String s2 = gson.toJson(bpi);
				System.out.println("JSON2: "+s2);
				EUR eur = gson.fromJson(s2, EUR.class);//bpi.getEUR();
				System.out.println("EUR: "+eur);
				
				Double rate = eur.getRateFloat();
				System.out.println("RATE_FLOAT: "+rate);
				res = rate;
				System.out.println("Valor: "+res);
				/*EUR eur = gson.fromJson(s, EUR.class);
				String s1 = gson.toJson(eur);
				System.out.println(s1);
				res = eur.getRateFloat();
				System.out.println(eur);*/

			} catch (Exception e) {
				System.err.println("Error al consultar los datos de Coindesk. Params:{" + mon + "}. Query: " + uri);
				e.printStackTrace();
			}
		} else if (mon.equals("GBP")) {
			try {
				cr = new ClientResource(uri + mon);
				String s = cr.toString();
				System.out.println(s);
				Gson gson = new Gson();
				Bpi bpi = gson.fromJson(s, Bpi.class);
				//res = new Double(bpi.getGBP().getRate());
				System.out.println(res);
			} catch (Exception e) {
				System.err.println("Error al consultar los datos de Coindesk. Params:{" + mon + "}. Query: " + uri);
			}
		}

		return res;
	}

}
