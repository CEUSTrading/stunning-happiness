package ceus.resources.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import ceus.model.repository.PersonaRepository;
import ceus.utility.Persona;

public class RepositorioPersonaTest {

	@Test
	public void test1() {
		PersonaRepository p = PersonaRepository.getInstace();
	
		for(Persona l : p.getAllPersonas()) {
			System.out.println(l.getNombre() + " - - "+l.getEmail());
		}
		
		Persona m = p.addPersona(new Persona("Manuel", "manpergut@alum.us.es", "manu3"));
		
		System.out.println(p.getPersona("manpergut@alum.us.es").getNombre());
	
		for(Persona l : p.getAllPersonas()) {
			System.out.println(l.getNombre() + " - - "+l.getEmail());
		}
		
		assertNotNull(m);
		
	}
	
	@Test
	public void test2() {
		PersonaRepository p = PersonaRepository.getInstace();
		
		Persona m = new Persona(p.getPersona("manpergut@alum.us.es").getNombre(), "manpergut@alum.us.es", "manu3");
		String[] e = {"1estoNoEsUnaDireccion123435"};
		m.setDirecciones(Arrays.asList(e));
		
		System.out.println(m.toStringFormat());
		System.out.println(p.getPersona("manpergut@alum.us.es").toStringFormat());
		
		Persona m2 = p.actualizaPersona(m, "manpergut@alum.us.es");
		
		for(Persona o : p.getAllPersonas()) {
			System.out.println(o.getNombre() + " - - "+o.getEmail());
		}
		
		assertNotNull(m2);
		
	}
	
	@Test
	public void test3() {
		PersonaRepository p = PersonaRepository.getInstace();
		
		Persona m = p.getPersona("manpergut@alum.us.es");
		boolean r = p.eliminaPersona(m.getEmail());
		
		assertTrue(r);
		
	}
}
