package ceus.resources;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import ceus.model.telegram.TelegramMessage;

public class TelegramResource {

	private static final Logger log = Logger.getLogger(TelegramMessage.class.getName());
	private static final String urlbase = "https://api.telegram.org/bot";
	private static final String botid = "586602031:AAHniBeZSWsN_XOiyLiDvRv9FRlsb4ZiaMM";
	private static final String channelid = "@CryptoEUS";

	public static Boolean postMessage(Double valor) {
		Boolean res = false;
		log.log(Level.INFO, "Trying to send a message to @CryptoEUS");
		String message = "El precio de 1BTC en este instante es de " + valor + "$\n"
				+ "Más información en cryptoeus.appspot.com";
		try {
			String url = urlbase + botid + "/sendMessage?chat_id=" + channelid + "&text=" + message;
			ClientResource cr = new ClientResource(url);
			cr.post(" ");
			cr.setEntityBuffering(true);
			res = true;
		} catch (ResourceException re) {
			log.log(Level.SEVERE, "There was an error sending the message");
			re.printStackTrace();
		}
		return res;
	}

}
