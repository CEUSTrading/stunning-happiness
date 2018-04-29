package ceus.resources;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.restlet.resource.ClientResource;

import ceus.model.CoinDesk.HistoricalData;

public class HistoricalDataResource {

	private static String uri = "https://api.coindesk.com/v1/bpi/historical/close.json";
	
	public static Map<LocalDate, Double> getHistoricalData(){
		Map<LocalDate, Double> res =  null;
		ClientResource cr = null;
		
		try {
			cr = new ClientResource(uri);
			res = cr.get(HistoricalData.class).getBpiHistorical().getValues();
			
		}catch(Exception e) {
			System.err.println("Error al consultar los datos de Coindesk. Query: " + uri);
		}
		
		return res;
	}
	
	public Map<LocalDate, Double> getHistoricalData(String val){
		Map<LocalDate, Double> res =  null;
		ClientResource cr = null;
		
		try {
			cr = new ClientResource(uri+"?currency="+val);
			res = cr.get(HistoricalData.class).getBpiHistorical().getValues();
			
		}catch(Exception e) {
			System.err.println("Error al consultar los datos de Coindesk. Param:{"+val+"}. Query: " + uri);
		}
		
		return res;
	}
	
	public Map<LocalDate, Double> getHistoricalData(String val, LocalDate inicio, LocalDate fin){
		Map<LocalDate, Double> res =  null;
		ClientResource cr = null;
		
		String ini = inicio.format(DateTimeFormatter.ISO_DATE);
		String f = fin.format(DateTimeFormatter.ISO_DATE);
		
		try {
			cr = new ClientResource(uri+"?currency="+val+"?start="+ini+"&end="+f);
			res = cr.get(HistoricalData.class).getBpiHistorical().getValues();
			
		}catch(Exception e) {
			System.err.println("Error al consultar los datos de Coindesk. Param:{"+val+", "+ini+", "+f+"}. Query: " + uri);
		}
		
		return res;
	}
	
}
