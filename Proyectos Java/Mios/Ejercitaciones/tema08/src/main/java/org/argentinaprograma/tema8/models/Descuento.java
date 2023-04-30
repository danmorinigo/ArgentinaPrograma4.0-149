package org.argentinaprograma.tema8.models;

import org.argentinaprograma.tema8.exceptions.MontoMenorADescuentoException;

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
	
	public abstract Double aplicarDescuento(Double monto)
		throws MontoMenorADescuentoException;
	
	public abstract Double valorDescuento();
	
}
