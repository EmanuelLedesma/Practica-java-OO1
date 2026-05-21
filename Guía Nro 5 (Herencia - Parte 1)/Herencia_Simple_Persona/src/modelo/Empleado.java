package modelo;

import java.time.LocalDate;

public abstract class Empleado extends Persona{
	
	private long legajo;
	private float sueldoMensual;
	
	public Empleado(String nombre, String apellido, long dni, LocalDate fechaNacimiento, long legajo,
			float sueldoMensual){
		super(nombre, apellido, dni, fechaNacimiento);
		this.legajo=legajo;
		this.sueldoMensual=sueldoMensual;
	}
	
	// Agregar Getters y Setters

	public float calcularSueldo(int diasAusente){
		
		// Agregar el comportamiento
			
		return 0;
		
	}
	
	public String hablar(){
		return "Soy un Empleado";
	}


}