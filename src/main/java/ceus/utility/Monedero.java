package ceus.utility;

public class Monedero {
	private String guid;
	private String address;
	
	public Monedero(String guid, String address) {
		super();
		this.guid = guid;
		this.address = address;
	}

	public Monedero() {
		super();
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
