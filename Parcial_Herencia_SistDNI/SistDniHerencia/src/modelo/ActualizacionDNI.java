package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class ActualizacionDNI {
	private int id;
	private LugarDeTramite lugarDetramite;
	private LocalDate fecha;
	private float costoActualizacion;
	private boolean esExpress;
	public ActualizacionDNI(int id, LugarDeTramite lugarDetramite, LocalDate fecha, float costoActualizacion,
			boolean esExpress) {
		super();
		this.id = id;
		this.lugarDetramite = lugarDetramite;
		this.fecha = fecha;
		this.costoActualizacion = costoActualizacion;
		this.esExpress = esExpress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LugarDeTramite getLugarDetramite() {
		return lugarDetramite;
	}
	public void setLugarDetramite(LugarDeTramite lugarDetramite) {
		this.lugarDetramite = lugarDetramite;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public float getCostoActualizacion() {
		return costoActualizacion;
	}
	public void setCostoActualizacion(float costoActualizacion) {
		this.costoActualizacion = costoActualizacion;
	}
	public boolean isEsExpress() {
		return esExpress;
	}
	public void setEsExpress(boolean esExpress) {
		this.esExpress = esExpress;
	}
	@Override
	public String toString() {
		return "ActualizacionDNI [id=" + id + ", lugarDetramite=" + lugarDetramite + ", fecha=" + fecha
				+ ", costoActualizacion=" + costoActualizacion + ", esExpress=" + esExpress + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Float.valueOf(costoActualizacion), Boolean.valueOf(esExpress), fecha, Integer.valueOf(id),
				lugarDetramite);
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
				&& esExpress == other.esExpress && Objects.equals(fecha, other.fecha) && id == other.id
				&& Objects.equals(lugarDetramite, other.lugarDetramite);
	}
	
	
}
