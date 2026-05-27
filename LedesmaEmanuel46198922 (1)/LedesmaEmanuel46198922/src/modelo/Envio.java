package modelo;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Envio {
	protected int id;
	protected String codigoTracking;
	protected Cliente remitente;
	protected Cliente destinatario;
	protected LocalDate fechaIngreso;
	protected String estado;
	protected boolean esExpress;
	protected double peso;
	protected double costoFinal;
	public Envio(int id, String codigoTracking, Cliente remitente, Cliente destinatario, LocalDate fechaIngreso,
			String estado, boolean esExpress, double peso) {
		super();
		this.id = id;
		this.codigoTracking = codigoTracking;
		this.remitente = remitente;
		this.destinatario = destinatario;
		this.fechaIngreso = fechaIngreso;
		this.estado = estado;
		this.esExpress = esExpress;
		this.peso = peso;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigoTracking() {
		return codigoTracking;
	}
	public void setCodigoTracking(String codigoTracking) {
		this.codigoTracking = codigoTracking;
	}
	public Cliente getRemitente() {
		return remitente;
	}
	public void setRemitente(Cliente remitente) {
		this.remitente = remitente;
	}
	public Cliente getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Cliente destinatario) {
		this.destinatario = destinatario;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public boolean isEsExpress() {
		return esExpress;
	}
	public void setEsExpress(boolean esExpress) {
		this.esExpress = esExpress;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getCostoFinal() {
		return costoFinal;
	}
	public void setCostoFinal(double costoFinal) {
		this.costoFinal = costoFinal;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigoTracking, Double.valueOf(costoFinal), Boolean.valueOf(esExpress), estado,
				Integer.valueOf(id), Double.valueOf(peso));
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Envio other = (Envio) obj;
		return Objects.equals(codigoTracking, other.codigoTracking)
				&& Double.doubleToLongBits(costoFinal) == Double.doubleToLongBits(other.costoFinal)
				&& esExpress == other.esExpress && Objects.equals(estado, other.estado) && id == other.id
				&& Double.doubleToLongBits(peso) == Double.doubleToLongBits(other.peso);
	}
	@Override
	public String toString() {
		return "Envio [id=" + id + ", codigoTracking=" + codigoTracking + ", estado=" + estado + ", esExpress="
				+ esExpress + ", peso=" + peso + ", costoFinal=" + costoFinal + "]";
	}
	
	public abstract double calcularCostoFinal(double tarifa, double adicional, double recargoExpress);
	
}
