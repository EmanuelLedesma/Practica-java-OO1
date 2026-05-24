package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Empleado extends Persona {
	private long legajo;
	private float sueldoMensual;
	
	public Empleado(String nombre, String apellido, int dni, LocalDate fechaDeNacimieto, long legajo,
			float sueldoMensual) {
		super(nombre, apellido, dni, fechaDeNacimieto);
		this.legajo = legajo;
		this.sueldoMensual = sueldoMensual;
	}

	public long getLegajo() {
		return legajo;
	}

	public void setLegajo(long legajo) {
		this.legajo = legajo;
	}

	public float getSueldoMensual() {
		return sueldoMensual;
	}

	public void setSueldoMensual(float sueldoMensual) {
		this.sueldoMensual = sueldoMensual;
	}

	@Override
	public String toString() {
		return "Empleado [legajo=" + legajo + ", sueldoMensual=" + sueldoMensual + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(legajo, sueldoMensual);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return legajo == other.legajo
				&& Float.floatToIntBits(sueldoMensual) == Float.floatToIntBits(other.sueldoMensual);
	}

	@Override
	public String hablar() {
		return "Soy un empleado";
	}
	
	public float calcularSueldo(int diasAusente) {
		int jornadaLaboral=20;
		int diasLaboralesCompletados = jornadaLaboral - diasAusente;
		float sueldoPorDia = sueldoMensual/jornadaLaboral;
		return sueldoPorDia*diasLaboralesCompletados;
		
	}
	

}
