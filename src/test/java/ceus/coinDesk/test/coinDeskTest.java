package ceus.coinDesk.test;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import aiss.utility.OAuthRegistry;
import ceus.controller.coinDesk.CourrentDataController;
import ceus.resources.coinDesk.CourrentDataResource;
import ceus.resources.coinDesk.HistoricalDataResource;

public class coinDeskTest {

	@Test
	public void testConsultaAhora() {

		Double a = CourrentDataResource.getValor("EUR");
		System.out.println(a);

		Double b = CourrentDataResource.getValor("GBP");
		System.out.println(b);

		Double c = CourrentDataResource.getValor("USD");
		System.out.println(c);

		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
	}

	@Test
	public void testConsultaHistoricoMesAhora() {
		Map<LocalDate, Double> res = HistoricalDataResource.getHistoricalData();
		assertNotNull(res);
	}
	

}
