package test;

import java.time.LocalDate;

import modelo.Funciones;

public class TestFunciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocalDate fechaHoy = LocalDate.of(2024, 9, 11);
		LocalDate fechaDesde = LocalDate.of(2024, 9, 9);
		LocalDate fechaHasta = LocalDate.of(2024, 9, 13);
		
		System.out.println(Funciones.fechaEntreFechas(fechaHoy, fechaHoy, fechaHasta));
		System.out.println(Funciones.fechaEntreFechas2(fechaHoy, fechaDesde, fechaHoy));
		
	}

}
