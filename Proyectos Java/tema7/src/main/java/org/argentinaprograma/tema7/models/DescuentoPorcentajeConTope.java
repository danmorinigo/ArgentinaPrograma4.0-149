package org.argentinaprograma.tema7.models;

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
	public Double aplicarDescuento(Double monto) {
		this.monto = conDosDecimales(monto);
		this.calcularMontoDescuento();
		
		return monto - descuentoAAplicar;
	}

	@Override
	public Double valorDescuento() {
		
		return descuentoAAplicar;
	}

}
