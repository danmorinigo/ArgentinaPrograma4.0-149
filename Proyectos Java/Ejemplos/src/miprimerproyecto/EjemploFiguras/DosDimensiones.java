package miprimerproyecto.EjemploFiguras;

public class DosDimensiones {
	
	static String dimension = "Dos dimensiones";
	
	public void CambiarDimension(){
		dimension = "Tres dimensiones";
	}	
	
	protected double base;
	protected double altura;
	
	public void mostrarDimension() {
		System.out.println("La base y altura es :"+ base + " y "+ "altura");
	}

}
