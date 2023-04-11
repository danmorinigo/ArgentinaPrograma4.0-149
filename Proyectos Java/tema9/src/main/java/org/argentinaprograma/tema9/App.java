package org.argentinaprograma.tema9;

import org.argentinaprograma.tema9.models.Persona;

import java.util.List;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	Persona persona = new Persona();
    	try {
    		persona.setNombre(null);
    	}catch(NullPointerException e) {
    		persona.setNombre(null);
    		e.fillInStackTrace();
    		System.out.println(e.fillInStackTrace());
    		System.out.println(e.getSuppressed());
    		System.out.println("Nombre no puede ser nulo.");
    	}
    	System.out.println(persona.getNombre());
        
    }
}
