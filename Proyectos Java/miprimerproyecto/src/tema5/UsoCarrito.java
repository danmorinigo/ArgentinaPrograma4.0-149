package tema5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import tema5.entidades.Producto;
public class UsoCarrito {

	public static void main(String[] args) {

		//Armo objetos Producto
		String archivoProductos = "src/tema5/Productos.txt";
		Path pathProductos = Paths.get(archivoProductos);
		System.out.println(pathProductos.toAbsolutePath());
		System.out.println(Files.exists(pathProductos));
		Producto[] producto = new Producto[6];
		
		try {
			String[] linea = new String[3];
			for(String fila : Files.readAllLines(pathProductos)) {
				linea = fila.split(",");
				for(String palabra : linea) {
					System.out.println(palabra);
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}