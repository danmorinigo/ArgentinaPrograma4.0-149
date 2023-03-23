package tema4;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileTime;

public class Ejercicio2 {

	public static void main(String[] args) {
		String ruta = "src/tema4/numeros.tx";
		Path rutaRelativa = Paths.get(ruta);
		System.out.println(rutaRelativa.toAbsolutePath());
		
		System.out.println(Files.exists(rutaRelativa));
		try {
			Files.deleteIfExists(rutaRelativa);
			Files.createFile(rutaRelativa);
			FileTime fecha = Files.getLastModifiedTime(rutaRelativa);
			System.out.println(fecha);
			Path unTemporal = Files.createTempFile("unPrefijo",".txt");
			System.out.println(unTemporal);
			System.out.println( Files.isDirectory(unTemporal) );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Entro al CATCH");
			e.printStackTrace();
		}
		
		//FileTime fecha = Files.getLastModifiedTime(rutaRelativa);
		//System.out.println(fecha);
		System.out.println(Files.exists(rutaRelativa));
		
		try {
			Path utfFile = Files.createTempFile("some", ".txt");
			Files.write(utfFile, "un texto \ncon eñes ".getBytes()); // UTF 8
			Files.write(utfFile, (System.lineSeparator() + "y acentos á ").getBytes(),StandardOpenOption.APPEND);
			System.out.println(Files.readAllLines(utfFile).size());
			for (String line: Files.readAllLines(utfFile) ) {
				System.out.println(line);
			}
			Path iso88591File = Files.createTempFile("some2", ".txt");
			Files.write(iso88591File, "otro texto con eñes".getBytes(StandardCharsets.ISO_8859_1));
			System.out.println("Por leer iso8859..");
			/*for (String line: Files.readAllLines(iso88591File, Charset.forName(StandardCharsets.ISO_8859_1)) ) {
				System.out.println(line);
			}
			*/
		} catch (IOException e) {
			System.out.println("Entro al CATCH");
			e.printStackTrace();
		}
	}

}
