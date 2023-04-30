package miprimerproyecto.EjemploFiguras;

public class Cuadrado extends DosDimensiones{
	
	public double calcularArea() {
		return super.base*super.altura;
	}
	
	public void imprimirArea() {
		System.out.println("El área es: "+this.calcularArea());
	}

}
