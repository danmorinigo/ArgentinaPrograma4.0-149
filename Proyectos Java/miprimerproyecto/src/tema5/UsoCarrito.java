package tema5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import tema5.entidades.Producto;
import tema5.entidades.ItemCarrito;
import tema5.entidades.Carrito;

public class UsoCarrito {

	public static void main(String[] args) {

		//Armo objetos 6 Productos
		String archivoProductos = "src/tema5/Productos.txt";
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
		
		ItemCarrito[] itemsCarrito1 = new ItemCarrito[3];
		ItemCarrito[] itemsCarrito2 = new ItemCarrito[3];
		for(int i = 0; i < 3; i++) {
			itemsCarrito1[i] = itemCarrito[i];
		}
		for(int i = 0; i < 3; i++) {
			itemsCarrito2[i] = itemCarrito[i + 3];
		}
		 
		Carrito carrito1 = new Carrito(itemsCarrito1);
		Carrito carrito2 = new Carrito(itemsCarrito2);
		
		carrito1.listarArticulos();
		System.out.println("  TOTAL --->" + carrito1.precio() + "<---");
		carrito2.listarArticulos();
		System.out.println("  TOTAL --->" + carrito2.precio() + "<---");
	}

}
