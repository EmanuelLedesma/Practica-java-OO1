package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Venta {
	private int idVenta;
	private LocalDate fecha;
	private Cliente cliente;
	private List<ItemVenta> lstItems;
	
	
	
	public Venta(int idVenta, LocalDate fecha, Cliente cliente) {
		super();
		this.idVenta = idVenta;
		this.fecha = fecha;
		this.cliente = cliente;
		this.lstItems = new ArrayList<ItemVenta>();
	}
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ItemVenta> getLstItems() {
		return lstItems;
	}
	public void setLstItems(List<ItemVenta> lstItems) {
		this.lstItems = lstItems;
	}
	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", fecha=" + fecha + ", cliente=" + cliente + ", lstItems=" + lstItems
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(cliente, fecha, Integer.valueOf(idVenta), lstItems);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venta other = (Venta) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fecha, other.fecha) && idVenta == other.idVenta
				&& Objects.equals(lstItems, other.lstItems);
	}
	
	public int calcularIdItemVenta(){
		int id = 1;
		if(!lstItems.isEmpty()) {
			id = lstItems.get(lstItems.size()-1).getIdItem() +1;
		}
		return id;
	}
}
