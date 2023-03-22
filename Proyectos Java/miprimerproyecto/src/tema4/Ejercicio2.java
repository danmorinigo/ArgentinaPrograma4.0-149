package tema4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio2 {

	public static void main(String[] args) {
		String ruta = "src/tema4/numeros.tx";
		Path rutaRelativa = Paths.get(ruta);
		System.out.println(rutaRelativa.toAbsolutePath());
		
		System.out.println(Files.exists(rutaRelativa));
		try {
			Files.deleteIfExists(rutaRelativa);
			Files.createFile(rutaRelativa);
			System.out.println(Files.getLastModifiedTime(rutaRelativa));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Entro al CATCH");
			e.printStackTrace();
		}
		
		System.out.println(Files.exists(rutaRelativa));
		
		//FileTime lastModifiedTime = Files.getLastModifiedTime(rutaRelativa);
		//
	}

}
