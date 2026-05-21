package test;
import java.time.LocalDate;

import modelo.*;

public class testSistemaDeActualizacionDNI {

	public static void main(String[] args) {
		Sistema s = new Sistema(7500.0f,14000.0f,11000.0f);
		 
		//======================================================================================
		//======================================================================================
		//======================================================================================
		try {
			System.out.println(" -------------SETUP---------------");
			s.agregarPersona(11111111, "Rodrigues", "Omar", LocalDate.of(1951, 4, 29), true);
			s.agregarPersona(22222222, "Perez", "Luis", LocalDate.of(2008, 4, 29), true);
			s.agregarPersona(33333333, "Pereyra", "Mariana", LocalDate.of(1982, 3, 25), false);
			s.agregarPersona(44444444, "Rodrigues", "Omar", LocalDate.of(2014, 4, 7), true);
			s.agregarPersona(55555555, "Rodrigues", "Omar", LocalDate.of(1935, 1, 27), true);
			
			System.out.println("Objetos agregados con éxito: ");
			for(Persona o:s.getLstPersonas()) {
				System.out.println(o);
			}
			System.out.println("\n");
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//======================================================================================
		//======================================================================================
		
		//======================================================================================
		//======================================================================================
		try {
			
			s.agregarLugarDeTramite("Av. Paseo Colon 1093 CABA");
			s.agregarLugarDeTramite("Laprida N642 Lomas De Zamora");
			s.agregarLugarDeTramite("Miguel Carne N112 Lanús");
			
			System.out.println("Objetos agregados con éxito: ");
			for(LugarDeTramite o:s.getLstLugarDeTramite()) {
				System.out.println(o);
			}
			System.out.println("\n");
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//======================================================================================
		//======================================================================================
		
		//======================================================================================
		//======================================================================================
		try {
			
			s.agregarActualizacionDNI(s.traerLugarDeTramite(2), LocalDate.of(2026, 4, 7), s.traerPersona(33333333), true);
			s.agregarActualizacionDNI(s.traerLugarDeTramite(1), LocalDate.of(2026, 4, 29), s.traerPersona(11111111), false);
			s.agregarActualizacionDNI(s.traerLugarDeTramite(2), LocalDate.of(2026, 4, 29), s.traerPersona(22222222), false);
			s.agregarActualizacionDNI(s.traerLugarDeTramite(2), LocalDate.of(2026, 4, 29), s.traerPersona(44444444), false);
			s.agregarActualizacionDNI(s.traerLugarDeTramite(1), LocalDate.of(2026, 4, 29), s.traerPersona(55555555),  true);
			
			System.out.println("Objetos agregados con éxito: ");
			for(ActualizacionDNI o:s.getLstActualizacionDNI()) {
				System.out.println(o);
				System.out.println("Edad del día del trámite: " + o.getPersona().calcularEdad(o.getFecha()) );
			}
			
			System.out.println("\n");
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//======================================================================================
		//======================================================================================
		

		
		
		System.out.println("\n");
		System.out.println("Test 1: ----------------------------");
		//======================================================================================
		//======================================================================================
		//======================================================================================
		try {
			System.out.println("Prueba Error ");
			s.agregarPersona(66666666, "Romero", "Maria", LocalDate.of(2026, 9, 17), true);
			
			System.out.println("Objetos agregados con éxito: ");
			for(Persona o:s.getLstPersonas()) {
				System.out.println(o);
			}
			System.out.println("\n");
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//======================================================================================
		//======================================================================================
		
		System.out.println("\n");
		System.out.println("Test 2: ----------------------------");
		
		//======================================================================================
		//======================================================================================
		//======================================================================================
		try {
			System.out.println("Prueba traerPersona ");
			System.out.println(s.traerPersona(11111111));
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//======================================================================================
		//======================================================================================

		System.out.println("\n");
		System.out.println("Test 3: ----------------------------");
		
		//======================================================================================
		//======================================================================================
		//======================================================================================
		try {
			System.out.println("Prueba calcularEdad ");
			System.out.println(s.traerPersona(11111111).calcularEdad(LocalDate.of(2026, 5, 6)));
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//======================================================================================
		//===============================
		
		System.out.println("\n");
		System.out.println("Test 4: ----------------------------");
		
		//======================================================================================
		//======================================================================================
		//======================================================================================
		try {
			System.out.println("Prueba traerLugar ");
			System.out.println(s.traerLugarDeTramite(2));
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//======================================================================================
		//======================================================================================
		
		System.out.println("\n");
		System.out.println("Test 5: ----------------------------");
		
		//======================================================================================
		//======================================================================================
		//======================================================================================
		try {
			System.out.println("Prueba traerActualizaciones ");
			System.out.println(s.traerActualizacionesDNI(LocalDate.of(2026, 4, 29),s.traerLugarDeTramite(1)));
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//======================================================================================
		//======================================================================================
		System.out.println("\n");
		System.out.println("Test 6: ----------------------------");
		//======================================================================================
		//======================================================================================
		try {
			System.out.println("10)");
			System.out.println("Recaudación: " + s.calcularRecaudacion(LocalDate.of(2026, 4, 7), s.traerLugarDeTramite(2)));
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//======================================================================================
		//======================================================================================
		
	}

}
