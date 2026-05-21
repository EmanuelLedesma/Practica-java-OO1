package modelo;
import java.time.LocalDate;
import java.time.LocalTime;
public class Funciones {
	
	public static boolean esDiaHabil(LocalDate fecha){	
		int d= fecha.getDayOfWeek().getValue();
		return ((d>=1) &&( d<=5));
		}	
	
	public static boolean esBisiesto(int anio) {
	    return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
	}
	
	public static boolean esFechaValida(int dia, int mes, int anio) {
        boolean esValida = false;
        if (anio > 0 && (mes >= 1 && mes <= 12)) {
            int diasDelMes = 0;
            switch (mes) {
                case 2:
                	//condición ? valor_si_verdadero : valor_si_falso;
                    diasDelMes = (esBisiesto(anio)) ? 29 : 28;
                    break;
                case 4: case 6: case 9: case 11:
                    diasDelMes = 30;
                    break;
                default:
                    diasDelMes = 31;
            }
            if (dia >= 1 && dia <= diasDelMes) {
                esValida = true;
            }
        }
        return esValida;
    }
	
	public static String traerFechaCorta(LocalDate fecha) {
        return fecha.getDayOfMonth() + "/" + fecha.getMonthValue() + "/" + fecha.getYear();
    }
	
	public static String traerHoraCorta(LocalTime hora) {
        // Usamos el operador ternario que vimos antes para agregar un "0" 
        // a la izquierda si la hora o el minuto es menor a 10 (ej: 09:05)
        String horas = (hora.getHour() < 10) ? "0" + hora.getHour() : String.valueOf(hora.getHour());
        String minutos = (hora.getMinute() < 10) ? "0" + hora.getMinute() : String.valueOf(hora.getMinute());
        
        return horas + ":" + minutos;
    }
	
	public static String traerDiaDeLaSemana(LocalDate fecha) {
        String nombreDia = "";
        int numeroDia = fecha.getDayOfWeek().getValue();
        
        switch (numeroDia) {
            case 1: nombreDia = "Lunes"; break;
            case 2: nombreDia = "Martes"; break;
            case 3: nombreDia = "Miércoles"; break;
            case 4: nombreDia = "Jueves"; break;
            case 5: nombreDia = "Viernes"; break;
            case 6: nombreDia = "Sábado"; break;
            case 7: nombreDia = "Domingo"; break;
        }
        
        return nombreDia;
    }
	
	public static String traerMesEnLetras(LocalDate fecha) {
        String nombreMes = "";
        int numeroMes = fecha.getMonthValue();
        
        switch (numeroMes) {
            case 1: nombreMes = "Enero"; break;
            case 2: nombreMes = "Febrero"; break;
            case 3: nombreMes = "Marzo"; break;
            case 4: nombreMes = "Abril"; break;
            case 5: nombreMes = "Mayo"; break;
            case 6: nombreMes = "Junio"; break;
            case 7: nombreMes = "Julio"; break;
            case 8: nombreMes = "Agosto"; break;
            case 9: nombreMes = "Septiembre"; break;
            case 10: nombreMes = "Octubre"; break;
            case 11: nombreMes = "Noviembre"; break;
            case 12: nombreMes = "Diciembre"; break;
        }
        
        return nombreMes;
	}
	
	// 1. Traer fecha larga reutilizando los métodos anteriores
    public static String traerFechaLarga(LocalDate fecha) {
        String diaSemana = traerDiaDeLaSemana(fecha);
        int dia = fecha.getDayOfMonth();
        String mes = traerMesEnLetras(fecha);
        int anio = fecha.getYear();
        
        return diaSemana + " " + dia + " de " + mes + " del " + anio;
    }

    // 2. Traer cantidad de días de un mes reutilizando esBisiesto
    public static int traerCantDiasDeUnMes(int anio, int mes) {
        int dias = 0;
        switch (mes) {
            case 2:
                dias = esBisiesto(anio) ? 29 : 28;
                break;
            case 4: case 6: case 9: case 11:
                dias = 30;
                break;
            default:
                dias = 31;
        }
        return dias;
    }

    // 3. Aproximar a 2 decimales
    public static double aproximar2Decimal(double valor) {
        // Multiplicamos por 100, redondeamos al entero más cercano y volvemos a dividir.
        // Math.round() automáticamente suma 1 si el siguiente decimal es >= 5.
        return Math.round(valor * 100.0) / 100.0;
    }

    // 4. Saber si un carácter es un número
    public static boolean esNumero(char c) {
        // Usamos el método isDigit de la clase envolvente Character
        return Character.isDigit(c);
    }

    // 5. Saber si un carácter es una letra
    public static boolean esLetra(char c) {
        // Usamos el método isLetter de la clase envolvente Character
        return Character.isLetter(c);
    }
	
    public static boolean esCadenaNros(String cadena) {
        boolean esValida = true;
        int i = 0;
        
        // Bucle while con doble condición de corte (como pide la Guía 3)
        while (i < cadena.length() && esValida) {
            if (!esNumero(cadena.charAt(i))) {
                esValida = false; // Corta el bucle si encuentra algo que no es número
            }
            i++;
        }
        
        return esValida;
    }
	
    public static boolean esCandenaLetras(String cadena) {
        boolean esValida = true;
        int i = 0;
        
        // Bucle while con doble condición de corte
        while (i < cadena.length() && esValida) {
            // Reutilizamos el método esLetra pero ojo: 
            // le agregamos soporte para los "espacios" por si evalúas nombres y apellidos
            char caracter = cadena.charAt(i);
            if (!esLetra(caracter) && caracter != ' ') {
                esValida = false;
            }
            i++;
        }
        
        return esValida;
    }
    
}
