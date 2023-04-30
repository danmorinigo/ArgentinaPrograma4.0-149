package miprimerproyecto.ScannerYArchivos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LecturaArchivos {

	public static void main(String[] args){
		
		String rutaAbsoluta = "J:\\Documents\\GitHub\\ArgentinaPrograma4.0-149\\recursos\\ArchivoTexto.txt"; 
				
		String rutaRelativa = "recursos/ArchivoTexto.txt";
		
		Path pathDelArchivo = Paths.get(rutaRelativa);
		
		try {
			
			for(String linea : Files.readAllLines(pathDelArchivo)) {
				System.out.println(linea);			
			}
			
		}catch (FileNotFoundException s) {
			System.out.println("El archivo no existe.");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
