package org.argentinaprograma.tema7.models;

public class DescuentoPorPorcentaje extends Descuento{

	private Double monto;
	
	@Override
	public Double aplicarDescuento(Double monto) {

		this.monto = monto;
		return (monto - (monto * (valor / 100.0)));
	}

	@Override
	public Double valorDescuento() {
		return (monto * (valor / 100.0));
	}

}
