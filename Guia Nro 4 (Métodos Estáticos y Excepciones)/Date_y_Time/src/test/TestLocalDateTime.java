package test;
import java.time.LocalDate;
import java.time.LocalTime;
import funciones.Funciones;

public class TestLocalDateTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub'
		System.out.println(Funciones.esDiaHabil(LocalDate.of(2026, 5,4 )));
		//Creamos una fecha
		LocalDate fecha=LocalDate.of(2019,3,19);
		// Creamos otra fecha, restamos 5 dias a la anterior
		LocalDate fecha1 = fecha.minusDays(5);
		// Creamos otra fecha, sumamos 4 meses a la anterior
		LocalDate fecha2 = fecha1.plusMonths(4);
	
		System.out.println("Primer Fecha: " +
		fecha.getDayOfMonth()+"/"+fecha.getMonthValue()+"/"+fecha.getYear());
		System.out.println("Segunda Fecha: " +
		fecha1.getDayOfMonth()+"/"+fecha1.getMonthValue()+"/"+fecha1.getYear());
		System.out.println("Tercer Fecha: " +
		fecha2.getDayOfMonth()+"/"+fecha2.getMonthValue()+"/"+fecha2.getYear());
		System.out.println("La primer fecha es anterior a la segunda?: "+ fecha.isBefore(fecha1));
		System.out.println("Y la segunda a la tercera?: "+ fecha1.isBefore(fecha2));
		System.out.println("La primer fecha es posterior a la segunda?: "+ fecha.isAfter(fecha1));
		System.out.println("Y la segunda a la tercera?: "+ fecha1.isAfter(fecha2));
		
		//---------------------------------------------------------------------
		System.out.println("\n---> TEST 1: esBisiesto(int anio)");
        System.out.println("1996 (Bisiesto - Esperado: true): " + Funciones.esBisiesto(1996));
        System.out.println("2000 (Bisiesto - Esperado: true): " + Funciones.esBisiesto(2000));
        System.out.println("1900 (NO Bisiesto - Esperado: false): " + Funciones.esBisiesto(1900));
        System.out.println("2023 (NO Bisiesto - Esperado: false): " + Funciones.esBisiesto(2023));

        // --------------------------------------------------
        System.out.println("\n---> TEST 2: traerFechaCorta(LocalDate fecha)");
        LocalDate fecha11 = LocalDate.of(2024, 5, 8);
        System.out.println("Fecha 2024-05-08 (Esperado: 8/5/2024 o 08/05/2024): " + Funciones.traerFechaCorta(fecha11));

        // --------------------------------------------------
        System.out.println("\n---> TEST 3: traerHoraCorta(LocalTime hora)");
        LocalTime hora1 = LocalTime.of(9, 5);
        LocalTime hora2 = LocalTime.of(15, 30);
        System.out.println("Hora 09:05 (Esperado: 09:05): " + Funciones.traerHoraCorta(hora1));
        System.out.println("Hora 15:30 (Esperado: 15:30): " + Funciones.traerHoraCorta(hora2));

        // --------------------------------------------------
        System.out.println("\n---> TEST 4: esDiaHabil(LocalDate fecha)");
        LocalDate lunes = LocalDate.of(2024, 5, 6); // Lunes
        LocalDate domingo = LocalDate.of(2024, 5, 5); // Domingo
        System.out.println("Día Lunes (Esperado: true): " + Funciones.esDiaHabil(lunes));
        System.out.println("Día Domingo (Esperado: false): " + Funciones.esDiaHabil(domingo));

        // --------------------------------------------------
        System.out.println("\n---> TEST 5: traerDiaDeLaSemana y traerMesEnLetras");
        LocalDate fechaGuia = LocalDate.of(2016, 8, 20); // El ejemplo exacto de la guía
        System.out.println("Día (Esperado: Sábado): " + Funciones.traerDiaDeLaSemana(fechaGuia));
        System.out.println("Mes (Esperado: Agosto): " + Funciones.traerMesEnLetras(fechaGuia));

        // --------------------------------------------------
        System.out.println("\n---> TEST 6: traerFechaLarga(LocalDate fecha)");
        System.out.println("Fecha Larga (Esperado: Sábado 20 de Agosto del 2016): " + Funciones.traerFechaLarga(fechaGuia));

        // --------------------------------------------------
        System.out.println("\n---> TEST 7: traerCantDiasDeUnMes(int anio, int mes)");
        System.out.println("Febrero 2024 - Bisiesto (Esperado: 29): " + Funciones.traerCantDiasDeUnMes(2024, 2));
        System.out.println("Febrero 2023 - No Bisiesto (Esperado: 28): " + Funciones.traerCantDiasDeUnMes(2023, 2));
        System.out.println("Noviembre 2024 (Esperado: 30): " + Funciones.traerCantDiasDeUnMes(2024, 11));

        // --------------------------------------------------
        System.out.println("\n---> TEST 8: aproximar2Decimal(double valor)");
        System.out.println("Valor 5.456 (Sube - Esperado: 5.46): " + Funciones.aproximar2Decimal(5.456));
        System.out.println("Valor 5.453 (Se mantiene - Esperado: 5.45): " + Funciones.aproximar2Decimal(5.453));

        // --------------------------------------------------
        System.out.println("\n---> TEST 9: Validación de Caracteres (esNumero / esLetra)");
        System.out.println("El caracter '5' es numero? (Esperado: true): " + Funciones.esNumero('5'));
        System.out.println("El caracter 'A' es numero? (Esperado: false): " + Funciones.esNumero('A'));
        System.out.println("El caracter 'Z' es letra? (Esperado: true): " + Funciones.esLetra('Z'));
        System.out.println("El caracter '3' es letra? (Esperado: false): " + Funciones.esLetra('3'));

        // --------------------------------------------------
        System.out.println("\n---> TEST 10: Validación de Cadenas");
        System.out.println("Cadena '123456' es numeros? (Esperado: true): " + Funciones.esCadenaNros("123456"));
        System.out.println("Cadena '123A56' es numeros? (Esperado: false): " + Funciones.esCadenaNros("123A56"));
        System.out.println("Cadena 'Hola Mundo' es letras? (Esperado: true): " + Funciones.esCandenaLetras("Hola Mundo"));
        System.out.println("Cadena 'Hola123' es letras? (Esperado: false): " + Funciones.esCandenaLetras("Hola123"));

        System.out.println("\n==================================================");
        System.out.println("             FIN DE LOS TEST");
        System.out.println("==================================================");
		
	}

}
