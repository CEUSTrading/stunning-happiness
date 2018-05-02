package ceus.resources;

import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import ceus.model.Telegram.TelegramMessage;

public class TelegramResource {

	private static final Logger log = Logger.getLogger(TelegramMessage.class.getName());
	private static final String urlbase = "https://api.telegram.org/bot";
	private static final String botid = "586602031:AAHniBeZSWsN_XOiyLiDvRv9FRlsb4ZiaMM";
	private static final String channelid = "@CryptoEUS";

	public static Boolean postMessage(String message) {
		Boolean res = false;
		log.info("Trying to send a message to @CryptoEUS");
		try {
			String url = urlbase + botid + "/sendMessage?chat_id=" + channelid + "&text=" + message;
			ClientResource cr = new ClientResource(url);
			cr.post(" ");
			cr.setEntityBuffering(true);
			res = true;
		} catch (ResourceException re) {
			log.severe("There was an error sending the message");
			throw re;
		}
		return res;
	}

}