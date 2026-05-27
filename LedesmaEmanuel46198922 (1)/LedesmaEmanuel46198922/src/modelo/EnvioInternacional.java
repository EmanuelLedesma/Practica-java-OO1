package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class EnvioInternacional extends Envio {
	private String paisDestino;
	private double distancia;
	public EnvioInternacional(int id, String codigoTracking, Cliente remitente, Cliente destinatario,
			LocalDate fechaIngreso, String estado, boolean esExpress, double peso,
			String paisDestino, double distancia) {
		super(id, codigoTracking, remitente, destinatario, fechaIngreso, estado, esExpress, peso);
		this.paisDestino = paisDestino;
		this.distancia = distancia;
	}
	public String getPaisDestino() {
		return paisDestino;
	}
	public void setPaisDestino(String paisDestino) {
		this.paisDestino = paisDestino;
	}
	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(distancia, paisDestino);
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
		EnvioInternacional other = (EnvioInternacional) obj;
		return Objects.equals(distancia, other.distancia) && Objects.equals(paisDestino, other.paisDestino);
	}
	@Override
	public String toString() {
		return "EnvioInternacional {" +
				"paisDestino='" + paisDestino + '\'' +
				", distancia=" + distancia +
				", id=" + id +
				", codigoTracking='" + codigoTracking + '\'' +
				", remitente=" + remitente +
				", destinatario=" + destinatario +
				", fechaIngreso=" + fechaIngreso +
				", estado=" + estado +
				", esExpress=" + esExpress +
				", peso=" + peso +
				", costoFinal=" + costoFinal +
				'}';
	}
	@Override
	public double calcularCostoFinal(double tarifa, double adicional, double recargoExpress) {
		double costoFinal = tarifa + (distancia * adicional);
		if(esExpress) {
			costoFinal += recargoExpress;
		}
		return costoFinal;
	}
	
	
	
	
}
