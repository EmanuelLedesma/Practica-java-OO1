package modelo;

import java.time.LocalDate;

public abstract class Persona {
	protected String nombre;
	protected String apellido;
	protected long dni;
	protected LocalDate fechaNacimiento;
	
	public Persona(String nombre, String apellido, long dni, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	// Agregar Getters y Setters

	public int calcularEdad(){
		
		// Agregar el comportamiento
		
		return 0;
	}
	
	public abstract String hablar();

}
