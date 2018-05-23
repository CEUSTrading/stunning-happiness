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

public class SchedulerController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(SchedulerController.class.getName());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Double valor = BlockchainPriceResource.getPrices().getUSD().getLast();
		Double euro = (valor * ExchangeLayerResource.getLayer().getQuotes().getUSDEUR());
		Double round = Math.floor(euro*100)/100;
		
		try {
			log.log(Level.FINE, "Enviando Tweet");
			TwitterPost.publicarTweet(round);
			log.log(Level.FINE, "Enviando mensaje a Telegram");
			TelegramResource.postMessage(round);
			log.log(Level.FINE, "Proceso completado");
			//request.getRequestDispatcher("/index.html").forward(request, response);
		}catch(Exception e) {
			log.log(Level.SEVERE, "Se produjo un error");
			e.printStackTrace();
			//request.getRequestDispatcher("/error.html").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
