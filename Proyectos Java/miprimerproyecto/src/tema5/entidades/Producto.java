package tema5.entidades;

public class Producto {
	
	private String nombre;
	private Double precio;
	private String descripcion;
	
	private static final double precioMinimo = 0.1;
	private static final String sinDescripcion = "SIN DESCRIPCION";
	
	public Producto(String nombre) {
		this.nombre = nombre;
		precio = precioMinimo;
		descripcion = sinDescripcion;
	}
	public Producto(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
		descripcion = sinDescripcion;
	}
	public Producto(String nombre, double precio, String descripcion) {
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
}
