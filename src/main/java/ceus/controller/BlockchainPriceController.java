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

import ceus.model.BlockchainPrice.EUR;
import ceus.model.BlockchainPrice.GBP;
import ceus.model.BlockchainPrice.JPY;
import ceus.model.BlockchainPrice.KRW;
import ceus.model.BlockchainPrice.Price;
import ceus.model.BlockchainPrice.USD;
import ceus.resources.BlockchainPriceResource;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		log.log(Level.INFO, "Requesting all info from Blockchain.info");
		Price all = BlockchainPriceResource.getPrices();
		Integer cur  = new Integer(request.getParameter("moneda-price"));
		
		if(all != null) {
			List<String> results = new ArrayList<>();
			switch(cur) {
			case 1:
				USD d = all.getUSD();
				results.add(d.getLast().toString());
				results.add(d.getSymbol());
			case 2:
				EUR e = all.getEUR();
				results.add(e.getLast().toString());
				results.add(e.getSymbol());
			case 3:
				GBP l = all.getGBP();
				results.add(l.getLast().toString());
				results.add(l.getSymbol());
			case 4:
				KRW k = all.getKRW();
				results.add(k.getLast().toString());
				results.add(k.getSymbol());
			case 5:
				JPY j = all.getJPY();
				results.add(j.getLast().toString());
				results.add(j.getSymbol());
			default:
				USD dl = all.getUSD();
				results.add(dl.getLast().toString());
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
