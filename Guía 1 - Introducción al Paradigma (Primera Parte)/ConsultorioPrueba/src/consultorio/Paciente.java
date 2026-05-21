package consultorio;

import java.util.Objects;

public class Paciente {
	public Paciente(String nombre, String apellido, float estatura, float peso) {
		//super(); (hace referencia a que esta clase Paciente hereda de una clase que se llama objet )
		this.nombre = nombre;
		this.apellido = apellido;
		this.estatura = estatura;
		this.peso = peso;
	}
	private String nombre;
	private String apellido;
	private float estatura;
	private float peso;
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
	public float getEstatura() {
		return estatura;
	}
	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	public String traerNombreCompleto() {
		return nombre + " " + apellido;
	}
	@Override
	public int hashCode() {
		return Objects.hash(apellido, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		Paciente other = (Paciente) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(nombre, other.nombre);
	}
	
}
