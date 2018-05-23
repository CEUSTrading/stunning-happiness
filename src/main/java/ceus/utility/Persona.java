package ceus.utility;

import java.util.ArrayList;
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
	public Persona(String nombre, String email, String pass) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.pass = pass;
		this.direcciones = new ArrayList<String>();
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

	public List<String> getDirecciones(){
		return direcciones;
	}
	
	public void setDirecciones(List<String> direcciones) {
		this.direcciones = direcciones;
	}
	
	public String getPass() {
		return this.pass;
	}
	
	public void setPass(String p) {
		this.pass = p;
	}
	
	public static Persona create(String s) {
		String[] a = s.split("#");
		List<String> l = new ArrayList<>();
		a[3].trim().replace('[', ' ');
		a[3].trim().replace(']', ' ');
		
		for(String d : a[3].trim().split(",")) {
			l.add(d.trim());
		}
		
		return new Persona(a[0].trim(), a[1].trim(), a[2].trim(), l);
	}
	
	public void addDireccion(String dir) {
		this.direcciones.add(dir);
	}
	
	public static Persona create(String n, String email, String pass, List<String> l) {
		return new Persona(n, email, pass, l);
	}
	public static Persona create(String n, String email, String pass) {
		return new Persona(n, email, pass);
	}
	
	public String toStringFormat() {
		String s = "";
		
		s=s+this.nombre + "#";
		s=s+this.email + "#";
		s=s+this.pass+"#";
		s+="[";
		for(String t : this.direcciones) {
			s+=t+", ";
		}
		s+="]";
		
		return s;
	}
	
	
}
