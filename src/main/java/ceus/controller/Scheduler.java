package ceus.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ceus.resources.BlockchainPriceResource;
import ceus.resources.ExchangeLayerResource;
import ceus.resources.TelegramResource;
import ceus.utility.TwitterPost;

public class Scheduler extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(Scheduler.class.getName());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Double valor = BlockchainPriceResource.getPrices().getUSD().getLast();
		Double euro = (valor * ExchangeLayerResource.getLayer().getQuotes().getUSDEUR());
		Double round = Math.floor(euro*100)/100;
		
		try {
			TwitterPost.publicarTweet(round);
			TelegramResource.postMessage(round);
		}catch(Exception e) {
			log.log(Level.SEVERE, "Se produjo un error");
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
