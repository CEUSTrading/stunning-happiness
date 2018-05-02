package ceus.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ceus.model.Map.Venues;
import ceus.resources.CoinmapResource;

public class CoinmapController extends HttpServlet {
	private static final Logger log = Logger.getLogger(CoinmapController.class.getName());
	
	private static final long serialVersionUID = 1L;
	
	 /**
     * @see HttpServlet#HttpServlet()
     */
	
	public CoinmapController() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		log.log(Level.INFO, "Requesting all venues from CoinMap");
		CoinmapResource cmap = new CoinmapResource();
		Venues allvenues = cmap.getAllVenues();
		
		if(allvenues != null) {
			rd = request.getRequestDispatcher("test/testAllVenues.jsp");
			request.setAttribute("venues", allvenues.getVenues());
		} else {
			log.log(Level.SEVERE, "There was an error retrieving venues");
			rd = request.getRequestDispatcher("error.jsp");
		}
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
