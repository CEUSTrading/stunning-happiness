package ceus.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ceus.model.blockchain.address.Address;
import ceus.model.repository.PersonaRepository;
import ceus.resources.BlockchainAddressResource;

public class LoadAddressController extends HttpServlet{


	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getSession().getAttribute("email").toString();
		
		if(email != null && !("".equals(email))){
			List<String> lista = PersonaRepository.getInstace().getPersona(email).getDirecciones();
			if(!lista.isEmpty()) {
				request.setAttribute("lista", lista);
				
				Address addr = BlockchainAddressResource.getInfoFromAddress(lista.get(0));
				
				List<String> valores = new ArrayList<>();
				Double totalSent = ((double) addr.getTotalSent()) / 100000000;
				Double totalReceived = ((double) addr.getTotalReceived()) / 100000000;
				Double finalBalance = ((double) addr.getFinalBalance()) / 100000000;
				valores.add(addr.getAddress());
				valores.add(totalSent.toString());
				valores.add(totalReceived.toString());
				valores.add(finalBalance.toString());
				
				request.setAttribute("values", valores);
				request.getRequestDispatcher("view/Address.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("view/Address.jsp").forward(request, response);
			}
		}else {
			request.getRequestDispatcher("view/Login.jsp").forward(request, response);
		}
		
	}
	
}
