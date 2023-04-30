package miprimerproyecto.MemoryStackHeap;

//Generación del error de StackOverFlow
public class StackOverflowError {

	public static void main(String[] args) {
		algo(1);
	}
	
	public static void algo(int i) {
		System.err.println(i);
		algo(i+1);
	}

}
