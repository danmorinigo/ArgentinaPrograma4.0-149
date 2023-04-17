package org.argentinaprograma.tema11;

import org.argentinaprograma.tema11.models.Chat;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import lombok.Cleanup;

public class UsoChat {

	public static void main(String[] args) {

		String archivoChat = "src/main/resources/chat.txt";
		Path rutaArchivoChat = Paths.get(archivoChat);
		System.out.println(Files.exists(rutaArchivoChat));
		
		if(!Files.exists(rutaArchivoChat)) {
			try {
				Files.createFile(rutaArchivoChat);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Files.exists(rutaArchivoChat));
		@Cleanup
		Scanner in = new Scanner(System.in);
		System.out.print("Ingrese su nombre: ");
		String nombre = in.nextLine();
		Chat.iniciarConDatos(nombre, rutaArchivoChat);
		System.out.println("Adios!");
	}

}
