package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ceus.model.BlockchainAddress.Address;
import ceus.model.resources.BlockchainAddressResource;

public class BlockchainAddressController extends HttpServlet{
	private static final Logger log = Logger.getLogger(CoinmapController.class.getName());
	
	private static final long serialVersionUID = 1L;
	
	 /**
     * @see HttpServlet#HttpServlet()
     */
	
	public BlockchainAddressController() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		log.log(Level.INFO, "Requesting information about the address from Blockchain.info");
		String address = request.getParameter("address");
		Address addr = BlockchainAddressResource.getInfoFromAddress(address);
		
		if(address != null) {
			List<String> valores = new ArrayList<>();
			Integer totalSent = addr.getTotalSent() / 100000000;
			Integer totalReceived = addr.getTotalReceived() / 100000000;
			Integer finalBalance = addr.getFinalBalance() / 100000000;
			valores.add(addr.getAddress());
			valores.add(totalSent.toString());
			valores.add(totalReceived.toString());
			valores.add(finalBalance.toString());
			request.setAttribute("values", valores);
			rd = request.getRequestDispatcher("test/testAddress.jsp");
		} else {
			log.log(Level.SEVERE, "There was an error the information");
			rd = request.getRequestDispatcher("error.jsp");
		}
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
