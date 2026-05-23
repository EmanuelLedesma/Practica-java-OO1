package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class MovimientoIventario {
	private int idMovimientoInventario;
	private Producto producto;
	private LocalDate fecha;
	private int cantidad;
	
	
	
	public MovimientoIventario(int idMovimientoInventario, Producto producto, LocalDate fecha, int cantidad) {
		super();
		this.idMovimientoInventario = idMovimientoInventario;
		this.producto = producto;
		this.fecha = fecha;
		this.cantidad = cantidad;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(cantidad), fecha, Integer.valueOf(idMovimientoInventario), producto);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovimientoIventario other = (MovimientoIventario) obj;
		return cantidad == other.cantidad && Objects.equals(fecha, other.fecha)
				&& idMovimientoInventario == other.idMovimientoInventario && Objects.equals(producto, other.producto);
	}
	public int getIdMovimientoInventario() {
		return idMovimientoInventario;
	}
	public void setIdMovimientoInventario(int idMovimientoInventario) {
		this.idMovimientoInventario = idMovimientoInventario;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
