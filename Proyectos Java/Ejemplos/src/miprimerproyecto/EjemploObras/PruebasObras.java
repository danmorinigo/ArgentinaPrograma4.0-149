package miprimerproyecto.EjemploObras;

public class PruebasObras {

	public static void main(String[] args) {

		
		//Creacion de instancia del objeto libro
		Libro libro1 = new Libro("Harry Potter","J.K.",200);
		
		System.out.println(libro1.getAtributos());
		
		
		//Creación de instancia del objeto cuadro
		Cuadro cuadro1 = new  Cuadro("La Mona Lisa","Leonardo da Vinci",77,53);
		System.out.println(cuadro1.getAtributos());
		
		//Creación de instancia del objeto articulo
		
		Articulo art1 = new Articulo("Nombre de articulo","autor");
		System.out.println(art1.getAtributos());
		
			
		
	}

}
