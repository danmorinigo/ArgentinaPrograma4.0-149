package org.argentinaprograma.tema9;

import org.argentinaprograma.tema9.models.Persona;

import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

import lombok.Cleanup;

/**
 * Hello world!
 *
 */


public class App {
    
	public static void main( String[] args )
    {
        List<Persona> personas = new ArrayList<Persona>();
    	
        String eleccion = "S";
      
        

        @Cleanup
        Scanner entrada = new Scanner(System.in);
		        
        Persona persona;
    	
    	while(eleccion.toUpperCase().equals("S")) {
    		String texto = "";
    	    int dia = -1;
    	    int mes = -1;
    	    int anio = -1;
    	    
    	    persona = new Persona();
    		
    	    while(texto.isEmpty()) {
    			System.out.print("Nombre: ");
    			texto = entrada.nextLine();
    		}
    		persona.setNombre(texto);
    		texto = "";
    		
    		while(texto.isEmpty()) {
    			System.out.print("Apellido: ");
    			texto = entrada.nextLine();
    		}
    		persona.setApellido(texto);
    		
    		System.out.println("-Fecha de Nacimiento-");
    		
    		while(dia < 0) {
    			System.out.print("Dia: ");
    			dia = entrada.nextInt();
    		}
    		
    		while(mes < 0) {
    			System.out.print("Mes: ");
    			mes = entrada.nextInt();
    		}
    		
    		while(anio < 0) {
    			System.out.print("Año: ");
    			anio = entrada.nextInt();
    		}
    		
    		persona.setFechaNacimiento(LocalDate.of(anio, mes, dia));
    		personas.add(persona);
    		
    		System.out.print("Ingresa otro nombre? <S>: ");
    		entrada.nextLine();
    		
    		eleccion = entrada.nextLine();
    	}
    	System.out.printf("%-13s%-13s%-15s\n", "Nombre", "Apellido", "Nacimiento");
    	System.out.printf("%-13s%-13s%-15s\n", "------", "--------", "----------");
    	for(Persona gente : personas) {
        	Integer diaNacimiento = (gente.getFechaNacimiento().getDayOfMonth());
        	Integer mesNacimiento = (gente.getFechaNacimiento().getMonthValue());
        	Integer anioNacimiento = (gente.getFechaNacimiento().getYear());
        	String fechaNacido = diaNacimiento.toString() + "/" + mesNacimiento.toString() + "/" + anioNacimiento.toString();
        	System.out.printf("%-13s%-13s%-15s\n", gente.getNombre(), gente.getApellido(), fechaNacido);
        }
    }
}

