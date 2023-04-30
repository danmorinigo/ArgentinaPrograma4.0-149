package tema5.entidades;

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

}
