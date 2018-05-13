package ceus.resources.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mcpg.ficheros.UtilFicheros;

public class FicherosTest {

	@Test
	public void test1() {
		boolean r = UtilFicheros.escribeFicheroCompleto("./ficheros/test1.txt", "Prueba 4", "##");
		assertTrue(r);
	}
	
}
