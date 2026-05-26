package modelo;

import java.util.Objects;

public class Auto extends Vehiculo {
	private int cantPuertas;

	public Auto(int idVehiculo, String marca, String modelo, int anio, int cantRuedas, double eficienciaMotor,
			int cantPuertas) {
		super(idVehiculo, marca, modelo, anio, cantRuedas, eficienciaMotor);
		this.cantPuertas = cantPuertas;
	}

	public int getCantPuertas() {
		return cantPuertas;
	}

	public void setCantPuertas(int cantPuertas) {
		this.cantPuertas = cantPuertas;
	}

	@Override
	public String toString() {
		return "Auto"+ super.toString() + " [cantPuertas=" + cantPuertas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cantPuertas);
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
		Auto other = (Auto) obj;
		return cantPuertas == other.cantPuertas;
	}

	@Override
	public double calcularConsumo(int km) {
		return km * eficienciaMotor;
	}
	
	
	
}
