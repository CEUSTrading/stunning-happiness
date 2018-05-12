package ceus.utility;

import java.util.logging.Level;
import java.util.logging.Logger;

import ceus.resources.BlockchainPriceResource;
import ceus.resources.ExchangeLayerResource;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TwitterPost {

	protected static final String API_KEY ="s8U8eUonNeexC0b3wA8qh7Qc3"; 
	protected static final String SECRET = "WlRdkuEe0hA6vmBvegklPtto98C7HZaX3uTC65fVccBIB2DdNp";
	protected static final long USER_ID = 981535043049918465l;
	protected static final String ACCESS_TOKEN = "981535043049918465-kcnAR6sHIfkcpwwl0l0DyFTIH3VBf96";
	protected static final String ACCESS_TOKE_SECRET = "qHk6tsvxGChHw7aF0GF2PIEGK4vZTWnP4v5yF7KXFGFQs";
	
	private static final Logger log = Logger.getLogger(Twitter.class.getName());
	
	public static boolean publicarTweet() throws TwitterException  {
		Boolean res = null;
		
		Twitter t = TwitterFactory.getSingleton();
		t.setOAuthConsumer(API_KEY, SECRET);
		t.setOAuthAccessToken(new AccessToken(ACCESS_TOKEN, ACCESS_TOKE_SECRET, USER_ID));
		log.log(Level.FINE, "Setting credentials at Twitter");
		Double valor = (Math.floor(BlockchainPriceResource.getPrices().getUSD().getLast()*ExchangeLayerResource.getLayer().getQuotes().getUSDEUR())*100)/100;
		log.log(Level.FINE, "Getting BTC value.");
		Status s = t.updateStatus("El valor actual del BTC es de "+valor+" €.\nPara saber más: cryptoeus.appspot.com");
		if(s!=null) {
			res = true;
			log.log(Level.FINE, "Tweet updated");
		}else {
			res = false;
			log.log(Level.WARNING, "Something went wrong");
		}
		return res;
	}
	
}
