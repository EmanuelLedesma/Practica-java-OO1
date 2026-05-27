package modelo;

import java.time.LocalDate;

public class CiudadanoNacional extends Persona {
	private String provinciaOrigen;

	public CiudadanoNacional(int id, long dni, String nombre, String apellido, LocalDate fechaDeNacimiento,
			String provinciaOrigen) {
		super(id, dni, nombre, apellido, fechaDeNacimiento);
		this.provinciaOrigen = provinciaOrigen;
	}

	public String getProvinciaOrigen() {
		return provinciaOrigen;
	}

	public void setProvinciaOrigen(String provinciaOrigen) {
		this.provinciaOrigen = provinciaOrigen;
	}

	@Override
	public String toString() {
		return "CiudadanoNacional [provinciaOrigen=" + provinciaOrigen + ", id=" + id + ", dni=" + dni + ", nombre="
				+ nombre + ", Apellido=" + Apellido + ", fechaDeNacimiento=" + fechaDeNacimiento
				+ ", getProvinciaOrigen()=" + getProvinciaOrigen() + ", getId()=" + getId() + ", getDni()=" + getDni()
				+ ", getNombre()=" + getNombre() + ", getApellido()=" + getApellido() + ", getFechaDeNacimiento()="
				+ getFechaDeNacimiento() + ", toString()=" + super.toString() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + "]";
	}
	
	
	
}
