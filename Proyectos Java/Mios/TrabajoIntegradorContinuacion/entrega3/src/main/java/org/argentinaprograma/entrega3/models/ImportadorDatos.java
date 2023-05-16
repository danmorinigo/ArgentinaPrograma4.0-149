package org.argentinaprograma.entrega3.models;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.argentinaprograma.entrega3.exceptions.ErrorCantidadCamposException;
import org.argentinaprograma.entrega3.exceptions.ErrorNumericoException;
import org.argentinaprograma.entrega3.exceptions.IdPartidoNoEncontradoException;

import com.opencsv.bean.CsvToBeanBuilder;

public class ImportadorDatos {

	public static Ronda crearRonda(String rutaDelArchivoDeResultados) {

		String rutaArchivoConCamposCorrectos = verificarCamposArchivoResultados(rutaDelArchivoDeResultados);
		
		Ronda ronda = new Ronda();
	    List<Partido> lineasArchivoResultados = null;
        try {
            // En esta primera línea definimos el archivos que va a ingresar
        	lineasArchivoResultados = new CsvToBeanBuilder(new FileReader(rutaArchivoConCamposCorrectos))
                    // con esta configuración podemos skipear la primera línea de nuestro archivo CSV
                    .withSkipLines(1)
                    // con esta configuración podemos elegir cual es el caracter que vamos a usar para delimitar
                    .withSeparator(',')
                    // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
                    .withType(Partido.class)
                    .build()
                    .parse();

        } catch (IOException e) {
        	e.printStackTrace();
        }
        for(Partido partido : lineasArchivoResultados) {
        	partido.inicializarEquipos();
        	ronda.agregarPartido(partido);
        }
        
        return ronda;
	}

	public static String verificarCamposArchivoResultados(String rutaArchivoDeResultados) {
		
		Path pathArchivoOriginal = Paths.get(rutaArchivoDeResultados);

		String rutaArchivoResultadosCamposCorrectos = "TEMP-resultadosCamposCorrectos.csv";
		Path pathArchivoCamposCorrectos = Paths.get(rutaArchivoResultadosCamposCorrectos);
		
		try {
			Files.deleteIfExists(pathArchivoCamposCorrectos);
			Files.createFile(pathArchivoCamposCorrectos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Leyendo " + pathArchivoOriginal + "...");
		
		try {
			int nroLinea = 1;
			String[] separados;
			String regExNumeros = "[0-9]+";
			for(String linea : Files.readAllLines(pathArchivoOriginal)) {
				//Agrego "enter" al final de cada linea leida
				if(!(linea.endsWith("\n"))) {
					linea = linea + "\n";
				}
				
				separados = linea.split(",");
				if(nroLinea == 1) {
					//Agrego encabezado sin verificar
					Files.write(pathArchivoCamposCorrectos, linea.getBytes(), StandardOpenOption.APPEND);
				}else{
					boolean cantidadCorrectaCampos = false;
					boolean camposGolesCorrectos = false;
					try {
						cantidadCorrectaCampos = chequearCantidadCampos(separados);
					}catch(ErrorCantidadCamposException e) {
						System.out.println("Error cantidad de campos en linea: " + nroLinea);
					}
					
					if(cantidadCorrectaCampos) {
						//Chequeo goles
						try {
							camposGolesCorrectos = chequearCamposGoles(separados, regExNumeros);
						}catch(ErrorNumericoException e) {
							System.out.println("Error \"goles\" en linea: " + nroLinea);
						}
						if(camposGolesCorrectos) {
							//agrego a archivo chequeado
							Files.write(pathArchivoCamposCorrectos, linea.getBytes(), StandardOpenOption.APPEND);
						}
					}
				}
				nroLinea++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		System.out.println("Hecho!");
		return rutaArchivoResultadosCamposCorrectos;
	}

	public static boolean chequearCamposGoles(String[] separados, String regEx)
			throws ErrorNumericoException {
		String golesEqA = separados[3];
		String golesEqB = separados[4];
		if(!(golesEqA.matches(regEx)) || !(golesEqB.matches(regEx))) {
			throw new ErrorNumericoException();
		}
		return true;
	}

	public static boolean chequearCantidadCampos(String[] separados)
			throws ErrorCantidadCamposException {
		if(separados.length != 6) {
			throw new ErrorCantidadCamposException();
		}
		return true;
	}

	public static List<Pronostico> crearPronosticos(String dBPronosticos, Ronda ronda) {
			
			List<Pronostico> pronosticos = new ArrayList<Pronostico>();
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
			
				String participante;
				int idPartido;
				String ganaEquipoA;
				String ganaEquipoB;
				String empate;
				
				Pronostico pronostico = null;
				while(resultado.next()) {
					participante = resultado.getString("participante");
					idPartido = resultado.getInt("id_partido");
					ganaEquipoA = resultado.getString("ganaEquipoA");
					ganaEquipoB = resultado.getString("ganaEquipoB");
					empate = resultado.getString("empate");
					
					try {
						pronostico = new Pronostico(
								participante,
								idPartido,
								ganaEquipoA,
								empate,
								ganaEquipoB,
								ronda);
						pronosticos.add(pronostico);
					} catch (IdPartidoNoEncontradoException e) {
						System.out.println("Para " + participante +" no se encuentra partido "+
								"con id: " + idPartido);
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
					e.printStackTrace();
				}
			}
			
			for (Pronostico p : pronosticos) {
				System.out.println("\tPronostico id: " + p.getId());
			}
			System.out.println("DEVUELVE " + pronosticos.size() + " pronostico(s).");
			return pronosticos;
		}
	
	}
