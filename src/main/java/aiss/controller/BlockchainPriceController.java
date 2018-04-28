package aiss.controller;

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

import ceus.model.BlockchainPrice.Price;
import ceus.model.resources.BlockchainPriceResource;

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
		String mon = request.getParameter("moneda-price");
		log.log(Level.INFO, "Requesting all info from Blockchain.info");
		Price all = BlockchainPriceResource.getPrices();
		
		if(all != null) {
			List<String> results = new ArrayList<>();
			if(mon.equals("EUR")) {
				results.add(all.getEUR().getLast().toString());
				results.add(all.getEUR().getSymbol());
			} else if (mon.equals("USD")) {
				results.add(all.getUSD().getLast().toString());
				results.add(all.getUSD().getSymbol());
			} else if (mon.equals("GBP")) {
				results.add(all.getGBP().getLast().toString());
				results.add(all.getGBP().getSymbol());
			} else if (mon.equals("AUD")) {
				results.add(all.getAUD().getLast().toString());
				results.add(all.getAUD().getSymbol());
			} else if (mon.equals("BRL")) {
				results.add(all.getBRL().getLast().toString());
				results.add(all.getBRL().getSymbol());
			}  else if (mon.equals("CAD")) {
				results.add(all.getCAD().getLast().toString());
				results.add(all.getCAD().getSymbol());
			} else if (mon.equals("CHF")) {
				results.add(all.getCHF().getLast().toString());
				results.add(all.getCHF().getSymbol());
			} else if (mon.equals("CLP")) {
				results.add(all.getCLP().getLast().toString());
				results.add(all.getCLP().getSymbol());
			}  else if (mon.equals("CNY")) {
				results.add(all.getCNY().getLast().toString());
				results.add(all.getCNY().getSymbol());
			} else if (mon.equals("DKK")) {
				results.add(all.getDKK().getLast().toString());
				results.add(all.getDKK().getSymbol());
			}  else if (mon.equals("HKD")) {
				results.add(all.getHKD().getLast().toString());
				results.add(all.getHKD().getSymbol());
			} else if (mon.equals("INR")) {
				results.add(all.getINR().getLast().toString());
				results.add(all.getINR().getSymbol());
			} else if (mon.equals("ISK")) {
				results.add(all.getISK().getLast().toString());
				results.add(all.getISK().getSymbol());
			} else if (mon.equals("JPY")) {
				results.add(all.getJPY().getLast().toString());
				results.add(all.getJPY().getSymbol());
			} else if (mon.equals("KRW")) {
				results.add(all.getKRW().getLast().toString());
				results.add(all.getKRW().getSymbol());
			} else if (mon.equals("NZD")) {
				results.add(all.getNZD().getLast().toString());
				results.add(all.getNZD().getSymbol());
			} else if (mon.equals("PLN")) {
				results.add(all.getPLN().getLast().toString());
				results.add(all.getPLN().getSymbol());
			} else if (mon.equals("RUB")) {
				results.add(all.getRUB().getLast().toString());
				results.add(all.getRUB().getSymbol());
			} else if (mon.equals("SEK")) {
				results.add(all.getSEK().getLast().toString());
				results.add(all.getSEK().getSymbol());
			} else if (mon.equals("SGD")) {
				results.add(all.getSGD().getLast().toString());
				results.add(all.getSGD().getSymbol());
			} else if (mon.equals("THB")) {
				results.add(all.getTHB().getLast().toString());
				results.add(all.getTHB().getSymbol());
			} else if (mon.equals("TWD")) {
				results.add(all.getTWD().getLast().toString());
				results.add(all.getTWD().getSymbol());
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
