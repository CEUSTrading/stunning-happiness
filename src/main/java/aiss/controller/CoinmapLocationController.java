package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ceus.model.map.Venues;
import ceus.model.resources.CoinmapResource;

public class CoinmapLocationController extends HttpServlet {
	private static final Logger log = Logger.getLogger(CoinmapLocationController.class.getName());
	
	private static final long serialVersionUID = 1L;
	
	 /**
     * @see HttpServlet#HttpServlet()
     */
	
	public CoinmapLocationController() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		String lat1 = request.getParameter("lat1");
		String lat2 = request.getParameter("lat2");
		String lon1 = request.getParameter("lon1");
		String lon2 = request.getParameter("lon2");
		log.log(Level.INFO, "Requesting all venues from CoinMap");
		CoinmapResource cmap = new CoinmapResource();
		Venues venues = cmap.getVenuesInLocation(lon1, lon2, lat1, lat2);
		
		if(venues != null) {
			rd = request.getRequestDispatcher("test/testMapas.jsp");
			request.setAttribute("venues", venues.getVenues());
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
