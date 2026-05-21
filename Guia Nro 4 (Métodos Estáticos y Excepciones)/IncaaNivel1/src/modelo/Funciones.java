package modelo;

import java.time.LocalDate;

public class Funciones {
	
	public static boolean fechaEntreFechas(LocalDate fechaAComparar, LocalDate fechaDesde, LocalDate fechaHasta) {
		return (fechaAComparar.isAfter(fechaDesde) || fechaAComparar.equals(fechaDesde) 
				&& (fechaAComparar.isBefore(fechaHasta)|| fechaAComparar.equals(fechaHasta)));
	}
	
	// FD ------------------------  FH
	
	//  ! --------------F FD    FA   FH ------------------------- F
	public static boolean fechaEntreFechas2(LocalDate fechaAComparar, LocalDate fechaDesde, LocalDate fechaHasta) {
		return !(fechaAComparar.isAfter(fechaHasta) 
				|| fechaAComparar.isBefore(fechaDesde));
	}

}
