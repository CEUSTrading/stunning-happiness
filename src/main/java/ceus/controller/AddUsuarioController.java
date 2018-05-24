package ceus.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ceus.model.repository.PersonaRepository;
import ceus.utility.Persona;

public class AddUsuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(AddUsuarioController.class.getName());

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		log.log(Level.FINE, "Recogiendo parámetros 'nombre' e 'email'.");
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		if (nombre != null && email != null && pass != null && !("".equals(nombre)) && !("".equals(email))
				&& !("".equals(pass))) {

			Persona p = new Persona(nombre, email, null);
			if (PersonaRepository.getInstace().getPersona(email) == null) {
				log.log(Level.FINE, "Creando presona con: 'nombre' e 'email'.");
				PersonaRepository.getInstace().addPersona(p);

				log.log(Level.FINE, "Seteando parámetros: 'nombre' e 'email'.");
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				session.setAttribute("nombre", nombre);
				
			}else {
				log.log(Level.INFO, "Email ya usado en una cuenta.");
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			log.log(Level.SEVERE, "Parámetros 'nombre' e 'email' inválidos.");
			request.setAttribute("err", "Algo pasó. Intentalo de nuevo.");
			request.getRequestDispatcher("../view/Logup.jsp").forward(request, response);
		}

	}

}
