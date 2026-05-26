package modelo;

import java.time.LocalDate;
import java.util.Objects;

public  abstract class Vehiculo {
	protected  int idVehiculo;
	protected String marca;
	protected String modelo;
	protected int anio;
	protected int cantRuedas;
	protected double eficienciaMotor;
	
	

	public Vehiculo(int idVehiculo, String marca, String modelo, int anio, int cantRuedas, double eficienciaMotor) {
		super();
		this.idVehiculo = idVehiculo;
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.cantRuedas = cantRuedas;
		setEficienciaMotor(eficienciaMotor);
	}
	public int getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public int getCantRuedas() {
		return cantRuedas;
	}
	public void setCantRuedas(int cantRuedas) {
		this.cantRuedas = cantRuedas;
	}
	public double getEficienciaMotor() {
		return eficienciaMotor;
	}
	public void setEficienciaMotor(double eficienciaMotor) {
		if(eficienciaMotor<0.1 || eficienciaMotor>0.9) {
			throw new IllegalArgumentException("Error: la eficiencia de motor invalidad");
		}
		this.eficienciaMotor = eficienciaMotor;
	}
	@Override
	public String toString() {
		return "Vehiculo [idVehiculo=" + idVehiculo + ", marca=" + marca + ", modelo=" + modelo + ", anio=" + anio
				+ ", cantRuedas=" + cantRuedas + ", eficienciaMotor=" + eficienciaMotor + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(anio), Integer.valueOf(cantRuedas), Double.valueOf(eficienciaMotor),
				Integer.valueOf(idVehiculo), marca, modelo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return anio == other.anio && cantRuedas == other.cantRuedas
				&& Double.doubleToLongBits(eficienciaMotor) == Double.doubleToLongBits(other.eficienciaMotor)
				&& idVehiculo == other.idVehiculo && Objects.equals(marca, other.marca)
				&& Objects.equals(modelo, other.modelo);
	}
	
	public int aniosAntiguedad() {
		return LocalDate.now().getYear() - anio;
	}
	
	public abstract double calcularConsumo(int km);
	
}
