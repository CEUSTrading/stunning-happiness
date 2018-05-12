package ceus.utility;

import java.util.List;

public class Persona {
	private String nombre;
	private String email;
	private String pass;
	private List<String> direcciones;
	
	public Persona(String nombre, String email, String pass, List<String> direcciones) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.pass = pass;
		this.direcciones = direcciones;
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

	public List<String> getDirecciones(){
		return direcciones;
	}
	
	public void setDirecciones(List<String> direcciones) {
		this.direcciones = direcciones;
	}
	
	
}
