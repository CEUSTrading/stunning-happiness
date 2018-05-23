package ceus.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ceus.model.blockchain.address.Address;
import ceus.model.repository.PersonaRepository;
import ceus.resources.BlockchainAddressResource;

public class AddAddressController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(AddAddressController.class.getName());
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String addr = request.getParameter("addr");
		String email = request.getSession().getAttribute("email").toString();
		log.log(Level.FINE, "Recogiendo parametros");
		if(email != null && !("".equals(email))) {
			
			log.log(Level.FINE, "Email seteado.");
			if(addr != null && !("".equals(addr))) {
				
				log.log(Level.FINE, "Direccion seteado.");
				String zero = addr.substring(0, 1);
				if(zero.equals("m") || zero.equals("2") || zero.equals("n") || zero.equals("1") || zero.equals("3")) {
					
					log.log(Level.FINE, "Dreccion valida.");
					
					PersonaRepository.getInstace().actualizaDireccion(email, addr);
					List<String> lista = PersonaRepository.getInstace().getPersona(email).getDirecciones();
					log.log(Level.FINE, "Direccion añadida");

					request.setAttribute("lista", lista);
					
					Address a = BlockchainAddressResource.getInfoFromAddress(addr);
					
					List<String> valores = new ArrayList<>();
					Double totalSent = ((double) a.getTotalSent()) / 100000000;
					Double totalReceived = ((double) a.getTotalReceived()) / 100000000;
					Double finalBalance = ((double) a.getFinalBalance()) / 100000000;
					valores.add(a.getAddress());
					valores.add(totalSent.toString());
					valores.add(totalReceived.toString());
					valores.add(finalBalance.toString());
					
					request.setAttribute("values", valores);
					request.getRequestDispatcher("view/Address.jsp").forward(request, response);
				}
			}else {
				log.log(Level.SEVERE, "DIreccion no valida.");
				request.getRequestDispatcher("view/Address.jsp").forward(request, response);
			}
		}else {
			log.log(Level.SEVERE, "Email no valido.");
			request.getRequestDispatcher("view/Login.jsp").forward(request, response);
		}
	}

}
