package modelo;

import java.time.LocalDate;

public class Reserva {
	private int idReserva;
	private Cliente cliente;
	private LocalDate fecha;
	private Mesa mesa;
	private int cantComensales;
	

	public Reserva(int idReserva, Cliente cliente, LocalDate fecha, Mesa mesa, int cantComensales) {
		super();
		this.idReserva = idReserva;
		this.cliente = cliente;
		this.fecha = fecha;
		this.mesa = mesa;
		setCantComensales(cantComensales);
	}
	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", cliente=" + cliente + ", fecha=" + fecha + ", mesa=" + mesa
				+ ", cantComensansales=" + cantComensales + "]";
	}
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	public int getCantComensansales() {
		return cantComensales;
	}
	
	public void setCantComensales(int cantComensales) {
		if(!validarComensales(cantComensales)){
			throw new IllegalArgumentException("Error: cantidad de comensales mayor a la capacidad de mesa");
		}
		this.cantComensales = cantComensales;
	}

	
	public boolean validarComensales(int cantComensales) {
		return cantComensales<=mesa.getCapacidad();
	}
	
	
}
