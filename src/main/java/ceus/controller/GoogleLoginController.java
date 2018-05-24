package ceus.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ceus.model.google.login.GooglePerson;
import ceus.model.repository.PersonaRepository;
import ceus.resources.GooglePersonResource;
import ceus.utility.Persona;

public class GoogleLoginController extends HttpServlet {
	private static final Logger log = Logger.getLogger(CoinmapController.class.getName());

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		log.log(Level.INFO, "Accessing to the data from the Google Login");
		GooglePerson gp = GooglePersonResource.getInfo(request);
		
		String nombre;
		String email;
		
		//TODO: añadir al map el nuevo usuario
		
		if (gp != null) {
			nombre = gp.getNames().get(0).getDisplayName();
			email = gp.getEmailAddresses().get(0).getValue();
			log.log(Level.INFO, "Seteados logged-user-name y logged-user-email ["
					+ nombre + ", " + email + "]");
			
			Persona p = new Persona(nombre, email, null);
			if(PersonaRepository.getInstace().getPersona(email)==null) {
				PersonaRepository.getInstace().addPersona(p);
			}
			
			session.setAttribute("nombre", nombre);
			session.setAttribute("email", email);
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} else {
			log.log(Level.SEVERE, "There was an error retrieving this person");
			rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
