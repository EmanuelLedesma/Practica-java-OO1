package test;
import java.time.LocalDate;
import java.util.List;

import modelo.*;

public class TestTema2 {

	public static void main(String[] args) {
		
		System.out.println("1------Agregar e imprimir clase sistema");
		SistemaEnvio s = new SistemaEnvio(10000.0,40000.0,90.0,40.0,5000.0);
		System.out.println(s);
		
		System.out.println("\n");
		
		System.out.println("2------Agregar e imprimir clientes ");
		s.agregarCliente("Rossi", "Juan Carlos", "jcrossi@gmail.com");
		s.agregarCliente("Fernandez", "Maria", "mariafernandez@gmail.com");
		s.agregarCliente("Gomez", "Santiago", "santiagogomez10@gmail.com");
		s.agregarCliente("Benitez", "Ana Laura", "anabenitez92@gmail.com");
		s.agregarCliente("Ledesma", "Emanuel Ezequiel", "emanuelezequielledesma@gmail.com");
		
		Cliente juan = s.traerCliente("jcrossi@gmail.com");
		Cliente maria = s.traerCliente("mariafernandez@gmail.com");
		Cliente santiago= s.traerCliente("santiagogomez10@gmail.com");
		Cliente ana = s.traerCliente("anabenitez92@gmail.com");
		Cliente ema = s.traerCliente("emanuelezequielledesma@gmail.com");
		
		System.out.println(s.getLstCliente());
		
		System.out.println("\n");
		
		System.out.println("3---------traer e imprimir tu cliente por email");
		System.out.println(s.traerCliente("emanuelezequielledesma@gmail.com"));
		
		System.out.println("\n");
		
		System.out.println("4---------Agregar e imprimir los siguientes envios");
		s.agregarEnvioInternacional("CP473234829AR", juan, maria, LocalDate.of(2026, 5, 26), "Enviado", false, 4.0, "Uruguay", 230.0); 
		s.agregarEnvioInternacional("CP918273640AR", santiago, maria, LocalDate.of(2026, 5, 26), "Enviado", false, 3.0, "Uruguay", 300.0);
		s.agregarEnvioInternacional("EE837462515AR", maria, ana, LocalDate.of(2026, 5, 26), "Entregado", true, 1.0, "Brasil", 2350.0);
		s.agregarEnvio("CP554433224AR", santiago, juan, LocalDate.of(2026, 5, 26), "Enviado", false, 1.5, "Cordoba", "5000");
		s.agregarEnvio("EE102938478AR", juan, ema, LocalDate.of(2026, 5, 26), "Enviado", true, 2.0, "Buenos Aires", "1870");
		s.agregarEnvio("EE123456785R", ema, juan, LocalDate.of(2026, 5, 26), "Enviado", true, 2.5, "Cordoba", "5000");
		
		for(Envio o:s.getLstEnvio()) {
			System.out.println(o);
		}
		
		System.out.println("5)");
		List<Envio> listaFiltrada = s.traerEnvio(LocalDate.of(2026, 5, 26), "Uruguay");
		for(Envio o:listaFiltrada) {
			System.out.println(o);
		}
		
		System.out.println("6)");
		System.out.println("Recaudacion (Uruguay 2026-5-26): "+ s.calcularRecaudacion(LocalDate.of(2026, 5, 26), "Uruguay"));
		
		
	}

}
