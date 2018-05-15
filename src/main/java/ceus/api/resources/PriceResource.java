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
import ceus.resources.BlockchainPriceResource;
import ceus.resources.ExchangeLayerResource;
import ceus.resources.BlockchainHistoricalDataResource;

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
	
//	@GET
//	@Path("/prices")
//	@Produces("application/json")
//	public static USD getPriceUSD() {
//		return BlockchainPriceResource.getPrices().getUSD();
//	}
	
	@GET
	@Path("/prices/{currency}")
	@Produces("application/json")
	public static USD getPrice(@PathParam("currency") String c) { //Coger precio de 1BTC en 5 monedas
		//TODO: Renombrar USD?
		log.info("Retrieving values from Blockchain requested in " + c);
		USD values = BlockchainPriceResource.getPrices().getUSD();
		switch(c) {
		case "USD":
			break;
		case "EUR":
			Double toEUR = ExchangeLayerResource.getLayer().getQuotes().getUSDEUR();
			values.set15m(values.get15m() * toEUR);
			values.setBuy(values.getBuy() * toEUR);
			values.setLast(values.getLast() * toEUR);
			values.setSell(values.getSell() * toEUR);
			values.setSymbol("€");
			break;
		case "GBP":
			Double toGBP = ExchangeLayerResource.getLayer().getQuotes().getUSDGBP();
			values.set15m(values.get15m() * toGBP);
			values.setBuy(values.getBuy() * toGBP);
			values.setLast(values.getLast() * toGBP);
			values.setSell(values.getSell() * toGBP);
			values.setSymbol("£");
			break;
		case "JPY":
			Double toJPY = ExchangeLayerResource.getLayer().getQuotes().getUSDJPY();
			values.set15m(values.get15m() * toJPY);
			values.setBuy(values.getBuy() * toJPY);
			values.setLast(values.getLast() * toJPY);
			values.setSell(values.getSell() * toJPY);
			values.setSymbol("¥");
			break;
		case "KRW":
			Double toKRW = ExchangeLayerResource.getLayer().getQuotes().getUSDKRW();
			values.set15m(values.get15m() * toKRW);
			values.setBuy(values.getBuy() * toKRW);
			values.setLast(values.getLast() * toKRW);
			values.setSell(values.getSell() * toKRW);
			values.setSymbol("₩");
			break;
		default:
			throw new BadRequestException("Wrong or unsupported fiat symbol provided");
		}
		return values;
	}
	
	@GET
	@Path("/balance/{addr}")
	@Produces("text/plain")
	public static String getAddressBalance(@PathParam("addr") String a) { //Cuantos BTC hay en una direccion
		log.info("Requesting the balance of the address " + a);
		return BlockchainAddressResource.getInfoFromAddress(a).getFinalBalance().toString();
	}
	
	@GET
	@Path("/detailed-balance/{addr}")
	@Produces("application/json")
	public static Address getDetailedAddressBalance(@PathParam("addr") String a) { //Balance detallado de una direccion
		log.info("Requesting a detailed snippet of the balance of the address " + a);
		Address consulted = BlockchainAddressResource.getInfoFromAddress(a);
		Address res = new Address();
		res.setAddress(consulted.getAddress());
		res.setFinalBalance(consulted.getFinalBalance());
		res.setHash160(consulted.getHash160());
		res.setNTx(consulted.getNTx());
		res.setTotalReceived(consulted.getTotalReceived());
		res.setTotalSent(consulted.getTotalSent());
		return res;
	}
	
	@GET
	@Path("/convert")
	@Produces("text/plain")
	public static String getConverted(@QueryParam("cur") String mon, @QueryParam("val") String cant) { //Convertir una cantidad a BTC
		log.info("Converting " + cant + " " + mon + " to BTC");
		return BlockchainConverterResource.getConversion(mon, cant);
	}
	
	@GET
	@Path("/historical")
	@Produces("application/json")
	public static HistoricalData getHistorical() { //Datos históricos del BTC por defecto
		//TODO: Renombrar clases
		log.info("Retrieving 30 days of Historical Blockchain Data");
		return BlockchainHistoricalDataResource.getHistoricalDataDef();
	}
	
	@GET
	@Path("/historical/{days}")
	@Produces("application/json")
	public static HistoricalData getHistoricalDays(@PathParam("days") Integer days) { //Datos históricos del BTC en X días
		log.info("Retrieving " + days + " days of Historical Blockchain Data");
		return BlockchainHistoricalDataResource.getHistoricalData(days);
	}

	

}