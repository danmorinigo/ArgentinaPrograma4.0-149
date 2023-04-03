package org.argentinaprograma.tema7.models;

public class DescuentoPorcentajeConTope extends Descuento{

	private Double monto;
	private Double maximoDescuento;
	private Double porcentajeAAPlicar;
	
	private Double descuentoAAplicar;
	
	public DescuentoPorcentajeConTope(Double porcentaje, Double maximoDescuento) {
		this.maximoDescuento = maximoDescuento;
		this.porcentajeAAPlicar = porcentaje;
	}
	
	private void calcularMontoDescuento() {
		if((monto * (porcentajeAAPlicar / 100)) < maximoDescuento){
			descuentoAAplicar = monto * (porcentajeAAPlicar / 100);
		}else {
			descuentoAAplicar = maximoDescuento;
		}
		System.out.println("%-> " + (monto * (porcentajeAAPlicar / 100)) +
				" Por tope -> " + descuentoAAplicar);
	}
	@Override
	public Double aplicarDescuento(Double monto) {
		this.monto = monto;
		this.calcularMontoDescuento();
		
		return monto - descuentoAAplicar;
	}

	@Override
	public Double valorDescuento() {
		
		return descuentoAAplicar;
	}

}
