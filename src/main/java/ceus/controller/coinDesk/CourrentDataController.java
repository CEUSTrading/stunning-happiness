package ceus.controller.coinDesk;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ceus.resources.coinDesk.CourrentDataResource;

public class CourrentDataController extends HttpServlet {
	/**
	 * 
	 */
	public CourrentDataController() {
		
	}
	private static final long serialVersionUID = -1L;
	private static final Logger log = Logger.getLogger(CourrentDataResource.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
		/*resp.setCharacterEncoding("UTF-8");
		resp.setHeader("content-type", "application/java");*/
		
		CourrentDataResource cdr = new CourrentDataResource();
		String mon = "EUR";//req.getAttribute("mon").toString();
		
		Double valor = cdr.getValor(mon);
		System.out.println(valor);
		if(valor!=null) {
			log.log(Level.FINE,"Valor actual en "+mon+": "+valor);
			req.getRequestDispatcher("view/Values.jsp").forward(req, resp);;
			req.setAttribute("valor", valor);
		}else {
			log.log(Level.WARNING,"No se ha podido recoger el valor en "+mon+".");
			req.getRequestDispatcher("view/Error.jsp").forward(req, resp);
		}
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req,resp);
	}


}
