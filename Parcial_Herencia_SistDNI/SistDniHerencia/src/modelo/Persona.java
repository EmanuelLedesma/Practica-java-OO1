package modelo;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public abstract class Persona {
	protected int id;
	protected long dni;
	protected String nombre;
	protected String Apellido;
	protected LocalDate fechaDeNacimiento;
	public Persona(int id, long dni, String nombre, String apellido, LocalDate fechaDeNacimiento) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		Apellido = apellido;
		setFechaDeNacimiento(fechaDeNacimiento);
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(LocalDate fecha) {
		if(fecha.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("Error: " + fecha + " invalida");
		}
		this.fechaDeNacimiento = fecha;
	}
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", Apellido=" + Apellido
				+ ", fechaDeNacimiento=" + fechaDeNacimiento + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Apellido, Long.valueOf(dni), fechaDeNacimiento, Integer.valueOf(id), nombre);
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
		return Objects.equals(Apellido, other.Apellido) && dni == other.dni
				&& Objects.equals(fechaDeNacimiento, other.fechaDeNacimiento) && id == other.id
				&& Objects.equals(nombre, other.nombre);
	}
	
	public int calcularEdad(LocalDate fecha) {
		return Period.between(fechaDeNacimiento, fecha).getYears();
	}
	
	public abstract float calcularCostoBase(LocalDate fechaTramite, boolean esExpres);
	
}
