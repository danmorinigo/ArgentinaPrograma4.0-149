package org.argentinaprograma.entrega3;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PruebaConexionDB {

	public static void main(String[] args) {
		
		Path pathArchivoConfiguracion = Paths.get("src/main/resources/configuracion.ini");
		Connection conexion = null;
		try {
			
			List<String> lineas = Files.readAllLines(pathArchivoConfiguracion);

			String regEx = "((URL:)\\s(([a-z]|[0-9]|\\.|/|:)+$)|(PASSWORD:)\\s(([A-Z]|[a-z]|[0-9])+$)|(USER:)\\s(([a-z]|[0-9])+$))";
			Pattern pattern = Pattern.compile(regEx, Pattern.MULTILINE);
			Matcher matcher;
			String USER = null, URL = null, PASSWORD = null;
			
			for(String linea : lineas) {
				matcher = pattern.matcher(linea);
				while(matcher.find()) {
					for(int i = 2; i <= matcher.groupCount(); i++) {
						if(matcher.group(i) != null) {
							if(matcher.group(i).equalsIgnoreCase("USER:")){
								USER = matcher.group(i + 1);
								i = matcher.groupCount() + 1;
							} else if (matcher.group(i).equalsIgnoreCase("URL:")){
								URL = matcher.group(i + 1);
								i = matcher.groupCount() + 1;
							} else if (matcher.group(i).equalsIgnoreCase("PASSWORD:")) {
								PASSWORD = matcher.group(i + 1);
								i = matcher.groupCount() + 1;
							}
						}
					}
				}
			}

			System.out.println("USER: " + USER);
			System.out.println("URL: " + URL);
			System.out.println("Contraseña: " + PASSWORD);
			System.out.println("END");
		
		
			//Registro Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Creo objeto de conexion		
			conexion = DriverManager.getConnection(
					URL,
					USER,
					PASSWORD);
			
			//Creacion de sentencia
			Statement sentencia = conexion.createStatement();
			
			//Ejecutamos y obtenemos resultados de la sentencia
			
			ResultSet resultado = sentencia.executeQuery("SELECT * FROM pronostico");
		
			int columnas = resultado.getMetaData().getColumnCount();
			
			while(resultado.next()) {
				//System.out.println(resultado.getMetaData());
				System.out.println("Fila (row): " + resultado.getRow());
				String nombreColumna = null;
				for(int i = 1; i <= columnas; i++) {
					nombreColumna = resultado.getMetaData().getColumnName(i);
					System.out.println("\t" + nombreColumna + ": " + resultado.getString(i));
				}
			}
		
		} catch (IOException e) {
			System.out.println("Archivo de configuracion no encontrado.");
		} catch (ClassNotFoundException e) {
			System.out.println("Clase no encontrada");
		} catch (SQLException e) {
			System.out.println("SQL Exception!");
		} finally {
			try {
				
				System.out.println("Cerrando conexion...");
				conexion.close();
				System.out.println("Listo!!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*
		try {
			//Registro Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			//Creo objeto de conexion		
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/prueba",
					"root",
					"Password01"
					);
		
			//Creacion de sentencia
			Statement sentencia = conexion.createStatement();
			Statement sentencia2 = conexion.createStatement();
			
			//Ejecutamos y obtenemos resultados de la sentencia
			
			ResultSet resultado = sentencia.executeQuery("SELECT * FROM alumnos");
			ResultSet nombreIdioma = null;
			int columnas = resultado.getMetaData().getColumnCount();
			String nombreColumna;
			while(resultado.next()) {
				//System.out.println(resultado.getMetaData());
				System.out.println("Fila (row): " + resultado.getRow());
				for(int i = 1; i <= columnas; i++) {
					if(nombreIdioma == null) {
						nombreIdioma = sentencia2.executeQuery("SELECT nombre FROM idiomas WHERE id = " + resultado.getString(columnas));;
					}
					nombreColumna = resultado.getMetaData().getColumnName(i);
					if(i < columnas) {
						System.out.println("\t" + nombreColumna + ": " + resultado.getString(i));
					}else if(i == columnas && nombreIdioma.next()) {
						System.out.println("\t" + nombreColumna + ": " + resultado.getString(i) + " (" + nombreIdioma.getString(1) + ")");
						nombreIdioma = null;
					}else if(i == columnas) {
						nombreIdioma = null;
					}
				}
			}
			conexion.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//---Prueba regex---
		String textoOriginal = "conexion: bla.123.321\r\nnombre: padrio2\r\npassword: asdqwe654\r\n";
		String regEx = "((conexion:)\\s(([a-z]|[0-9]|\\.)+$)|(password:)\\s(([a-z]|[0-9])+$)|(nombre:)\\s(([a-z]|[0-9])+$))";
		System.out.println(textoOriginal.matches(regEx));
		
		Pattern pattern = Pattern.compile(regEx, Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(textoOriginal);

		while (matcher.find()) {
			System.out.println("Full match: " + matcher.group(0));
			System.out.println(".group()->" + matcher.group().toString());
			System.out.println(".groupCount()->" + matcher.groupCount());
			for (int i = 1; i <= matcher.groupCount(); i++) {
				
				
				if(matcher.group(i) != null) {
					System.out.print("\tGroup " + i + ": " + matcher.group(i) + " ");
					System.out.println("Class -> " + matcher.group(i).getClass());
				}
			}
		}

		matcher.reset();
		
		String nombre = null, conexion = null, password = null;
		while (matcher.find()) {
			for(int j = 2; j <= matcher.groupCount(); j++) {
				if(matcher.group(j) != null) {
					if(matcher.group(j).equalsIgnoreCase("nombre:")) {
						nombre = matcher.group(j + 1);
					} else if (matcher.group(j).equalsIgnoreCase("conexion:")){
						conexion = matcher.group(j + 1);
					} else if(matcher.group(j).equalsIgnoreCase("password:")) {
						password = matcher.group(j + 1);
					}
				}
			}
			
		
			System.out.println("--------");
			System.out.println("Full match: " + matcher.group(0));
			System.out.println(".group()->" + matcher.group().toString());
			System.out.println(".groupCount()->" + matcher.groupCount());
			for (int i = 1; i <= matcher.groupCount(); i++) {
				
				
				if(matcher.group(i) != null) {
					System.out.print("\tGroup " + i + ": " + matcher.group(i) + " ");
					System.out.println("Class -> " + matcher.group(i).getClass());
				}
			}
		
			
		}
		
		System.out.println("Nombre: " + nombre);
		System.out.println("Conexion: " + conexion);
		System.out.println("Contraseña: " + password);
	*/	
	}
	
}
