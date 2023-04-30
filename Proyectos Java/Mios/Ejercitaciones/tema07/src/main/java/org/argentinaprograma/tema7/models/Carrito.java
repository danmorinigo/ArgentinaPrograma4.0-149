package org.argentinaprograma.tema7.models;

import java.util.List;
import java.util.ArrayList;

public class Carrito {
	
	List<ItemCarrito> items;
	Descuento descuento;
	
	public Carrito() {
		descuento = new DescuentoFijo();
		descuento.setValor(0.0);
		items = new ArrayList<ItemCarrito>();
	}
	
	public Carrito(String tipoDescuento, double valorDescuento) {
		if(tipoDescuento.equalsIgnoreCase("f")) {
			descuento = new DescuentoFijo();
			descuento.setValor(valorDescuento);
		}else if(tipoDescuento.equalsIgnoreCase("%")) {
			descuento = new DescuentoPorPorcentaje();
			descuento.setValor(valorDescuento);
		}else if(tipoDescuento.equalsIgnoreCase("%ct")) {
			
		}else {
			descuento = new DescuentoFijo();
			descuento.setValor(0.0);
			//no se entiende el tipo de descuento, no se aplica ninguno
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
		System.out.println("Cantidad\tPrecio Unitario\t\tProducto");
		System.out.println("--------\t---------------\t\t--------");
		for(ItemCarrito item : this.getItems()) {
			System.out.println("   " + item.getCantidad() + "\t\t" +
			item.getProducto().getPrecio().toString() + "\t\t\t" + 
			item.getProducto().getNombre());
		}
	}

	public Double precioSinDescuento() {
		Double valorCarrito = 0.0;
		for(ItemCarrito enCarrito : this.getItems()) {
			valorCarrito += enCarrito.precio(); 
		}
		return aDosDecimales(valorCarrito);
	}
	
	private Double aDosDecimales(Double unValorARedondear) {
		return (double)(Math.round(unValorARedondear * 100) / 100d);
	}

	public double precioConDescuento() {
		return descuento.aplicarDescuento(this.precioSinDescuento());
	}
	
	public double ahorro() {
		return descuento.valorDescuento();
	}
}
