package org.argentinaprograma.tema7.models;

public class DescuentoPorPorcentaje extends Descuento{

	private Double valorDelDescuento;
	
	@Override
	public Double aplicarDescuento(Double monto) {

		valorDelDescuento = conDosDecimales(monto * (valor / 100.0));
		return (monto - valorDelDescuento);
	}

	@Override
	public Double valorDescuento() {
		return valorDelDescuento;
	}

}
