package ceus.controller;

import java.io.IOException;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.repackaged.org.joda.time.LocalDateTime;

import ceus.model.blockchain.historical.HistoricalData;
import ceus.model.blockchain.historical.Value;
import ceus.resources.BlockchainHistoricalDataResource;
import ceus.resources.ExchangeLayerResource;

public class BlockchainHistoricalDataController extends HttpServlet {

	private static final Logger log = Logger.getLogger(BlockchainHistoricalDataResource.class.getName());
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SortedMap<String, String> res = new TreeMap<>();
		HistoricalData h = null;

		log.log(Level.INFO, "Recogiendo valores de consulta.");
		Integer n;
		Integer cur;
		String nS = request.getParameter("nCons");
		String curS = request.getParameter("cCons");
		log.log(Level.FINE, "Recogiendo valores");
		if(nS!=null && !("".equals(nS)) && curS!=null && !("".equals(curS))) {
			n = new Integer(nS);
			h = BlockchainHistoricalDataResource.getHistoricalData(n);
			cur = new Integer(curS);
			log.log(Level.FINE, "Obteniendo valores.");
			if (h != null) {
				switch (cur) {
				case 1:
					res = getMapUSD(h);
					break;
				case 2:
					res = getMapEUR(h);
					break;
				case 3:
					res = getMapGBP(h);
					break;
				case 4:
					res = getMapKRW(h);
					break;
				case 5:
					res = getMapJPY(h);
					break;
				default:
					res = getMapUSD(h);
					break;
				}
				log.log(Level.FINE, "Formateando valores");
				request.setAttribute("map", res);
				log.log(Level.FINE, "Enviando valores");
				request.getRequestDispatcher("view/HistoricalData.jsp").forward(request, response);				
			}else {
				log.log(Level.SEVERE, "There was an error with the historical data");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
				
			
		}else if("".equals(nS) && curS!=null && !("".equals(curS))) {
			n = 30;
			h = BlockchainHistoricalDataResource.getHistoricalDataDef();
			cur = new Integer(curS);
			log.log(Level.FINE, "Obteniendo valores.");
			if (h != null) {
				switch (cur) {
				case 1:
					res = getMapUSD(h);
					break;
				case 2:
					res = getMapEUR(h);
					break;
				case 3:
					res = getMapGBP(h);
					break;
				case 4:
					res = getMapKRW(h);
					break;
				case 5:
					res = getMapJPY(h);
					break;
				default:
					res = getMapUSD(h);
					break;
				}
				
				log.log(Level.FINE, "Formateando valores");
				request.setAttribute("map", res);
				log.log(Level.FINE, "Enviando valores");
				request.getRequestDispatcher("view/HistoricalData.jsp").forward(request, response);
			}else {
				log.log(Level.SEVERE, "There was an error with the historical data");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
				
			
		}else {
			log.log(Level.SEVERE, "Parámetros inválidos.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	public static SortedMap<String, String> getMapUSD(HistoricalData h) {
		SortedMap<String, String> res = new TreeMap<>();
		List<Value> s = h.getValues();
		for (Value v : s) {
			LocalDateTime time = new LocalDateTime((long) v.getX() * 1000);
			String fecha = time.getDayOfMonth() + "/" + time.getMonthOfYear() + "/" + time.getYear();
			res.put(fecha, Math.floor(v.getY() * 100) / 100 + " $");
		}

		return res;
	}

	private static SortedMap<String, String> getMapGBP(HistoricalData h) {
		SortedMap<String, String> res = new TreeMap<>();
		List<Value> s = h.getValues();

		final double i = ExchangeLayerResource.getLayer().getQuotes().getUSDGBP();

		for (Value v : s) {
			LocalDateTime time = new LocalDateTime((long) v.getX() * 1000);
			String fecha = time.getDayOfMonth() + "/" + time.getMonthOfYear() + "/" + time.getYear();
			res.put(fecha, (Math.floor(i * v.getY() * 100) / 100) + " £");
		}

		return res;
	}

	private static SortedMap<String, String> getMapEUR(HistoricalData h) {
		SortedMap<String, String> res = new TreeMap<>();
		List<Value> s = h.getValues();

		final double i = ExchangeLayerResource.getLayer().getQuotes().getUSDEUR();

		for (Value v : s) {
			LocalDateTime time = new LocalDateTime((long) v.getX() * 1000);
			String fecha = time.getDayOfMonth() + "/" + time.getMonthOfYear() + "/" + time.getYear();
			res.put(fecha, (Math.floor(i * v.getY() * 100) / 100) + " €");
		}

		return res;
	}

	private static SortedMap<String, String> getMapJPY(HistoricalData h) {
		SortedMap<String, String> res = new TreeMap<>();
		List<Value> s = h.getValues();

		final double i = ExchangeLayerResource.getLayer().getQuotes().getUSDKRW();

		for (Value v : s) {
			LocalDateTime time = new LocalDateTime((long) v.getX() * 1000);
			String fecha = time.getDayOfMonth() + "/" + time.getMonthOfYear() + "/" + time.getYear();
			res.put(fecha, (Math.floor(i * v.getY() * 100) / 100) + " ¥");
		}

		return res;
	}

	private static SortedMap<String, String> getMapKRW(HistoricalData h) {
		SortedMap<String, String> res = new TreeMap<>();
		List<Value> s = h.getValues();

		final double i = ExchangeLayerResource.getLayer().getQuotes().getUSDKRW();

		for (Value v : s) {
			LocalDateTime time = new LocalDateTime((long) v.getX() * 1000);
			String fecha = time.getDayOfMonth() + "/" + time.getMonthOfYear() + "/" + time.getYear();
			res.put(fecha, (Math.floor(i * v.getY() * 100) / 100) + " ₩");
		}

		return res;
	}

}
