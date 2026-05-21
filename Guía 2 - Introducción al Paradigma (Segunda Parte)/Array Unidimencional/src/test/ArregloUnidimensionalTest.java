package test;

import Array.ArregloUnidimensional;

public class ArregloUnidimensionalTest {

	public static void main(String[] args) {
		int[] datos = {6, 5, 8, 3, 5, 2};
		ArregloUnidimensional array = new ArregloUnidimensional(datos);
		
		System.out.println("El menor número del vector: "+array.traerElMenor());
		System.out.println("El mayor número del vector: "+array.traerElMayor());
		System.out.printf("Promedio: %.1f %n",array.calcularPromedio());
		System.out.print("Vector ordenado ascendentemente: ");
		array.imprimirVector(array.ordenarAscendente());
		System.out.print("Vector ordenado descendentemente: ");
		array.imprimirVector(array.ordenarDescendente());
		int nBusqueda = 3;				
		// %d es para el número entero, %.2f para el double del resultado
		System.out.printf("La frecuencia que aparece %d: %.2f %n", nBusqueda, array.traerFrecuencia(nBusqueda));
		System.out.println("Número que aparece con mayor frecuencia: " + array.traerModa());
		System.out.println("El número 5 esta en la posición: " + array.buscarPosicion(5));
	}
	

}
