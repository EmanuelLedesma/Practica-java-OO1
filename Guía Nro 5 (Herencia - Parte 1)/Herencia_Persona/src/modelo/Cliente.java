package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Cliente extends Persona {
	private String cuit;
	private float limiteCredito;
	public Cliente(String nombre, String apellido, int dni, LocalDate fechaDeNacimieto, String cuit,
			float limiteCredito) {
		super(nombre, apellido, dni, fechaDeNacimieto);
		this.cuit = cuit;
		this.limiteCredito = limiteCredito;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public float getLimiteCredito() {
		return limiteCredito;
	}
	public void setLimiteCredito(float limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	@Override
	public String toString() {
		return "Cliente [cuit=" + cuit + ", limiteCredito=" + limiteCredito + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cuit, limiteCredito);
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
		Cliente other = (Cliente) obj;
		return Objects.equals(cuit, other.cuit)
				&& Float.floatToIntBits(limiteCredito) == Float.floatToIntBits(other.limiteCredito);
	}
	
	@Override
	public String hablar() {
		return "Soy un Cliente";
	}
	
	public String estadoCredito() {
	    return "El límite de crédito disponible es: " + limiteCredito;
	}

	

}
