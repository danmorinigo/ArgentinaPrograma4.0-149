package org.argentinaprograma.tema11.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import lombok.Cleanup;

public class Chat {
	
	private static String nombre;
	private static Path rutaArchivo;
	
	public static void iniciarConDatos(String nombreChateando,
			Path rutaArchivoChat) {

		nombre = nombreChateando;
		rutaArchivo = rutaArchivoChat;
		
		@Cleanup
		Scanner entrada = new Scanner(System.in);
		String eleccion = "";
		while(!eleccion.equalsIgnoreCase("s")) {
			eleccion = "";
			while(!eleccion.equalsIgnoreCase("l") && !eleccion.equalsIgnoreCase("e") && !eleccion.equalsIgnoreCase("s")) {
				System.out.print(nombre + ", " + "leer chats, escribir o salir?? <L> / <E> / <S>: ");
				eleccion = entrada.nextLine();
			}
			eleccion = eleccion.toLowerCase();
			switch (eleccion) {
			case "l":
				leerYmostrarChat();
				break;
			case "e":
				System.out.print("Escribir ---> ");
				String texto = entrada.nextLine();
				String linea = nombre + "£" + texto + "\n";
				registrarChat(linea);
				break;
			}
		}
	}

	private static void registrarChat(String linea) {

		try {
			Files.write(rutaArchivo, linea.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void leerYmostrarChat() {
		
		try {
			if(Files.readAllLines(rutaArchivo).isEmpty()) {
				System.out.println("No hay chats.");
			}else {
				String[] separados;
				for(String linea : Files.readAllLines(rutaArchivo)) {
					separados = linea.split("£"); //caracter 156
					System.out.println(separados[0] + ":::> " + separados[1] + "<<FIN>>");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
