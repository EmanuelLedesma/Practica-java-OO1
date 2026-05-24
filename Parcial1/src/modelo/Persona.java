package modelo;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Persona {
	private int id;
	private long dni;
	private String apellido;
	private String nombre;
	private LocalDate fechaDeNacimiento;
	private boolean esArgentino;
	
	
	
	public Persona(int id, long dni, String apellido, String nombre, LocalDate fechaDeNacimiento, boolean esArgentino) throws Exception {
		super();
		this.id = id;
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		this.setFechaNacimiento(fechaDeNacimiento);
		this.esArgentino = esArgentino;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaNacimiento(LocalDate fecha) {
	if(!validarFechaNacimiento(fecha)) {
		throw new IllegalArgumentException("Error: " +Funciones.traerFechaCorta(fecha) +" la fecha es invalida");
	}
		this.fechaDeNacimiento = fecha;
	}
	
	public boolean validarFechaNacimiento(LocalDate fecha){
		LocalDate hoy = LocalDate.now();
		return !fecha.isAfter(hoy);
	}
	
	public int calcularEdad(LocalDate fecha) {
        return Period.between(fechaDeNacimiento, fecha).getYears();
    }
																					
	public boolean isEsArgentino() {
		return esArgentino;
	}
	public void setEsArgentino(boolean esArgentino) {
		this.esArgentino = esArgentino;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ", fecha="
				+ fechaDeNacimiento + ", esArgentino=" + esArgentino + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(apellido, Long.valueOf(dni), Boolean.valueOf(esArgentino), fechaDeNacimiento, Integer.valueOf(id),
				nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellido, other.apellido) && dni == other.dni && esArgentino == other.esArgentino
				&& Objects.equals(fechaDeNacimiento, other.fechaDeNacimiento) && id == other.id && Objects.equals(nombre, other.nombre);
	}
	
}
