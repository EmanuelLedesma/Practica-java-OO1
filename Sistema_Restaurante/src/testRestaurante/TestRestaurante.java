package testRestaurante;

import java.time.LocalDate;
import java.util.List;

import modelo.*;

public class TestRestaurante {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SistemaRestaurante clubDeLaMilanesa = new SistemaRestaurante();
		LocalDate fecha1 = LocalDate.of(2023, 8, 10);
		LocalDate fecha2 = LocalDate.of(2023, 8, 20);
		try {
			System.out.println("----------SETUP-----------");
			clubDeLaMilanesa.agregarCliente("Juan", "Perez", 38958345, "+541146592131");
			clubDeLaMilanesa.agregarCliente("Mario", "Lopez", 32964234, "+541163927564");
			clubDeLaMilanesa.agregarCliente("Delia", "Gonzalez", 33095256, "+541109624724");
			Cliente juan = clubDeLaMilanesa.getLstCliente().get(0);
			Cliente mario = clubDeLaMilanesa.getLstCliente().get(1);
			Cliente delia = clubDeLaMilanesa.getLstCliente().get(2);
			System.out.println("Clientes cargados con exito:");
			for(Cliente c:clubDeLaMilanesa.getLstCliente()) {
				System.out.println(c);
			}
			System.out.println("\n");
			clubDeLaMilanesa.agregarMesa(1, 4);
			clubDeLaMilanesa.agregarMesa(2, 4);
			clubDeLaMilanesa.agregarMesa(3, 2);
			clubDeLaMilanesa.agregarMesa(4, 4);
			clubDeLaMilanesa.agregarMesa(5, 6);
			clubDeLaMilanesa.agregarMesa(6, 4);
			

			
			
			System.out.println("Mesas cargadas con exito:");
			for(Mesa m:clubDeLaMilanesa.getLstMesas()) {
				System.out.println(m);
			}
			Mesa mesa1 = clubDeLaMilanesa.getLstMesas().get(0);
			Mesa mesa2 = clubDeLaMilanesa.getLstMesas().get(1);
			Mesa mesa3 = clubDeLaMilanesa.getLstMesas().get(2);
			Mesa mesa4 = clubDeLaMilanesa.getLstMesas().get(3);
			Mesa mesa5 = clubDeLaMilanesa.getLstMesas().get(4);
			Mesa mesa6 = clubDeLaMilanesa.getLstMesas().get(5);
			System.out.println("\n");
			clubDeLaMilanesa.agregarReserva(juan, fecha1,mesa3,2);
			clubDeLaMilanesa.agregarReserva(mario, fecha1,mesa2,4);
			clubDeLaMilanesa.agregarReserva(delia, fecha2,mesa2,4);
			System.out.println("Reservas agregadas con éxito:");
			
			for(Reserva r:clubDeLaMilanesa.getLstReservas()) {
				System.out.println(r);
			}
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("\n");
		//-----------------------------------------
		LocalDate fechaInicio = LocalDate.of(2023, 8, 10);
		LocalDate fechaFin = LocalDate.of(2023, 8, 15);
		
		try{
			System.out.println("Test 1: traerReservasPorFechas----- ");
			List<Reserva> reservasFiltradas = clubDeLaMilanesa.traerReservasPorFechas(fechaInicio, fechaFin);
			
			for(Reserva m: reservasFiltradas) {
				System.out.println(m);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n");
		
		try{
			System.out.println("Test 2: traerMesasLibres----- ");
			List<Mesa> mesasFiltradas = clubDeLaMilanesa.traerMesasLibres(fecha1);
			
			for(Mesa m: mesasFiltradas) {
				System.out.println(m);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n");
		System.out.println("Test 3 Errores------------");
		//-----------------------------------------
		try {
			clubDeLaMilanesa.agregarMesa(2, 4);
			System.out.println("éxito:");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			Cliente delia = clubDeLaMilanesa.getLstCliente().get(2);
			Mesa mesa3 = clubDeLaMilanesa.getLstMesas().get(2);
			clubDeLaMilanesa.agregarReserva(delia,fecha1,mesa3,2);
			System.out.println("éxito:");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			Cliente mario = clubDeLaMilanesa.getLstCliente().get(1);
			Mesa mesa4 = clubDeLaMilanesa.getLstMesas().get(3);
			clubDeLaMilanesa.agregarReserva(mario,fecha2,mesa4,6);
			System.out.println("éxito:");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
	}

}
