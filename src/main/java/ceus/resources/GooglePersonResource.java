package ceus.resources;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.restlet.resource.ClientResource;

import ceus.model.GoogleLogin.GooglePerson;


public class GooglePersonResource {
	
	private static final Logger log = Logger.getLogger(GooglePerson.class.getName());
	
	public static GooglePerson getInfo(HttpServletRequest req) {
		String token = (String) req.getSession().getAttribute("Google-token");
		log.info("Your token is " + token);
		String url = "https://people.googleapis.com/v1/people/me?personFields=names%2CemailAddresses&access_token=" + token;
		
		ClientResource cr = new ClientResource(url);
		GooglePerson gp = cr.get(GooglePerson.class);
		
		return gp;
	}
}
