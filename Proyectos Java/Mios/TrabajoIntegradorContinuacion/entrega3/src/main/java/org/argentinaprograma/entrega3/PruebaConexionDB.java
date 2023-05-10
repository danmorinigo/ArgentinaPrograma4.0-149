package org.argentinaprograma.entrega3;

import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaConexionDB {

	public static void main(String[] args) {
		
		try {
			//Registro Driver
			Class<?> C = Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(C.descriptorString());

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
	}

}
