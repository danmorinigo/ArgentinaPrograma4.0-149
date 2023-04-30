package miprimerproyecto.ArraysYColecciones;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PruebasHashSet {

	public static void main(String[] args) {
 
		Map<String,Integer> edadesPersonas = new HashMap<String, Integer>();
		
		edadesPersonas.put("Juan" ,  23 );  
		edadesPersonas.put("Monty" ,  27  );  
		edadesPersonas.put("Richard" ,  21 );  
		edadesPersonas.put("Devid" ,  19 );  
		System.out.println("Antes de agregar claves duplicadas:" );  
		System.out.println(edadesPersonas);  
		//añadiendo claves duplicadas  
		edadesPersonas.put( "Monty" ,  25 );    //reemplazar la edad anterior de Monty  
		edadesPersonas.put( "Devid" ,  19 );  
		System.out.println( "Después de agregar claves duplicadas: " );  
		System.out.println(edadesPersonas); 
		
		HashSet<String> hs=  new  HashSet<String>();  
		//añadiendo valores a HashSet  
		hs.add( "Java" );  
		hs.add( "Python" );  
		hs.add( "C++" );  
		hs.add( "C" );  
		System.out.println( "Antes de agregar valores duplicados y nulos:" );  
		System.out.println(hs);  
		//añadiendo valores duplicados  
		hs.add( "Python" );  
		hs.add( "C" );  
		System.out.println( "Después de agregar valores duplicados: " );  
		System.out.println(hs);  
		//añadiendo valores nulos  
		hs.add( null );  
		hs.add( null );  
		System.out.println( "Después de agregar valores nulos: " );  
		System.out.println(hs);  
	}
	
			
}
