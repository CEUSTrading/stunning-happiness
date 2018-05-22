package ceus.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ceus.model.repository.PersonaRepository;
import ceus.utility.Persona;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(LoginController.class.getName());

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		log.log(Level.FINE, "Recogiendo el parámetro 'email'.");

		if (email != null && !("".equals(email)) && pass != null && !("".equals(pass))) {
			log.log(Level.FINE, "Parámetro válido.");
			Persona p = PersonaRepository.getInstace().getPersona(email);

			if (p == null) {
				log.log(Level.WARNING, "Email no registrado.");
				request.setAttribute("err", "email no registrado.");
				request.setAttribute("email", email);
				request.getRequestDispatcher("view/Logup.jsp").forward(request, response);
			} else {

				if (p.getPass().equals(pass)) {
					log.log(Level.FINE, "Login realizado. Añadiendo variables.");
					request.getSession().setAttribute("email", p.getEmail());
					request.getSession().setAttribute("nombre", p.getNombre());
					request.getRequestDispatcher("index.jsp").forward(request, response);
				} else {
					log.log(Level.SEVERE, "Parámetro 'pass' inválido.");
					request.setAttribute("err", "Contraseña incorrecta.");
					request.getRequestDispatcher("view/Login.jsp").forward(request, response);
				}
			}
		} else {
			log.log(Level.SEVERE, "Parámetro 'email' inválido.");
			request.setAttribute("err", "email vacío.");
			request.getRequestDispatcher("view/Login.jsp").forward(request, response);
		}

	}

}
