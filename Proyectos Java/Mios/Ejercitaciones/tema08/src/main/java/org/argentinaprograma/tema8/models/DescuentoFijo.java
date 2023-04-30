package org.argentinaprograma.tema8.models;

import org.argentinaprograma.tema8.exceptions.MontoMenorADescuentoException;

public class DescuentoFijo extends Descuento {

	@Override
	public Double aplicarDescuento(Double monto) 
	throws MontoMenorADescuentoException{
		Double montoAPagar = 0.0;
		if(conDosDecimales(monto) > valor) {
			montoAPagar = conDosDecimales(monto) - valor;
		}else {
			throw new MontoMenorADescuentoException();
		}
		return montoAPagar;
		
	}

	@Override
	public Double valorDescuento() {

		return valor;
	}

}
