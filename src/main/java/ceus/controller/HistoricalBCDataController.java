package ceus.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.repackaged.org.joda.time.LocalDateTime;

import ceus.model.BlockChain.Historical.HistoricalData;
import ceus.model.BlockChain.Historical.Value;
import ceus.resources.ExchangeLayerResource;
import ceus.resources.HistoricalBCData;

public class HistoricalBCDataController extends HttpServlet {

	private static final Logger log = Logger.getLogger(HistoricalBCData.class.getName());
	private static final long serialVersionUID = 1L;

	public HistoricalBCDataController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, String> res = new HashMap<>();
		HistoricalData h = null;

		log.log(Level.INFO, "Recogiendo valores de consulta.");
		Integer n = new Integer(request.getParameter("nCons"));
		Integer cur = new Integer(request.getParameter("cCons"));

		if (n.equals(new Integer("30"))) {
			h = HistoricalBCData.getHistoricalDataDef();
		} else {
			h = HistoricalBCData.getHistoricalData(n);
		}

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
			request.setAttribute("map", res);
			request.getRequestDispatcher("test/testHistoricalData.jsp").forward(request, response);
		} else {
			log.severe("Error al recoger los valores.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	public static Map<String, String> getMapUSD(HistoricalData h) {
		Map<String, String> res = new HashMap<>();
		List<Value> s = h.getValues();
		for (Value v : s) {
			LocalDateTime time = new LocalDateTime((long) v.getX() * 1000);
			String fecha = time.getDayOfMonth()+"/"+time.getMonthOfYear()+"/"+time.getYear();
			res.put(fecha, Math.floor(v.getY()*100)/100+" $");
		}

		return res;
	}

	private static Map<String, String> getMapGBP(HistoricalData h) {
		Map<String, String> res = new HashMap<>();
		List<Value> s = h.getValues();

		final double i = ExchangeLayerResource.getLayer().getQuotes().getUSDGBP();

		for (Value v : s) {
			LocalDateTime time = new LocalDateTime((long) v.getX() * 1000);
			String fecha = time.getDayOfMonth()+"/"+time.getMonthOfYear()+"/"+time.getYear();
			res.put(fecha, (Math.floor(i*v.getY()*100)/100)+" £");
		}

		return res;
	}

	private static Map<String, String> getMapEUR(HistoricalData h) {
		Map<String, String> res = new HashMap<>();
		List<Value> s = h.getValues();

		final double i = ExchangeLayerResource.getLayer().getQuotes().getUSDEUR();

		for (Value v : s) {
			LocalDateTime time = new LocalDateTime((long) v.getX() * 1000);
			String fecha = time.getDayOfMonth()+"/"+time.getMonthOfYear()+"/"+time.getYear();
			res.put(fecha, (Math.floor(i*v.getY()*100)/100)+" €");
		}

		return res;
	}

	private static Map<String, String> getMapJPY(HistoricalData h) {
		Map<String, String> res = new HashMap<>();
		List<Value> s = h.getValues();

		final double i = ExchangeLayerResource.getLayer().getQuotes().getUSDKRW();

		for (Value v : s) {
			LocalDateTime time = new LocalDateTime((long) v.getX() * 1000);
			String fecha = time.getDayOfMonth()+"/"+time.getMonthOfYear()+"/"+time.getYear();
			res.put(fecha, (Math.floor(i*v.getY()*100)/100)+" ¥");
		}

		return res;
	}

	private static Map<String, String> getMapKRW(HistoricalData h) {
		Map<String, String> res = new HashMap<>();
		List<Value> s = h.getValues();

		final double i = ExchangeLayerResource.getLayer().getQuotes().getUSDKRW();

		for (Value v : s) {
			LocalDateTime time = new LocalDateTime((long) v.getX() * 1000);
			String fecha = time.getDayOfMonth()+"/"+time.getMonthOfYear()+"/"+time.getYear();
			res.put(fecha, (Math.floor(i*v.getY()*100)/100)+" ₩");
		}

		return res;
	}

}
