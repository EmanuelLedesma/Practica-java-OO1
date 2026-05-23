package modelo;

import java.util.Objects;

public abstract class Producto {
	protected int idProducto;
	protected int codigo;
	protected String nombre;
	protected float precio;
	protected Categoria categoria;
	protected int cantidadDisponible;
	public int getIdProducto() {
		return idProducto;
	}
	
	public Producto(int idProducto, int codigo, String nombre, float precio, Categoria categoria,
			int cantidadDisponible) {
		super();
		this.idProducto = idProducto;
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
		this.cantidadDisponible = cantidadDisponible;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(cantidadDisponible), categoria, Integer.valueOf(codigo),
				Integer.valueOf(idProducto), nombre, Float.valueOf(precio));
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return cantidadDisponible == other.cantidadDisponible && Objects.equals(categoria, other.categoria)
				&& codigo == other.codigo && idProducto == other.idProducto && Objects.equals(nombre, other.nombre)
				&& Float.floatToIntBits(precio) == Float.floatToIntBits(other.precio);
	}



	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getCantidadDisponible() {
		return cantidadDisponible;
	}
	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}
	
	
}
