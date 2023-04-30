package miprimerproyecto.StringsEncodeYDecode;

public class ClaseConString {

	public static void main(String[] args) {
		
		String txt1 = "Hola clase!";

		System.out.println(txt1);
		
		String txt2 = "Cantidad de elementos que tiene el string: "+txt1.length();
		
		System.out.println(txt2);
		
		//Como hago para imprimir el elemento por ejemplo numero 2
		System.out.println(txt1.charAt(1));
		
		if(txt1.equalsIgnoreCase(txt2)) {
		
		}
		
		System.out.println(txt1.toUpperCase());
		
		System.out.println("HOLA QUE TAL".toLowerCase());
		
		String apellidoYNombre = "Ramirez, Nahuel";
		
		String nombreYApellidoSeparados[] = apellidoYNombre.split(",");
		
		System.out.println(nombreYApellidoSeparados[0]);
		System.out.println(nombreYApellidoSeparados[1]);
		
		String muchasPalabras = "casa arbol mandarina naranja";
		
		for(String unaPalabra : muchasPalabras.split(" ")) {
			System.out.println(unaPalabra);
		}
		
		String dosLineas = "La casa.\nHola.";
		System.out.println(dosLineas);
		
		String txt3 = "hola de vuelta, hola hola hola";
		System.out.println(txt3.replace("hola","chau"));
		
		
	}

}
