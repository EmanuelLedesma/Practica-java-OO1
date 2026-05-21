package modelo;

import java.util.Objects;

public class Cliente {
	private int idCliente;
	private String nombre;
	private long dni;
	
	public Cliente(int idCliente, String nombre, long dni) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.dni = dni;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", dni=" + dni + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Long.valueOf(dni), Integer.valueOf(idCliente), nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return dni == other.dni && idCliente == other.idCliente && Objects.equals(nombre, other.nombre);
	}
	
	
	
}
