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
	
	public Place(String s) {
		String[] q = s.split("#");
		if(q.length==8) {
			this.name = q[0].trim();
			this.lat = q[1].trim();
			this.lon = q[2].trim();
			this.city = q[3].trim();
			this.category = q[4].trim();
			this.facebook = q[5].trim();
			this.twitter = q[6].trim();
			this.email = q[7].trim();
		}else {
			this.id = q[0].trim();
			this.name = q[1].trim();
			this.lat = q[2].trim();
			this.lon = q[3].trim();
			this.city = q[4].trim();
			this.category = q[5].trim();
			this.facebook = q[6].trim();
			this.twitter = q[7].trim();
			this.email = q[8].trim();
		}
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
