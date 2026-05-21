package test;

import modelo.Circulo;
import modelo.Punto;

public class TestPunto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Punto punto1 = new Punto(2, 3);
		Punto punto2 = new Punto(3, 5);
		Punto punto3 = new Punto(2, 31);
		
		System.out.println("Puntos 1 y 2:");
		System.out.println(punto1);
		System.out.println(punto2);
		
		System.out.printf("La distancia entre el punto 1 y 2 es de: %.2f%n", punto1.calcularDistancia(punto2));
		
		System.out.println("Metodo equals:");
		System.out.println(punto1.equals(punto2));
		
		System.out.println("-------------------------------------");
		

				
		Circulo circulo1 = new Circulo(punto1, 10);
		Circulo circulo2 = new Circulo(punto3, 10);
		
		System.out.println(circulo1);
		System.out.println(circulo2);
		
		circulo2.setRadio(punto2);
		System.out.println("Circulo 2 después del método setRadio: "+ circulo2);
		
		System.out.println("Método equals");
		System.out.println(circulo1.equals(circulo2));
		System.out.println("Perimetro del segundo circulo: "+ circulo2.calcularPerimetro());
		System.out.println("Area:"+circulo2.calcularArea());
		System.out.println("Distancia entre circulos: "+ circulo1.calcularDistancia(circulo2));
		
		

	}

}
