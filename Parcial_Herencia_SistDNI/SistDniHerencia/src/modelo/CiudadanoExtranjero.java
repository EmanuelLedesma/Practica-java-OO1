package modelo;

import java.time.LocalDate;

public class CiudadanoExtranjero extends Persona {
	private String nacionalidad;

	public CiudadanoExtranjero(int id, long dni, String nombre, String apellido, LocalDate fechaDeNacimiento,
			String nacionalidad) {
		super(id, dni, nombre, apellido, fechaDeNacimiento);
		this.nacionalidad = nacionalidad;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Override
	public String toString() {
		return "CiudadanoExtranjero [nacionalidad=" + nacionalidad + ", id=" + id + ", dni=" + dni + ", nombre="
				+ nombre + ", Apellido=" + Apellido + ", fechaDeNacimiento=" + fechaDeNacimiento + "]";
	}
	
	
	
	
}
