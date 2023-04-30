package org.argentinaprograma.tema7.models;

public class ItemCarrito {
	private int cantidad;
	private Producto producto;
	
	public int getCantidad() {
		return cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public ItemCarrito(Producto producto, int cantidad){
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public double precio() {

		return (this.producto.getPrecio() * this.cantidad);
	}

}
