package ceus.resources;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import ceus.model.google.login.GooglePerson;

public class GooglePersonResource {

	private static final Logger log = Logger.getLogger(GooglePerson.class.getName());

	public static GooglePerson getInfo(HttpServletRequest req) {
		String token = (String) req.getSession().getAttribute("Google-token");
		GooglePerson gp = null;
		log.info("Your token is " + token);
		String url = "https://people.googleapis.com/v1/people/me?personFields=names%2CemailAddresses&access_token="
				+ token;
		try {
			ClientResource cr = new ClientResource(url);
			gp = cr.get(GooglePerson.class);
		} catch (ResourceException re) {
			log.log(Level.INFO, "Error when retrieving the user info");
			System.err.println("Error when retrieving the user info: " + re);
		}
		return gp;
	}
}
