package ceus.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ceus.model.blockchain.price.Price;
import ceus.model.blockchain.price.USD;
import ceus.resources.BlockchainPriceResource;
import ceus.resources.ExchangeLayerResource;

public class BlockchainPriceController extends HttpServlet {
	private static final Logger log = Logger.getLogger(BlockchainPriceController.class.getName());

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public BlockchainPriceController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;
		log.log(Level.INFO, "Requesting all info from Blockchain.info");
		Price all = BlockchainPriceResource.getPrices();
		Integer cur = new Integer(request.getParameter("moneda-price"));

		if (all != null) {
			List<String> results = new ArrayList<>();
			switch (cur) {
			case 1:
				USD d = all.getUSD();
				results.add((Math.floor(d.getLast()*100)/100)+"");
				results.add(d.getSymbol());
			case 2:
				Double e = all.getUSD().getLast() * ExchangeLayerResource.getLayer().getQuotes().getUSDEUR();
				results.add(Math.floor(e*100)/100+"");
				results.add("€");
			case 3:
				Double l = all.getUSD().getLast() * ExchangeLayerResource.getLayer().getQuotes().getUSDGBP();
				results.add((Math.floor(l*100)/100)+"");
				results.add("£");
			case 4:
				Double k = all.getUSD().getLast() * ExchangeLayerResource.getLayer().getQuotes().getUSDKRW();
				results.add((Math.floor(k*100)/100)+"");
				results.add("₩");
			case 5:
				Double j = all.getUSD().getLast() * ExchangeLayerResource.getLayer().getQuotes().getUSDJPY();
				results.add((Math.floor(j*100)/100)+"");
				results.add("¥");
			default:
				USD dl = all.getUSD();
				results.add((Math.floor(dl.getLast()*100)/100)+"");
				results.add(dl.getSymbol());
			}
			request.setAttribute("results", results);
			rd = request.getRequestDispatcher("test/testPrecios.jsp");
		} else {
			log.log(Level.SEVERE, "There was an error retrieving the information");
			rd = request.getRequestDispatcher("error.jsp");
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
