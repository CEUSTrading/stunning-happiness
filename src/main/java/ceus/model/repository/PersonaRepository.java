package ceus.model.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mcpg.ficheros.UtilFicheros;

import com.google.appengine.repackaged.com.google.common.io.Files;

import ceus.utility.Persona;

public class PersonaRepository {

	Map<String, Persona> personaMap = new HashMap<>();
	private static PersonaRepository instance = null;
	
	public static PersonaRepository getInstace() {
		if(instance == null) {
			instance = new PersonaRepository();
			instance.init();
		}
		return instance;
	}
	
	private void init() {
		List<String> l = UtilFicheros.leeFicheroCompletoALista("./ficheros/basePersonas.txt");
		
		if(l.size()==0) {
			throw new IllegalArgumentException();
		}else {
			
			for(String s : l) {
				Persona p = Persona.create(s);
				personaMap.put(p.getEmail(), p);
			}
			
		}
		
	}
	
	public Collection<Persona> getAllPersonas(){
		return personaMap.values();
	}
	
	public Persona getPersona(String email) {
		return personaMap.get(email);
	}
	
	public Persona addPersona(Persona p) {
		
		boolean b = UtilFicheros.escribeLineaFichero("./ficheros/basePersonas.txt", p.toStringFormat());
		
		if(b) {
			personaMap.put(p.getEmail(), p);
			return p;
		}else {
			return new Persona("", "", new ArrayList<String>());
		}
		
	}
	
	public Persona actualizaPersona(Persona p, String email) {
		
		if(email!=null) {
			Persona j = personaMap.get(email);
			j.setNombre(p.getNombre());
			List<String> a = j.getDirecciones();
			List<String> d = p.getDirecciones();
			for(String s : d) {
				a.add(s);
			}
			j.setDirecciones(a);
			actualizaBase();
			return j;
		}else {
			return null;
		}
	}
	
	public boolean eliminaPersona(String email) {
		boolean res  = false;
		
		if(personaMap.containsKey(email)) {
			personaMap.remove(email);
			personaMap.keySet().remove(email);
			
			actualizaBase();
			
			res = true;
		}else {
			System.out.println("La persona asociada a: "+email+", no existe.");
		}
		
		return res;
	}
	
	private void actualizaBase() {
		
		/*File f = new File("./ficheros/basePersonas.txt");
		f.delete();
		*/
		String f = "";
		for(String s : personaMap.keySet()) {
			f+=personaMap.get(s).toStringFormat()+"\n";
		}
		UtilFicheros.escribeFicheroCompletoComun("./ficheros/basePersonas.txt", f);
	}
	
}
