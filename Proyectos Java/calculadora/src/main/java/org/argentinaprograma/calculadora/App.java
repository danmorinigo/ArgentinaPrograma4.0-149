package org.argentinaprograma.calculadora;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        if(args.length < 2) {
        	System.out.println("Argumentos insuficientes.");
        	System.exit(88);
        }
        if(args.length > 2) {
        	System.out.println("Demasiados argumentos.");
        	System.exit(88);
        }
        
    	System.out.println(Calculadora.sumar(Double.parseDouble(args[0]), Double.parseDouble(args[1])));
    }
}
