package ceus.controller;

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

import ceus.resources.BlockchainConverterResource;

public class BlockchainConverterController extends HttpServlet {
	
	private static final Logger log = Logger.getLogger(BlockchainConverterController.class.getName());
	
	private static final long serialVersionUID = 1L;
	
	 /**
     * @see HttpServlet#HttpServlet()
     */
	
	public BlockchainConverterController() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		String cant = request.getParameter("cantidad");
		String mon = request.getParameter("moneda");
		log.log(Level.INFO, "Asking to blockchain.info");
		String conversion = BlockchainConverterResource.getConversion(mon, cant);
		
		if(conversion != null) {
			List<String> res = new ArrayList<>();
			res.add(cant);
			res.add(mon);
			res.add(conversion);
			request.setAttribute("results", res);
			rd = request.getRequestDispatcher("test/testConversion.jsp");
		} else {
			log.log(Level.SEVERE, "There was an error doing the conversion");
			rd = request.getRequestDispatcher("error.jsp");
		}
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

