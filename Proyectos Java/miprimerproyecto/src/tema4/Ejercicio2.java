package tema4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese nombre para archivo texto");
		String nombreArchivo = entrada.nextLine();
		
		String ruta = "src/tema4/" + nombreArchivo + ".txt";
		Path rutaRelativa = Paths.get(ruta);
		System.out.println("Ruta absoluta del archivo será:");
		System.out.println(rutaRelativa.toAbsolutePath());
		
		if(Files.exists(rutaRelativa)) {
			System.out.println("Archivo existe, será reemplazado.");
		}else {
			System.out.println("Archivo NO existe.");
		}
		
		System.out.println("Ingrese numeros separados por \"-\"");
		String numeros = entrada.nextLine();
		String conSaltos = numeros.replace("-", "\n");
		
		if(!(conSaltos.endsWith("\n"))) {
			conSaltos = conSaltos + "\n";
		}

		try {
			Files.deleteIfExists(rutaRelativa);
			Files.createFile(rutaRelativa);
			Files.write(rutaRelativa, conSaltos.getBytes());
			//FileTime fecha = Files.getLastModifiedTime(rutaRelativa);
			//System.out.println(fecha);
			//Path unTemporal = Files.createTempFile("unPrefijo",".txt");
			//System.out.println(unTemporal);
			//System.out.println( Files.isDirectory(unTemporal) );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Entro al CATCH");
			e.printStackTrace();
		}
		
		System.out.println("Ingrese MAS numeros separados por \"-\"");
		numeros = entrada.nextLine();
		conSaltos = numeros.replace("-", "\n");
		
		if(!(conSaltos.endsWith("\n"))) {
			conSaltos = conSaltos + "\n";
		}
		
		try {
			Files.write(rutaRelativa, conSaltos.getBytes(), StandardOpenOption.APPEND);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("1- Sumar\n2- Multiplicar: ");
		int eleccion = entrada.nextInt();
		
		entrada.close();
		
		switch(eleccion) {
		case 1:
			System.out.println("Sumando...");
			break;
		case 2:
			System.out.println("Multiplicando...");
			break;
		}
		
		try {
			int resultado;
			int numeroActual;
			if(eleccion == 1) {
				resultado = 0;
			}else {
				resultado = 1;
			}
			
			for(String fila : Files.readAllLines(rutaRelativa)) {
				System.out.println(fila);
				numeroActual = Integer.parseInt(fila);
				if(eleccion == 1) {
					resultado += numeroActual;
				}else {
					resultado *= numeroActual;
				}
			}
			System.out.println("El resultado: " + resultado);
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}
}
