package ceus.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ceus.model.BlockChain.Historical.HistoricalData;
import ceus.model.BlockChain.Historical.Value;
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

		Map<Integer, Double> res = new HashMap<>();
		HistoricalData h = null;

		log.log(Level.INFO, "Recogiendo valores de consulta.");
		Integer n = new Integer(request.getParameter("nCons"));
		String cur = request.getParameter("cCons");
		if (n.equals(new Integer("30"))) {
			h = HistoricalBCData.getHistoricalDataDef();
		} else {
			h = HistoricalBCData.getHistoricalData(n);
		}
		if (h != null) {
			if (cur.equals("USD")) {
				res = getMapUSD(h);
				log.log(Level.INFO, "Valores recogidos en USD");
			} else if (cur.equals("GBP")) {
				res = getMapGBP(h);
				log.log(Level.INFO, "Valores recogidos en GBP");
			} else if (cur.equals("EUR")) {
				res = getMapEUR(h);
				log.log(Level.INFO, "Valores recogidos en EUR");
			}

			request.setAttribute("map", res);
			request.getRequestDispatcher("test/testHistoricalData.jsp").forward(request, response);

		}else {
			log.severe("Error al recoger los valores.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	public static Map<Integer, Double> getMapUSD(HistoricalData h) {
		Map<Integer, Double> res = new HashMap<>();
		List<Value> s = h.getValues();

		for (Value v : s) {
			System.out.println(v.getY());
			res.put(v.getX(), v.getY());
		}

		return res;
	}

	public static Map<Integer, Double> getMapGBP(HistoricalData h) {
		Map<Integer, Double> res = new HashMap<>();
		List<Value> s = h.getValues();

		final float i = 0.719154f;

		for (Value v : s) {
			System.out.println(v.getY());
			res.put(v.getX(), i * v.getY());
		}

		return res;
	}

	public static Map<Integer, Double> getMapEUR(HistoricalData h) {
		Map<Integer, Double> res = new HashMap<>();
		List<Value> s = h.getValues();

		final float i = 0.806942f;

		for (Value v : s) {
			System.out.println(v.getY());
			res.put(v.getX(), i * v.getY());
		}

		return res;
	}

	// mapEUR

}
