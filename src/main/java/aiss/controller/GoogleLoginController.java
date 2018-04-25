package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ceus.model.GoogleLogin.GooglePerson;
import ceus.model.resources.GooglePersonResource;

public class GoogleLoginController extends HttpServlet{
private static final Logger log = Logger.getLogger(CoinmapController.class.getName());
	
	private static final long serialVersionUID = 1L;
	
	 /**
     * @see HttpServlet#HttpServlet()
     */
	
	public GoogleLoginController() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		log.log(Level.INFO, "Accessing to the data from the Google Login");
		//GooglePersonResource gpr = new GooglePersonResource();
		GooglePerson gp = GooglePersonResource.getInfo(request);
		
		System.out.println(gp);
		if(gp != null) {
			request.setAttribute("logged-user-name", gp.getNames().get(0).getDisplayName());
			request.setAttribute("logged-user-email", gp.getEmailAddresses().get(0).getValue());
			log.log(Level.INFO, "Seteados logged-user-name y logged-user-email [" + gp.getNames().get(0).getDisplayName() + ", " + gp.getEmailAddresses().get(0).getValue() + "]");
			System.out.println("Seteados logged-user-name y logged-user-email [" + gp.getNames().get(0).getDisplayName() + ", " + gp.getEmailAddresses().get(0).getValue() + "]");
			rd = request.getRequestDispatcher("exitoGoogle.jsp");
			rd.forward(request, response);
		} else {
			log.log(Level.SEVERE, "There was an error retrieving this person");
			rd = request.getRequestDispatcher("error.jsp");
		}
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
