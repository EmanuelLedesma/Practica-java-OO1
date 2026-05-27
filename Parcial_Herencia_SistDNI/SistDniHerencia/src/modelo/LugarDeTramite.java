package modelo;

import java.util.Objects;

public class LugarDeTramite {
	private int id;
	private String lugarDeTramite;
	public LugarDeTramite(int id, String lugarDeTramite) {
		super();
		this.id = id;
		this.lugarDeTramite = lugarDeTramite;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLugarDeTramite() {
		return lugarDeTramite;
	}
	public void setLugarDeTramite(String lugarDeTramite) {
		this.lugarDeTramite = lugarDeTramite;
	}
	@Override
	public String toString() {
		return "LugarDeTramite [id=" + id + ", lugarDeTramite=" + lugarDeTramite + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(id), lugarDeTramite);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LugarDeTramite other = (LugarDeTramite) obj;
		return id == other.id && Objects.equals(lugarDeTramite, other.lugarDeTramite);
	}
	
	
	
}
