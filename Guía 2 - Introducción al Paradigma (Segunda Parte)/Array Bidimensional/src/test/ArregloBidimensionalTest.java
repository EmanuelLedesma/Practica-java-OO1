package test;

import matriz.ArregloBidimensional;

public class ArregloBidimensionalTest {

	public static void main(String[] args) {
		double[][] matriz = new double[3][3];
		ArregloBidimensional matrizA = new ArregloBidimensional(matriz);
		double[][] matriz2 = new double[3][3];
		ArregloBidimensional matrizB = new ArregloBidimensional(matriz2);
		matrizA.llenarAleatorio();
		System.out.println("Matriz generada aleatoriamente:");
	    matrizA.imprimirMatriz();
		matrizB.llenarAleatorio();
		System.out.println("----------------------------------------");
		System.out.println("2da matriz generada aleatoriamente:");
	    matrizB.imprimirMatriz();
	    System.out.println("----------------------------------------");
		System.out.println("Suma de las matrices:");
		ArregloBidimensional matrizResultado = new ArregloBidimensional(matrizA.sumar(matriz2));
		matrizResultado.imprimirMatriz();
		//matrizA.imprimirMatriz(matrizA.sumar(matriz2));
		System.out.println("----------------------------------------");
		System.out.println("Resta de las matrices:");
		matrizA.imprimirMatriz(matrizA.restar(matriz2));
		System.out.println("----------------------------------------");
		System.out.println("matriz A transpuesta:");
		matrizA.imprimirMatriz(matrizA.transpuesta());
		System.out.println("----------------------------------------");
		System.out.println("matrizA * 2:");
		matrizA.imprimirMatriz(matrizA.multiplicar(2));
		System.out.println("----------------------------------------");
		System.out.println("matrizA * matrizB:");
		matrizA.imprimirMatriz(matrizA.multiplicar(matriz2));

	}

}
