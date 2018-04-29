package ceus.controller;

import java.io.IOException;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ceus.model.Telegram.TelegramMessage;
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
		String message = request.getParameter("telegram-message");
		
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
