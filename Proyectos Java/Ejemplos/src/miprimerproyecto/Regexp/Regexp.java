package miprimerproyecto.Regexp;

import java.util.regex.Pattern ;

public class Regexp {

	public static void main(String[] args) {
		
		
		String valorIngresadoPorElUsuario = "ramonperez@gmail.com";
		
		//Validar que la cadena de texto ingresada tenga solo 3 números
		String regexp = "[0-9]{3}";
		
		//Validar si es un correo electrónico
		regexp = "([a-z]|[0-9])+@[a-z]+\\.[a-z]+";
		
		if(valorIngresadoPorElUsuario.matches(regexp)) {
			System.out.println("Si responde al formato que esperamos");
		}else{
			System.out.println("No responde al formato");
		};

	}

}
