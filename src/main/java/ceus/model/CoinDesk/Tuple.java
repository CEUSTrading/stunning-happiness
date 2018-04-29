package ceus.model.CoinDesk;

import java.time.LocalDate;

public class Tuple {

	private LocalDate fecha;
	private Double valor;
	
	public Tuple(LocalDate fecha, Double valor) {
		
		this.fecha = fecha;
		this.valor = valor;
		
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
}
