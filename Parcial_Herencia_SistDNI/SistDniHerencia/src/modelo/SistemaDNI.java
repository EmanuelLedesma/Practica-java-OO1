package modelo;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public class SistemaDNI {
	private float valorStandar;
	private float valorExtranjeros;
	private float masValorExpress;
	private List<Persona> lstPersona;
	private List<LugarDeTramite> lstLugarDeTramite;
	private List<ActualizacionDNI> lstActualizacionDNI;
	public SistemaDNI(float valorStandar, float valorExtranjeros, float masValorExpress) {
		super();
		this.valorStandar = valorStandar;
		this.valorExtranjeros = valorExtranjeros;
		this.masValorExpress = masValorExpress;
		lstPersona = new ArrayList<Persona>();
		lstLugarDeTramite = new ArrayList<LugarDeTramite>();
		lstActualizacionDNI = new ArrayList<ActualizacionDNI>();
	}
	public float getValorStandar() {
		return valorStandar;
	}
	public void setValorStandar(float valorStandar) {
		this.valorStandar = valorStandar;
	}
	public float getValorExtranjeros() {
		return valorExtranjeros;
	}
	public void setValorExtranjeros(float valorExtranjeros) {
		this.valorExtranjeros = valorExtranjeros;
	}
	public float getMasValorExpress() {
		return masValorExpress;
	}
	public void setMasValorExpress(float masValorExpress) {
		this.masValorExpress = masValorExpress;
	}
	public List<Persona> getLstPersona() {
		return lstPersona;
	}
	public void setLstPersona(List<Persona> lstPersona) {
		this.lstPersona = lstPersona;
	}
	public List<LugarDeTramite> getLstLugarDeTramite() {
		return lstLugarDeTramite;
	}
	public void setLstLugarDeTramite(List<LugarDeTramite> lstLugarDeTramite) {
		this.lstLugarDeTramite = lstLugarDeTramite;
	}
	public List<ActualizacionDNI> getLstActualizacionDNI() {
		return lstActualizacionDNI;
	}
	public void setLstActualizacionDNI(List<ActualizacionDNI> lstActualizacionDNI) {
		this.lstActualizacionDNI = lstActualizacionDNI;
	}
	@Override
	public String toString() {
		return "SistemaDNI [valorStandar=" + valorStandar + ", valorExtranjeros=" + valorExtranjeros
				+ ", masValorExpress=" + masValorExpress + ", lstPersona=" + lstPersona + ", lstLugarDeTramite="
				+ lstLugarDeTramite + ", lstActualizacionDNI=" + lstActualizacionDNI + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(lstActualizacionDNI, lstLugarDeTramite, lstPersona, Float.valueOf(masValorExpress),
				Float.valueOf(valorExtranjeros), Float.valueOf(valorStandar));
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SistemaDNI other = (SistemaDNI) obj;
		return Objects.equals(lstActualizacionDNI, other.lstActualizacionDNI)
				&& Objects.equals(lstLugarDeTramite, other.lstLugarDeTramite)
				&& Objects.equals(lstPersona, other.lstPersona)
				&& Float.floatToIntBits(masValorExpress) == Float.floatToIntBits(other.masValorExpress)
				&& Float.floatToIntBits(valorExtranjeros) == Float.floatToIntBits(other.valorExtranjeros)
				&& Float.floatToIntBits(valorStandar) == Float.floatToIntBits(other.valorStandar);
	}
	
	
	
}
