package miprimerproyecto.Tema5;

import miprimerproyecto.Tema5.Entidades.Carrito;
import miprimerproyecto.Tema5.Entidades.Persona;
import miprimerproyecto.Tema5.Entidades.Producto;

public class IntroduccionAObjetos {

	public static void main(String[] args) {
		
		//Instancie una persona
		Persona nahuel = new Persona("Nahuel","Ramirez");
		System.out.println(nahuel.getApellido()+", "+nahuel.getNombre());
		
		//Instanciar 3 productos
		Producto harina = new Producto("harina");
		Producto roastBeef = new Producto("roast beef","Carne de ternera",1200.0);
		Producto leche = new Producto("leche","Producto lacteo ultra pasteurizado", 210.0);		
		
		//Instancio un carrito
		Carrito carrito = new Carrito(nahuel,leche,roastBeef,leche);
		
		System.out.println("Costo final del carrito: "+carrito.costoFinal());		
	}

}
