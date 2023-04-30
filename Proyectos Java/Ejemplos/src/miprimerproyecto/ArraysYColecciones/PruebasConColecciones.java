package miprimerproyecto.ArraysYColecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class PruebasConColecciones {
	
	public static void main(String[] args) {
	
		//Colección tipo Lista
		System.out.println("Colección tipo lista");
		List<String> palabras = new ArrayList<String>();
		
		palabras.add("casa");
		palabras.add("hotel");
		palabras.add("cabaña");
		palabras.add("casa");
		palabras.add("casa");
		
		System.out.println(palabras);
		
		palabras.remove("casa");
		
		System.out.println(palabras);
		
		
		List<String> palabrasABorrar = new ArrayList<String>();
		palabrasABorrar.add("casa");
		palabrasABorrar.add("hotel");
		
		palabras.removeAll(palabrasABorrar);
		
		System.out.println(palabras);
		
		//Coleccion tipo HashMap
		//Map<Key,Value>
		
		Map<Integer,String> ejemploASCII = new HashMap<Integer,String>();
		
		ejemploASCII.put(97,"a");
		ejemploASCII.put(98,"b");
		
		System.out.println("Antes de agregar claves duplicadas");
		System.out.println(ejemploASCII);
		
		ejemploASCII.put(97,"h");
		System.out.println("Despues de agregar claves duplicadas");
		System.out.println(ejemploASCII);
		
		System.out.println("Quiero imprimir el valor de la key 98:"+ejemploASCII.get(98));
	
		Map<String,Integer> edadesPersonas = new HashMap<String,Integer>();
		
		edadesPersonas.put("Juan", 12);
		edadesPersonas.put("Pablo",15);
		
		System.out.println(edadesPersonas);
		
		edadesPersonas.put("Juan", 15);
		System.out.println(edadesPersonas);
		
	HashSet<String> lenguajes = new HashSet<String>();
		
		lenguajes.add("Java");
		lenguajes.add("Python");
		lenguajes.add("C++");
		lenguajes.add("Java");
		lenguajes.add("Java");
		lenguajes.add("Java");
		lenguajes.add("Java");
		lenguajes.add("Java");
		lenguajes.add("JaVa");
		
		System.out.println(lenguajes);
		
	}

}
