package org.argentinaprograma.tema7.models;

public class DescuentoPorPorcentaje extends Descuento{

	@Override
	public Double aplicarDescuento(Double monto) {

		return (monto - (monto * (valor / 100.0)));
	}

}
