package Test;

import Numeros.Numero;

public class TestNumero {

	public static void main(String[] args) {
		
		Numero N1 = new Numero (7);
		int n2= 5;
		
		System.out.println("N1: " + N1.getN() + " N2: " + n2);
		System.out.println("N1 + N2: " + N1.sumar(n2));
		System.out.println("N1 * N2: " + N1.multiplicar(n2));
		System.out.println("¿N1 es par? "+ N1.esPar());
		System.out.println("¿N1 es primo? "+ N1.esPrimo());
		System.out.println("N1 como string: "+ N1.convertirAString());
		System.out.println("N1 como double: "+ N1.convertirADouble());
		System.out.println("N1²: "+ N1.calcularPotencia(2));
		System.out.println("N1!: "+ N1.calcularFactorial());
		System.out.println("Prueba de combinatoria: " + N1.numeroCombinatorio(4));
	}

}
