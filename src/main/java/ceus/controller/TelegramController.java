package ceus.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.repackaged.org.joda.time.LocalDateTime;

import ceus.model.Telegram.TelegramMessage;
import ceus.resources.BlockchainPriceResource;
import ceus.resources.ExchangeLayerResource;
import ceus.resources.TelegramResource;
import ceus.utility.TwitterPost;
import twitter4j.TwitterException;

public class TelegramController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(TelegramMessage.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TelegramController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Double price = BlockchainPriceResource.getPrices().getUSD().getLast() * ExchangeLayerResource.getLayer().getQuotes().getUSDEUR();
		Double value = (Math.floor(BlockchainPriceResource.getPrices().getUSD().getLast()*ExchangeLayerResource.getLayer().getQuotes().getUSDEUR())*100)/100;
		
		boolean successTelegram = TelegramResource.postMessage(value);
		boolean successTwitter = false;
		try {
			successTwitter = TwitterPost.publicarTweet();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (successTelegram && successTwitter) {
			request.setAttribute("message", "Message posted successfully");
			log.log(Level.FINE, "The message was properly posted");
		}
		else {
			request.setAttribute("message", "The message could not be posted");
			log.log(Level.FINE, "The message couldn't be posted.");
		}
		
		request.getRequestDispatcher("index.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
