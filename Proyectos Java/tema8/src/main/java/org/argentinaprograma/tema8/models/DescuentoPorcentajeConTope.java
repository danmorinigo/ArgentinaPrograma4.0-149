package org.argentinaprograma.tema8.models;

import org.argentinaprograma.tema8.exceptions.MontoMenorADescuentoException;

public class DescuentoPorcentajeConTope extends Descuento{

	private Double monto;
	private Double maximoDescuento;
	private Double porcentajeAAPlicar;
	
	private Double descuentoAAplicar;
	
	public DescuentoPorcentajeConTope(Double porcentaje, Double maximoDescuento) {
		this.maximoDescuento = conDosDecimales(maximoDescuento);
		this.porcentajeAAPlicar = conDosDecimales(porcentaje);
	}
	
	private void calcularMontoDescuento() {
		Double posibleDescuento = conDosDecimales(monto * (porcentajeAAPlicar / 100));
		if(posibleDescuento < maximoDescuento){
			descuentoAAplicar = posibleDescuento;
		}else {
			descuentoAAplicar = maximoDescuento;
		}
	}
	@Override
	public Double aplicarDescuento(Double monto) 
		throws MontoMenorADescuentoException{
		this.monto = conDosDecimales(monto);
		this.calcularMontoDescuento();
		if(monto < descuentoAAplicar) {
			throw new MontoMenorADescuentoException();
		}
		return monto - descuentoAAplicar;
	}

	@Override
	public Double valorDescuento() {
		
		return descuentoAAplicar;
	}

}
