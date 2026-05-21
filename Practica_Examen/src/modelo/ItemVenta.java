package modelo;

import java.util.Objects;

public class ItemVenta {
	private int idItem;
	private Producto producto;
	private int cantidad;
	
	public ItemVenta(int idItem, Producto producto, int cantidad) {
		super();
		this.idItem = idItem;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "ItemVenta [idItem=" + idItem + ", producto=" + producto + ", cantidad=" + cantidad + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(cantidad), Integer.valueOf(idItem), producto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemVenta other = (ItemVenta) obj;
		return cantidad == other.cantidad && idItem == other.idItem && Objects.equals(producto, other.producto);
	}
	
	
	
}
