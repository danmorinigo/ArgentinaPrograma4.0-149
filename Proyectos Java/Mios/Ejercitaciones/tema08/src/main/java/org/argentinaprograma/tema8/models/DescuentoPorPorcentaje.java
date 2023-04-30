package org.argentinaprograma.tema8.models;

import org.argentinaprograma.tema8.exceptions.MontoMenorADescuentoException;

public class DescuentoPorPorcentaje extends Descuento{

	private Double valorDelDescuento;
	
	@Override
	public Double aplicarDescuento(Double monto) 
		throws MontoMenorADescuentoException{
		Double montoAPagar = 0.0;
		valorDelDescuento = conDosDecimales(monto * (valor / 100.0));
		if(monto >= valorDelDescuento) {
			montoAPagar = monto - valorDelDescuento;
		}else {
			throw new MontoMenorADescuentoException();
		}
		return montoAPagar;
	}

	@Override
	public Double valorDescuento() {
		return valorDelDescuento;
	}

}
