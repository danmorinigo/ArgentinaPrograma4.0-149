package miprimerproyecto.EjemploFiguras;

public class Triangulo extends DosDimensiones{
	
	protected String clasificacion;
	
	public double calcularArea() {
		return this.base*super.altura/2;
	}
	
	public void imprimirArea() {
		System.out.println("El área es: "+this.calcularArea());
	}
	

}
