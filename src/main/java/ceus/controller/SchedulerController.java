package ceus.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ceus.resources.BlockchainPriceResource;
import ceus.resources.TelegramResource;
import ceus.utility.TwitterPost;

public class SchedulerController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(SchedulerController.class.getName());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean res=false;
		Double valor = BlockchainPriceResource.getPrices().getUSD().getLast();
		Double round = Math.floor(valor*100)/100;
		
		try {
			log.log(Level.FINE, "Enviando Tweet");
			res=TwitterPost.publicarTweet(round);
			
		}catch(Exception e) {
			log.log(Level.SEVERE, "Se produjo un error con twitter");
			e.printStackTrace();
			request.getRequestDispatcher("/error.html");
		}
		try {
			log.log(Level.FINE, "Enviando mensaje a Telegram");
			res=TelegramResource.postMessage(round);
		}catch(Exception e) {
			log.log(Level.SEVERE, "Se produjo un error con telegram");
			e.printStackTrace();
			request.getRequestDispatcher("/error.html");
		}
		if(res==true) {
			log.log(Level.FINE, "Proceso completado");
			request.getRequestDispatcher("/index.jsp");
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
