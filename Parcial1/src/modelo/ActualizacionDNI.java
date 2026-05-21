package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class ActualizacionDNI {
	private int id;
	private LugarDeTramite lugarDeTramite;
	private LocalDate fecha;
	private Persona persona;
	private float costoActualizacion;
	private boolean esExpres;
	
	
	
	public ActualizacionDNI(int id, LugarDeTramite lugarDeTramite, LocalDate fecha, Persona persona, float costoDeActualizacion ,boolean esExpres) {
		super();
		this.id = id;
		this.lugarDeTramite = lugarDeTramite;
		this.fecha = fecha;
		this.persona = persona;
		this.costoActualizacion = costoDeActualizacion;
		this.esExpres = esExpres;
	}

	


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public LugarDeTramite getLugarDeTramite() {
		return lugarDeTramite;
	}



	public void setLugarDeTramite(LugarDeTramite lugarDeTramite) {
		this.lugarDeTramite = lugarDeTramite;
	}



	public LocalDate getFecha() {
		return fecha;
	}



	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}



	public Persona getPersona() {
		return persona;
	}



	public void setPersona(Persona persona) {
		this.persona = persona;
	}



	public float getCostoActualizacion() {
		return costoActualizacion;
	}






	public boolean isEsExpres() {
		return esExpres;
	}



	public void setEsExpres(boolean esExpres) {
		this.esExpres = esExpres;
	}
	
	



	@Override
	public int hashCode() {
		return Objects.hash(Float.valueOf(costoActualizacion), Boolean.valueOf(esExpres), fecha, Integer.valueOf(id),
				lugarDeTramite, persona);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActualizacionDNI other = (ActualizacionDNI) obj;
		return Float.floatToIntBits(costoActualizacion) == Float.floatToIntBits(other.costoActualizacion)
				&& esExpres == other.esExpres && Objects.equals(fecha, other.fecha) && id == other.id
				&& Objects.equals(lugarDeTramite, other.lugarDeTramite) && Objects.equals(persona, other.persona);
	}



	@Override
	public String toString() {
		return "ActualizacionDNI [id=" + id + ", lugarDeTramite=" + lugarDeTramite + ", fecha=" + fecha + ", persona="
				+ persona + ", costoActualizacion=" + costoActualizacion + ", esExpres=" + esExpres + "]";
	}
	
	
	
}
