package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class EnvioNacional extends Envio {
	private String provincia;
	private String codigoPostal;
	
	public EnvioNacional(int id, String codigoTracking, Cliente remitente, Cliente destinatario, LocalDate fechaIngreso,
			String estado, boolean esExpress, double peso, String provincia, String codigoPostal) {
		super(id, codigoTracking, remitente, destinatario, fechaIngreso, estado, esExpress, peso);
		this.provincia = provincia;
		this.codigoPostal = codigoPostal;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(codigoPostal, provincia);
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
		EnvioNacional other = (EnvioNacional) obj;
		return Objects.equals(codigoPostal, other.codigoPostal) && Objects.equals(provincia, other.provincia);
	}

	@Override
	public String toString() {
		return "EnvioNacional [provincia=" + provincia + ", codigoPostal=" + codigoPostal
				+ ", id=" + id + ", codigoTracking=" + codigoTracking
				+ ", remitente=" + remitente + ", destinatario=" + destinatario
				+ ", estado=" + estado + ", esExpress=" + esExpress
				+ ", peso=" + peso + ", costoFinal=" + costoFinal + "]";
	}

	@Override
	public double calcularCostoFinal(double tarifa, double adicional, double recargoExpress) {
		double costoFinal = tarifa + (peso * adicional);

		if(esExpress) {
			costoFinal += recargoExpress;
		}

		return costoFinal;
	}
	
	
	
}
