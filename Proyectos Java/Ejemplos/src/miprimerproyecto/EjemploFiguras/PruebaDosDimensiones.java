package miprimerproyecto.EjemploFiguras;

public class PruebaDosDimensiones {

	public static void main(String[] args) {
				
		Triangulo t1 = new Triangulo();
				
		t1.base = 0.4;
		t1.altura = 4.0;
		t1.clasificacion = "Triángulo rectángulo";
		
		Cuadrado c1 = new Cuadrado();
		
		c1.base = 2.0;
		c1.altura = 2.0;
		
		t1.calcularArea();
		
		c1.calcularArea();

		System.out.println("La dimension del triángulo es:"+t1.dimension);
		
		System.out.println("La dimension del cuadrado es:"+c1.dimension);
		
		t1.CambiarDimension();
		
		System.out.println("La dimension del triángulo es:"+t1.dimension);
		
		System.out.println("La dimension del cuadrado es:"+c1.dimension);
		
	}

}
