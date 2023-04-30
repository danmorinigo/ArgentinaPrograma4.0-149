package miprimerproyecto.EjemploObras;

public class Libro extends Obra{
	
	private int numeroPaginas;
	
	public Libro(String titulo, String autor, int numeroPaginas) {
		super(titulo, autor);
		this.numeroPaginas = numeroPaginas;
	}

	public String getAtributos() {
		return super.getAtributos() + "\n El número de páginas que tiene es: "+ this.numeroPaginas;
	}
	
}
