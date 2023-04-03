package org.argentinaprograma.tema7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.argentinaprograma.tema7.models.Producto;
import org.argentinaprograma.tema7.models.ItemCarrito;
import org.argentinaprograma.tema7.models.Carrito;
import org.argentinaprograma.tema7.models.DescuentoFijo;
import org.argentinaprograma.tema7.models.DescuentoPorPorcentaje;

public class UsoCarrito {

	public static void main(String[] args) {

		//Armo objetos 6 Productos
		String archivoProductos = "src/main/java/org/argentinaprograma/tema7/resources/Productos.txt";
		Path pathProductos = Paths.get(archivoProductos);
		System.out.println(pathProductos.toAbsolutePath());
		Producto[] producto = new Producto[6];
		ItemCarrito[] itemCarrito = new ItemCarrito[6];
	
		try {
			for(int i = 0; i < Files.readAllLines(pathProductos).size(); i++) {

				String [] linea = Files.readAllLines(pathProductos).get(i).split(",");
				producto[i] = new Producto();
				producto[i].setNombre(linea[0]);
				producto[i].setPrecio(Double.parseDouble(linea[1]));
				producto[i].setDescripcion(linea[2]);
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Armo 6 itemCarrito
		
		for(int i = 0; i < 6; i++) {
			itemCarrito[i] = new ItemCarrito(producto[(int)(Math.round(Math.random() * 5))], (int)(Math.round(Math.random() * 9) + 1));
		}
		
		//Armo 2 carritos
		
		Carrito carrito1 = new Carrito("f", 123.6);
		Carrito carrito2 = new Carrito(5.0, 390.0);
		for(int i = 0; i < 3; i++) {
			carrito1.agregar(itemCarrito[i]);
		}
		for(int i = 0; i < 3; i++) {
			carrito2.agregar(itemCarrito[i + 3]);
		}
		 
		carrito1.listarArticulos();
		Double total1 = carrito1.precioSinDescuento();
		Double totalDesc1 = carrito1.precioConDescuento();
		System.out.println("  TOTAL sin Descuento --->" + total1 + "<---");
		System.out.println("  TOTAL con Descuento --->" + totalDesc1 + "<---" +
				"[Ahorro -> $" + carrito1.ahorro() + "]");
		
		Double total2 = carrito2.precioSinDescuento();
		Double totalDesc2 = carrito2.precioConDescuento();
		carrito2.listarArticulos();
		System.out.println("  TOTAL sin Descuento --->" + total2 + "<---");
		System.out.println("  TOTAL con Descuento --->" + totalDesc2 + "<---" +
				"[Ahorro -> $" + carrito2.ahorro() + "]");
	}

}
