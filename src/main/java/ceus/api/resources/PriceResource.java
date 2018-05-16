package ceus.api.resources;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.spi.BadRequestException;

import ceus.model.blockchain.address.Address;
import ceus.model.blockchain.historical.HistoricalData;
import ceus.model.blockchain.price.USD;
import ceus.resources.BlockchainAddressResource;
import ceus.resources.BlockchainConverterResource;
import ceus.resources.BlockchainHistoricalDataResource;
import ceus.resources.BlockchainPriceResource;
import ceus.resources.ExchangeLayerResource;
import javassist.NotFoundException;

@Path("/blockchain")
public class PriceResource {
	public static PriceResource _instance = null;
	static BlockchainPriceResource prices;
	static Logger log = Logger.getLogger(PriceResource.class.getName());
	
	private PriceResource() {
		prices = new BlockchainPriceResource();
	}
	
	public static PriceResource getInstance() {
		log.info("Instanciating PricesResource");
		if(_instance == null) {
			_instance = new PriceResource();
		}
		return _instance;
	}
	
	@GET
	@Path("/prices/{currency}")
	@Produces("application/json")
	public static USD getPrice(@PathParam("currency") String c) { //Coger precio de 1BTC en 5 monedas
		//TODO: Renombrar USD?
		log.info("Retrieving values from Blockchain requested in " + c);
		USD res = new USD();
		USD values = new USD();
		try {
			values = BlockchainPriceResource.getPrices().getUSD();
		} catch(Exception e) {
			throw new BadRequestException(e);
		}
		try {
			switch(c.toUpperCase()) {
			case "USD":
				res.set15m(values.get15m());
				res.setBuy(values.getBuy());
				res.setLast(values.getLast());
				res.setSell(values.getSell());
				res.setSymbol("$");
				break;
			case "EUR":
				Double toEUR = ExchangeLayerResource.getLayer().getQuotes().getUSDEUR();
				res.set15m(values.get15m() * toEUR);
				res.setBuy(values.getBuy() * toEUR);
				res.setLast(values.getLast() * toEUR);
				res.setSell(values.getSell() * toEUR);
				res.setSymbol("€");
				break;
			case "GBP":
				Double toGBP = ExchangeLayerResource.getLayer().getQuotes().getUSDGBP();
				res.set15m(values.get15m() * toGBP);
				res.setBuy(values.getBuy() * toGBP);
				res.setLast(values.getLast() * toGBP);
				res.setSell(values.getSell() * toGBP);
				res.setSymbol("£");
				break;
			case "JPY":
				Double toJPY = ExchangeLayerResource.getLayer().getQuotes().getUSDJPY();
				res.set15m(values.get15m() * toJPY);
				res.setBuy(values.getBuy() * toJPY);
				res.setLast(values.getLast() * toJPY);
				res.setSell(values.getSell() * toJPY);
				res.setSymbol("¥");
				break;
			case "KRW":
				Double toKRW = ExchangeLayerResource.getLayer().getQuotes().getUSDKRW();
				res.set15m(values.get15m() * toKRW);
				res.setBuy(values.getBuy() * toKRW);
				res.setLast(values.getLast() * toKRW);
				res.setSell(values.getSell() * toKRW);
				res.setSymbol("₩");
				break;
			default:
				throw new NotFoundException("The query was valid and understood but the specified"
						+ "currency isn't supported. Try with EUR, USD, KRW, JPY or GBP.");
			}
		} catch(Exception e) {
			throw new BadRequestException(e);
		}
		return res;
	}
	
	@GET
	@Path("/balance/{addr}")
	@Produces("text/plain")
	public static String getAddressBalance(@PathParam("addr") String a) { //Cuantos BTC hay en una direccion
		log.info("Requesting the balance of the address " + a);
		Double res = 0.0;
		try {
			res = (BlockchainAddressResource.getInfoFromAddress(a).getFinalBalance() * 1.0) / 100000000;
		} catch(Exception e) {
			throw new BadRequestException(e);
		}
		return res.toString();
	}
	
	@GET
	@Path("/detailed-balance/{addr}")
	@Produces("application/json")
	public static Address getDetailedAddressBalance(@PathParam("addr") String a) { //Balance detallado de una direccion
		log.info("Requesting a detailed snippet of the balance of the address " + a);
		Address consulted = new Address();
		Address res = new Address();
		try {
			consulted = BlockchainAddressResource.getInfoFromAddress(a);
		} catch(Exception e) {
			throw new BadRequestException(e);
		}
		try {
			res.setAddress(consulted.getAddress());
			res.setFinalBalance(consulted.getFinalBalance());
			res.setHash160(consulted.getHash160());
			res.setNTx(consulted.getNTx());
			res.setTotalReceived(consulted.getTotalReceived());
			res.setTotalSent(consulted.getTotalSent());
		} catch(Exception e) {
			throw new BadRequestException(e);
		}
		return res;
	}
	
	@GET
	@Path("/convert")
	@Produces("text/plain")
	public static String getConverted(@QueryParam("cur") String mon, @QueryParam("val") String cant) { //Convertir una cantidad a BTC
		log.info("Converting " + cant + " " + mon + " to BTC");
		try {
			new Integer(cant);
		} catch(Exception e) {
			throw new BadRequestException(cant + "is not a number");
		}
		if(!mon.toUpperCase().equals("USD") && !mon.toUpperCase().equals("EUR") && !mon.toUpperCase().equals("GBP") &&
				!mon.toUpperCase().equals("JPY") && !mon.toUpperCase().equals("KRW")) {
			throw new BadRequestException("The query was valid and understood but the specified"
					+ "currency isn't supported. Try with EUR, USD, KRW, JPY or GBP.");
		}
		String res = "";
		try {
			res = BlockchainConverterResource.getConversion(mon.toUpperCase(), cant);
		} catch(Exception e) {
			throw new BadRequestException(e);
		}
		return res;
	}
		
	@GET
	@Path("/historical")
	@Produces("application/json")
	public static HistoricalData getHistoricalDays(@QueryParam("days") Integer days) { //Datos históricos del BTC en X días
		HistoricalData res = null;
		if(days == null) {
			log.info("Retrieving 30 days of Historical Blockchain Data");
			try {
				res = BlockchainHistoricalDataResource.getHistoricalDataDef();
			} catch(Exception e) {
				throw new BadRequestException(e);
			}
		} else {
			log.info("Retrieving " + days + " days of Historical Blockchain Data");
			try {
				res = BlockchainHistoricalDataResource.getHistoricalData(days);
			} catch(Exception e) {
				throw new BadRequestException(e);
			}
		}
		return res;
	}

	

}
