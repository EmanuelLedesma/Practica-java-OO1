package modelo;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public abstract class Persona {
	protected String nombre;
	protected String apellido;
	protected int dni;
	protected LocalDate fechaDeNacimieto;
	public Persona(String nombre, String apellido, int dni, LocalDate fechaDeNacimieto) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaDeNacimieto = fechaDeNacimieto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public LocalDate getFechaDeNacimieto() {
		return fechaDeNacimieto;
	}
	public void setFechaDeNacimieto(LocalDate fechaDeNacimieto) {
		this.fechaDeNacimieto = fechaDeNacimieto;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", fechaDeNacimieto="
				+ fechaDeNacimieto + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(apellido, Integer.valueOf(dni), fechaDeNacimieto, nombre);
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
		return Objects.equals(apellido, other.apellido) && dni == other.dni
				&& Objects.equals(fechaDeNacimieto, other.fechaDeNacimieto) && Objects.equals(nombre, other.nombre);
	}
	
	public int calcularEdad(LocalDate fecha) {
		int edad = Period.between(fechaDeNacimieto,fecha).getYears();
		return edad;
	}
	
	public abstract String hablar();
	
}
