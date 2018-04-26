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
import ceus.utility.Persona;

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
		log.log(Level.INFO, "Accessing to the data from the Google Login");
		RequestDispatcher rd = null;
		//GooglePersonResource gpr = new GooglePersonResource();
		GooglePerson gp = GooglePersonResource.getInfo(request);
		
		if(gp != null) {
			Persona p = new Persona();
			p.setNombre(gp.getNames().get(0).getDisplayName());
			p.setEmail(gp.getEmailAddresses().get(0).getValue());
			
			request.setAttribute("logged-user", p);
			request.setAttribute("logged-user-name", (String)gp.getNames().get(0).getDisplayName());
			request.setAttribute("logged-user-email", (String)gp.getEmailAddresses().get(0).getValue());
			
			log.log(Level.INFO, "Setting logged-user-name and logged-user-email [" + gp.getNames().get(0).getDisplayName() + ", " + gp.getEmailAddresses().get(0).getValue() + "]");
			log.log(Level.INFO, "Testing what's on logged-user-name: " + (String)request.getAttribute("logged-user-name"));
			log.log(Level.INFO, "Testing what's on logged-user-email: " + (String)request.getAttribute("logged-user-email"));
			log.log(Level.INFO, "Testing what's on persona: [" + p.getNombre() + ", " + p.getEmail() + "]");
			
			rd = request.getRequestDispatcher("test/exitoGoogle.jsp");
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
