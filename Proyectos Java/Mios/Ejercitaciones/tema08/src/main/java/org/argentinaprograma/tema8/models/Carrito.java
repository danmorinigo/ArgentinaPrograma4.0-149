package org.argentinaprograma.tema8.models;

import java.util.List;

import org.argentinaprograma.tema8.exceptions.CostoCarritoEsCeroException;
import org.argentinaprograma.tema8.exceptions.DescuentoNoIdentificadoException;
import org.argentinaprograma.tema8.exceptions.MontoMenorADescuentoException;

import java.util.ArrayList;

public class Carrito {
	
	List<ItemCarrito> items;
	Descuento descuento;
	
	public Carrito() {
		descuento = new DescuentoFijo();
		descuento.setValor(0.0);
		items = new ArrayList<ItemCarrito>();
	}
	

	public Carrito(String tipoDescuento, double valorDescuento)
	throws DescuentoNoIdentificadoException{
		if(tipoDescuento.equalsIgnoreCase("f")) {
			descuento = new DescuentoFijo();
			descuento.setValor(valorDescuento);
		}else if(tipoDescuento.equalsIgnoreCase("%")) {
			descuento = new DescuentoPorPorcentaje();
			descuento.setValor(valorDescuento);
		}else {
			throw new DescuentoNoIdentificadoException();
		}
		items = new ArrayList<ItemCarrito>();
	}
	public Carrito(double porcentaje, double maximoDescuento) {
		descuento = new DescuentoPorcentajeConTope(porcentaje, maximoDescuento);
		items = new ArrayList<ItemCarrito>();
	}
	
	public List<ItemCarrito> getItems(){
		return this.items;
	}
	
	public void agregar(ItemCarrito ic) {
		items.add(ic);
	}
	
	public void quitar(ItemCarrito ic) {
		items.remove(ic);
	}
	
	public void listarArticulos() {
		System.out.printf("%-7s%-15s%-15s\n", "Cant.", "Producto", "Precio unitario");
		System.out.printf("%-7s%-15s%-15s\n", "-----", "--------", "---------------");
		
		for(ItemCarrito item : this.getItems()) {
			System.out.printf("%-7s%-15s%15.2f%n", item.getCantidad(), item.getProducto().getNombre(), item.getProducto().getPrecio()); 
		}
	}

	public Double precioSinDescuento() 
			throws CostoCarritoEsCeroException{
		Double valorCarrito = 0.0;
		for(ItemCarrito enCarrito : this.getItems()) {
			valorCarrito += enCarrito.precio(); 
		}
		if(valorCarrito.equals(0.0)) {
			throw new CostoCarritoEsCeroException();
		}
		return aDosDecimales(valorCarrito);
	}
	
	private Double aDosDecimales(Double unValorARedondear) {
		return (double)(Math.round(unValorARedondear * 100) / 100d);
	}

	public double precioConDescuento() 
	throws MontoMenorADescuentoException, CostoCarritoEsCeroException{
		return descuento.aplicarDescuento(this.precioSinDescuento());
	}
	
	public double ahorro() {
		return descuento.valorDescuento();
	}
}
