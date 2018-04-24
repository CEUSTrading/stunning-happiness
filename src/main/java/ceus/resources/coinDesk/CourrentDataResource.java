package ceus.resources.coinDesk;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.restlet.resource.ClientResource;

import ceus.model.coinDesk.Bpi;

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

	public static Double getValor(String mon) {
		double res = 0.0;
		ClientResource cr = null;
		mon.toUpperCase();

		if (mon == "USD") {
			try {
				cr = new ClientResource(uri + mon);
				Bpi bpi = cr.get(Bpi.class);
				res = new Double(bpi.getUSD().getRate());

			} catch (Exception e) {
				System.err.println("Error al consultar los datos de Coindesk. Params:{" + mon + "}. Query: " + uri);
			}
		} else if (mon == "EUR") {
			try {
				cr = new ClientResource(uri + mon);
				Bpi bpi = cr.get(Bpi.class);
				res = new Double(bpi.getEUR().getRate());

			} catch (Exception e) {
				System.err.println("Error al consultar los datos de Coindesk. Params:{" + mon + "}. Query: " + uri);
			}
		} else if (mon == "GBP") {
			try {
				cr = new ClientResource(uri + mon);
				Bpi bpi = cr.get(Bpi.class);
				res = new Double(bpi.getGBP().getRate());

			} catch (Exception e) {
				System.err.println("Error al consultar los datos de Coindesk. Params:{" + mon + "}. Query: " + uri);
			}
		}

		return res;
	}

}
