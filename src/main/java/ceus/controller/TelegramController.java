package ceus.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.repackaged.org.joda.time.LocalDateTime;

import ceus.model.BlockchainPrice.EUR;
import ceus.model.Telegram.TelegramMessage;
import ceus.resources.BlockchainPriceResource;
import ceus.resources.TelegramResource;

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
		EUR price = BlockchainPriceResource.getPrices().getEUR();
		Integer m = LocalDateTime.now().getMinuteOfHour();
		String minutes = m < 10? "0" + m : m.toString();
		String message = "El precio de 1BTC a las " + LocalDateTime.now().getHourOfDay() + ":" 
				+ minutes + " es de " + price.getLast() + price.getSymbol() + "\n"
				+ "Más información en cryptoeus.appspot.com";
		boolean success = TelegramResource.postMessage(message);
		
		if (success) {
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
