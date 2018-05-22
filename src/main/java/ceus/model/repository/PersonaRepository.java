package ceus.model.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ceus.utility.Persona;

public class PersonaRepository {

	// FIXME: arreglar tratamiento de archivos

	Map<String, Persona> personaMap = new HashMap<>();
	private static PersonaRepository instance = null;

	public static PersonaRepository getInstace() {
		if (instance == null) {
			instance = new PersonaRepository();
			instance.init();
		}
		return instance;
	}

	private void init() {
		/*
		 * List<String> l =
		 * UtilFicheros.leeFicheroCompletoALista("./ficheros/basePersonas.txt");
		 * 
		 * if(l.size()==0) { throw new IllegalArgumentException(); }else {
		 * 
		 * for(String s : l) { Persona p = Persona.create(s);
		 * personaMap.put(p.getEmail(), p); }
		 * 
		 * }
		 */

		Persona p0 = Persona.create("Gonzalo#gongargra@alum.us.es#gonza1#[]");
		Persona p1 = Persona.create("Chema#chema@alum.us.es#chema2#[]");
		Persona p2 = Persona.create("Manuel#manuel@alum.us.es#manu3#[]");

		personaMap.put(p0.getEmail(), p0);
		personaMap.put(p1.getEmail(), p1);
		personaMap.put(p2.getEmail(), p2);

	}

	public Collection<Persona> getAllPersonas() {
		return personaMap.values();
	}

	public Persona getPersona(String email) {
		if (personaMap.containsKey(email)) {
			return personaMap.get(email);
		} else {
			return null;
		}
	}

	public Persona addPersona(Persona p) {

		/*
		 * boolean b = UtilFicheros.escribeLineaFichero("./ficheros/basePersonas.txt",
		 * p.toStringFormat());
		 * 
		 * if(b) { personaMap.put(p.getEmail(), p); return p; }else { return new
		 * Persona("", "", new ArrayList<String>()); }
		 */

		if (p != null) {
			personaMap.put(p.getEmail(), p);
			return p;
		} else {
			return new Persona("", "", "",new ArrayList<String>());
		}
	}

	public Persona actualizaPersona(Persona p, String email) {

		if (email != null) {
			Persona j = personaMap.get(email);
			j.setNombre(p.getNombre());
			j.setPass(p.getPass());
			List<String> a = j.getDirecciones();
			List<String> d = p.getDirecciones();
			for (String s : d) {
				a.add(s);
			}
			j.setDirecciones(a);
			// actualizaBase();
			return j;
		} else {
			return null;
		}
	}

	public boolean eliminaPersona(String email) {
		boolean res = false;

		if (personaMap.containsKey(email)) {
			personaMap.remove(email);
			personaMap.keySet().remove(email);

			// actualizaBase();

			res = true;
		} else {
			System.out.println("La persona asociada a: " + email + ", no existe.");
		}

		return res;
	}

	/*
	 * private void actualizaBase() { String f = ""; for(String s :
	 * personaMap.keySet()) { f+=personaMap.get(s).toStringFormat()+"\n"; }
	 * UtilFicheros.escribeFicheroCompletoComun("./ficheros/basePersonas.txt", f); }
	 */

}
