package ceus.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ceus.model.google.login.GooglePerson;
import ceus.resources.GooglePersonResource;

public class GoogleLoginController extends HttpServlet {
	private static final Logger log = Logger.getLogger(CoinmapController.class.getName());

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		log.log(Level.INFO, "Accessing to the data from the Google Login");
		GooglePerson gp = GooglePersonResource.getInfo(request);
		ArrayList<String> info = new ArrayList<String>();
		if (gp != null) {
			info.add(gp.getNames().get(0).getDisplayName());
			info.add(gp.getEmailAddresses().get(0).getValue());
			request.setAttribute("Infos", info);
			log.log(Level.INFO, "Seteados logged-user-name y logged-user-email ["
					+ gp.getNames().get(0).getDisplayName() + ", " + gp.getEmailAddresses().get(0).getValue() + "]");
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} else {
			log.log(Level.SEVERE, "There was an error retrieving this person");
			rd = request.getRequestDispatcher("error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
