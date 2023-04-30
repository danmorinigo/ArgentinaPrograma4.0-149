package org.argentinaprograma.tema7.models;

public abstract class Descuento {
	
	protected Double valor;

	protected Double conDosDecimales(Double unValorARedondear) {
		return (double)Math.round(unValorARedondear * 100) / 100d;
	}
	
	public void setValor(Double valor) {
		this.valor = conDosDecimales(valor);
	}
	
	public Double getValor() {
		return valor;
	};
	
	public abstract Double aplicarDescuento(Double monto);
	
	public abstract Double valorDescuento();
	
}
