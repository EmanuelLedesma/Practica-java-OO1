package modelo;

import java.util.Objects;

public class Moto extends Vehiculo{
	private boolean incluyeCaja;
	private boolean diseñoAereodinamico;
	
	public Moto(int idVehiculo, String marca, String modelo, int anio, int cantRuedas, double eficienciaMotor,
			boolean incluyeCaja, boolean diseñoAereodinamico) {
		super(idVehiculo, marca, modelo, anio, cantRuedas, eficienciaMotor);
		this.incluyeCaja = incluyeCaja;
		this.diseñoAereodinamico = diseñoAereodinamico;
	}

	public boolean isIncluyeCaja() {
		return incluyeCaja;
	}

	public void setIncluyeCaja(boolean incluyeCaja) {
		this.incluyeCaja = incluyeCaja;
	}

	public boolean isDiseñoAereodinamico() {
		return diseñoAereodinamico;
	}

	public void setDiseñoAereodinamico(boolean diseñoAereodinamico) {
		this.diseñoAereodinamico = diseñoAereodinamico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(diseñoAereodinamico, incluyeCaja);
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
		Moto other = (Moto) obj;
		return diseñoAereodinamico == other.diseñoAereodinamico && incluyeCaja == other.incluyeCaja;
	}

	@Override
	public String toString() {
		return "Moto " + super.toString() + "[incluyeCaja=" + incluyeCaja + ", diseñoAereodinamico=" + diseñoAereodinamico + "]";
	}

	@Override
	public double calcularConsumo(int km) {
		double eficienciaMotor = this.eficienciaMotor;
		if(incluyeCaja) {
			eficienciaMotor +=0.03; 
		}
		if(diseñoAereodinamico) {
			eficienciaMotor-= 0.05; 
		}
		
		
		double consumoTotal = km*eficienciaMotor;
		return Math.round(consumoTotal*10.0)/10.0;
	}
	
	
	
}
