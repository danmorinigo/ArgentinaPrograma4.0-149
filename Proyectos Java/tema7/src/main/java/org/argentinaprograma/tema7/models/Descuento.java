package org.argentinaprograma.tema7.models;

public abstract class Descuento {
	
	protected Double valor;

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Double getValor() {
		return valor;
	};
	
	public abstract Double aplicarDescuento(Double monto);
	
	public abstract Double valorDescuento();
	
}
