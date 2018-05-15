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

import ceus.model.google.geocoding.GeocodingSearchLatLon;
import ceus.model.map.Venues;
import ceus.resources.CoinmapResource;
import ceus.resources.GeocodingResource;

public class CoinmapLocationController extends HttpServlet {
	private static final Logger log = Logger.getLogger(CoinmapLocationController.class.getName());

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public CoinmapLocationController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		/*
		 * Con la ciudad pasada, busco información de la localidad mediante geocoding
		 */
		String city = request.getParameter("City");
		/*
		 * Comprobamos que tipo de petición se está realizando, si no se a introducido
		 * ninguna localidad, se buscan todos los negocios
		 */
		if (city == null || city.equals("")) {
			
		} else {
			
		}
		GeocodingSearchLatLon location = GeocodingResource.getLocationInfo(city);
		// latitud y longitud del centro de la localidad
		String lat = location.getResults().get(0).getGeometry().getLocation().getLat().toString();
		String lon = location.getResults().get(0).getGeometry().getLocation().getLng().toString();
		// pongo un radio de buúsqueda de 55 km
		Double lat1 = (Double.parseDouble(lat) - 0.5);
		Double lat2 = (Double.parseDouble(lat) + 0.5);
		Double lon1 = (Double.parseDouble(lon) - 0.5);
		Double lon2 = (Double.parseDouble(lon) + 0.5);

		log.log(Level.INFO, "Requesting all venues from CoinMap");
    
		// consigo la información de los negocios en ese radio de búsqueda
		CoinmapResource cmap = new CoinmapResource();
		Venues venues = cmap.getVenuesInLocation(lon1.toString(), lon2.toString(), lat1.toString(), lat2.toString());

		if (venues != null) {
			// creo unos strings almacenados en arrays para ser llevados al jsp
			// los strings serán separados mediante split
			String sname = "centro" + "#|";
			String slat = lat + "#|";
			String slon = lon + "#|";
			String scat = "centro" + "#|";
			String saddress = "centro" + "#|";
			/*
			 * Creo el nuevo geocodingSearchLatLon para las direcciones
			 */
			GeocodingSearchLatLon address = null;
			GeocodingResource grAddress = new GeocodingResource();
			for (int i = 0; i < venues.getVenues().size(); i++) {
				address = grAddress.getLocationInfo(venues.getVenues().get(i).getLat().toString(),
						venues.getVenues().get(i).getLon().toString());
				saddress += address.getResults().get(0).getFormattedAddress() + "#|";
				sname += venues.getVenues().get(i).getName() + "#|";
				slat += venues.getVenues().get(i).getLat().toString() + "#|";
				slon += venues.getVenues().get(i).getLon().toString() + "#|";
				scat += venues.getVenues().get(i).getCategory().toString() + "#|";
			}
			ArrayList<String> info = new ArrayList<String>();
			info.add(sname);
			info.add(slat);
			info.add(slon);
			info.add(scat);
			info.add(saddress);
			rd = request.getRequestDispatcher("test/testMapas.jsp");
			request.setAttribute("venues", info);

		} else {
			log.log(Level.SEVERE, "There was an error retrieving venues");
			rd = request.getRequestDispatcher("error.jsp");
		}

		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
