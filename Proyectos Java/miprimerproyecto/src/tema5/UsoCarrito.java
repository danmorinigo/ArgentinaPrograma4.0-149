package tema5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import tema5.entidades.Producto;
public class UsoCarrito {

	public static void main(String[] args) {

		//Armo objetos 6 Productos
		String archivoProductos = "src/tema5/Productos.txt";
		Path pathProductos = Paths.get(archivoProductos);
		System.out.println(pathProductos.toAbsolutePath());
		System.out.println(Files.exists(pathProductos));
		Producto[] producto = new Producto[6];
		
		try {
			//String[] linea = new String[6];
			
			for(int i=0; i < Files.readAllLines(pathProductos).size(); i++) {
				String [] linea = Files.readAllLines(pathProductos).get(i).split(",");
				producto[i].setNombre(linea[0]);
			
				for(String dato : linea) {
					System.out.println(dato);
				}
			}
			
			/*for(String fila : Files.readAllLines(pathProductos)) {
				
				linea = fila.split(",");
				for(String palabra : linea) {
					System.out.println(palabra);
				}
			}*/
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
