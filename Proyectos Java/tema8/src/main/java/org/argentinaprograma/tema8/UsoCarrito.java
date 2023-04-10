package org.argentinaprograma.tema8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.argentinaprograma.tema8.models.Producto;
import org.argentinaprograma.tema8.models.ItemCarrito;
import org.argentinaprograma.tema8.exceptions.CostoCarritoEsCeroException;
import org.argentinaprograma.tema8.exceptions.DescuentoNoIdentificadoException;
import org.argentinaprograma.tema8.exceptions.MontoMenorADescuentoException;
import org.argentinaprograma.tema8.models.Carrito;
import org.argentinaprograma.tema8.models.DescuentoFijo;
import org.argentinaprograma.tema8.models.DescuentoPorPorcentaje;

public class UsoCarrito {

	public static void main(String[] args) {

		//Armo objetos 6 Productos
		String archivoProductos = "src/main/resources/Productos.txt";
		Path pathProductos = Paths.get(archivoProductos);
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
		
		Carrito carrito1;
		try {
			carrito1 = new Carrito("%", 99.0);
			
		}catch (DescuentoNoIdentificadoException e) {
			carrito1 = new Carrito();
		}
		
		for(int i = 0; i < 6; i++) {
			carrito1.agregar(itemCarrito[i]);
		}
		
		
		Carrito carrito2 = new Carrito(500.0, 390000.0);
		
		for(int i = 0; i < 6; i++) {
			itemCarrito[i] = new ItemCarrito(producto[(int)(Math.round(Math.random() * 5))], (int)(Math.round(Math.random() * 9) + 1));
		}
		
		for(int i = 0; i < 6; i++) {
			carrito2.agregar(itemCarrito[i]);
		}
		 
		resumen(carrito1);
		System.out.println();
		resumen(carrito2);
	}

	private static void resumen(Carrito carrito) {
		carrito.listarArticulos();
		try {
			System.out.printf("%27s%10.2f%1s\n", "[Total sin descuento: $", carrito.precioSinDescuento(),"]");
			detalleDescuento(carrito);
		} catch (CostoCarritoEsCeroException e) {
			System.out.printf("%38s\n", "***[Carrito Vacio]***");
		}
	}

	private static void detalleDescuento(Carrito carrito) {
		try {
			Double precioConDescuento = carrito.precioConDescuento();
			System.out.printf("%27s%10.2f%1s\n", "[Ahorro: $", carrito.ahorro(),"]");
			System.out.printf("%27s%10.2f%1s\n", "[Total con descuento: $", precioConDescuento,"]");
		} catch (MontoMenorADescuentoException e) {
			System.out.printf("%38s\n", "[Descuento superior al costo total]");
			System.out.printf("%38s\n", "[A pagar: $0.00]");
		} catch(CostoCarritoEsCeroException e) {
			System.out.printf("%38s\n", "***[Carrito Vacio]***");
		}
	}

}
