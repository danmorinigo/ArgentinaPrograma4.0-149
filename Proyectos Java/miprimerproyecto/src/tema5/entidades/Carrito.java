package tema5.entidades;

public class Carrito {
	
	private ItemCarrito[] items = new ItemCarrito[3];
	
	public Carrito(ItemCarrito[] itemsDelCarrito) {
		for(int i = 0; i < itemsDelCarrito.length; i++) {
			items[i] = itemsDelCarrito[i];
		}
	}

	public void listarArticulos() {
		System.out.println("Cantidad\tPrecio Unitario\tProducto");
		for(int j = 0; j < items.length; j++) {
			System.out.println(items[j].getCantidad() + "\t" +
			items[j].getProducto().getPrecio().toString() + "\t" + 
			items[j].getProducto());
		}
	}
	
	public double precio() {
		double valorCarrito = 0.0;
		for(ItemCarrito enCarrito : items) {
			valorCarrito += enCarrito.getCantidad() * enCarrito.getProducto().getPrecio(); 
		}
		return valorCarrito;
	}
}
