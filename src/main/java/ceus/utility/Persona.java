package ceus.utility;

public class Persona {
	private String nombre;
	private String email;
	private String pass;
	private Monedero monedero;
	
	public Persona(String nombre, String email, String pass, Monedero monedero) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.pass = pass;
		this.monedero = monedero;
	}

	public Persona() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Monedero getMonedero() {
		return monedero;
	}

	public void setMonedero(Monedero monedero) {
		this.monedero = monedero;
	}
	
	
}
