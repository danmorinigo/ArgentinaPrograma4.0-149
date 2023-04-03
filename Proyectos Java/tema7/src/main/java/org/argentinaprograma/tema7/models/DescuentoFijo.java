package org.argentinaprograma.tema7.models;

public class DescuentoFijo extends Descuento {

	@Override
	public Double aplicarDescuento(Double monto) {

		return (monto - valor);
	}

	@Override
	public Double valorDescuento() {

		return valor;
	}

}
