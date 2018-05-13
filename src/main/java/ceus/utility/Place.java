package ceus.utility;

public class Place {
	
	private String id;
	private String name;
	private String lat;
	private String lon;
	private String city;
	private String category;
	private String facebook;
	private String twitter;
	private String email;
	
	
	
	public Place(String id, String name, String lat, String lon, String city, String category, String facebook,
			String twitter, String email) {
		super();
		this.id = id;
		this.name = name;
		this.lat = lat;
		this.lon = lon;
		this.city = city;
		this.category = category;
		this.facebook = facebook;
		this.twitter = twitter;
		this.email = email;
	}

	public Place() {
		super();
	}

	public Place(String name, String lat, String lon, String city, String category, String facebook, String twitter,
			String email) {
		super();
		this.name = name;
		this.lat = lat;
		this.lon = lon;
		this.city = city;
		this.category = category;
		this.facebook = facebook;
		this.twitter = twitter;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
