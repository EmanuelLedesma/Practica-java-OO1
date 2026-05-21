package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sistema {
	private float valorStandar;
	private float valorExtranjeros;
	private float masValorExpres;
	private List<Persona> lstPersonas;
	private List<LugarDeTramite> lstLugarDeTramite;
	private List<ActualizacionDNI> lstActualizacionDNI;
	
	
	
	public Sistema(float valorStandar, float valorExtranjeros, float masValorExpres) {
		super();
		this.valorStandar = valorStandar;
		this.valorExtranjeros = valorExtranjeros;
		this.masValorExpres = masValorExpres;
		this.lstPersonas = new ArrayList<Persona>();
		this.lstLugarDeTramite = new ArrayList<LugarDeTramite>();
		this.lstActualizacionDNI = new ArrayList<ActualizacionDNI>();
	}
	
	public float calcularCostoDeActualizacion(Persona p, LocalDate fechaTramite, boolean esExpres) {
	    float costo = 0;
	    
	    // Calculamos la edad usando la fecha del trámite, no la fecha de hoy 
	    int edad = p.calcularEdad(fechaTramite);

	    // 1. Calculamos el costo base según nacionalidad
	    if (p.isEsArgentino()) {
	        // Si es argentino, evaluamos su edad
	        if (edad >= 18 && edad <= 75) {
	            costo = valorStandar;
	        } else {
	            // Si es menor de 18 o mayor de 75, es gratuito
	            costo = 0; 
	        }
	    } else {
	        // Si no es argentino, siempre paga el valor de extranjero
	        costo = valorExtranjeros;
	    }

	    // 2. Evaluamos el recargo exprés al final (se suma al costo que ya calculamos)
	    if (esExpres) {
	        costo = costo + masValorExpres;
	    }

	    return costo;
	}
	
	// maybe 
	
	public int calcularIdPersona() {
		int id = 1;
		if(!lstPersonas.isEmpty()) {
			id = lstPersonas.get(lstPersonas.size()-1).getId()+1;
		}
		return id;
	}
	public int calcularIdLugarDeTramite() {
		int id = 1;
		if(!lstLugarDeTramite.isEmpty()) {
			id = lstLugarDeTramite.get(lstLugarDeTramite.size()-1).getId()+1;
		}
		return id;
	}
	public int calcularIdActualizacionDNI() {
		int id = 1;
		if(!lstActualizacionDNI.isEmpty()) {
			id = lstActualizacionDNI.get(lstActualizacionDNI.size()-1).getId()+1;
		}
		return id;
	}
	
	
	public Persona traerPersona(long dni) {
		Persona encontrado = null;
		int i = 0;
		while(i < lstPersonas.size() && encontrado == null) {
			if(lstPersonas.get(i).getDni()==dni) {
				encontrado = lstPersonas.get(i);
			}
			i++;
		}
		return encontrado;
	}
	
	public LugarDeTramite traerLugarDeTramite(int id) {
		LugarDeTramite encontrado = null;
		int i = 0;
		while(i < lstLugarDeTramite.size() && encontrado == null) {
			if(lstLugarDeTramite.get(i).getId()==id) {
				encontrado = lstLugarDeTramite.get(i);
			}
			i++;
		}
		return encontrado;
	}
	
	public ActualizacionDNI traerActualizacionDNI(LocalDate fecha, LugarDeTramite lugar) {
		ActualizacionDNI encontrado = null;
		int i = 0;
		while(i < lstActualizacionDNI.size() && encontrado == null) {
			if(lstActualizacionDNI.get(i).getLugarDeTramite().getLugarDeTramite().equals(lugar.getLugarDeTramite()) && lstActualizacionDNI.get(i).getFecha().isEqual(fecha) ) {
				encontrado = lstActualizacionDNI.get(i);
			}
			i++;
		}
		return encontrado;
	}
	
	public List<ActualizacionDNI> traerActualizacionesDNI(LocalDate fecha, LugarDeTramite lugar) {
		List<ActualizacionDNI> listaFiltrada = new ArrayList<ActualizacionDNI>();
		
		
		for(ActualizacionDNI a: lstActualizacionDNI) {
			if(a.getLugarDeTramite().getLugarDeTramite().equals(lugar.getLugarDeTramite()) && a.getFecha().isEqual(fecha) ){
				listaFiltrada.add(a);
			}
		}
	
		return listaFiltrada;
	}
	
	public float calcularRecaudacion(LocalDate fecha, LugarDeTramite lugarDeTramite) {
		float total = 0;
		for(ActualizacionDNI d:lstActualizacionDNI ) {
			if(d.getFecha().isEqual(fecha) && d.getLugarDeTramite().equals(lugarDeTramite)) {
				total += d.getCostoActualizacion();
			}
		}
		return total;
	}
	

	
	public boolean agregarPersona(long dni,String apellido,String nombre,LocalDate fecha, boolean esArgentino) throws Exception{
		int id = calcularIdPersona();
		Persona encontrado = new Persona(id,dni,apellido,nombre,fecha,esArgentino);
		return lstPersonas.add(encontrado);		
	}
	
	public boolean agregarLugarDeTramite(String lugarDeTramite) throws Exception{
		int id = calcularIdLugarDeTramite();
		LugarDeTramite encontrado = new LugarDeTramite(id,lugarDeTramite);
		return lstLugarDeTramite.add(encontrado);		
	}
	
	public boolean agregarActualizacionDNI(LugarDeTramite lugarDeTramite, LocalDate fecha, Persona persona, boolean esExpres) throws Exception{
		
		int id = calcularIdActualizacionDNI();
		float costo = calcularCostoDeActualizacion(persona,fecha,esExpres);
		ActualizacionDNI encontrado = new ActualizacionDNI(id,lugarDeTramite,fecha,persona,costo,esExpres);
		return lstActualizacionDNI.add(encontrado);		
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



	public float getMasValorExpres() {
		return masValorExpres;
	}



	public void setMasValorExpres(float masValorExpres) {
		this.masValorExpres = masValorExpres;
	}



	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}



	public void setLstPersonas(List<Persona> lstPersonas) {
		this.lstPersonas = lstPersonas;
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
	public int hashCode() {
		return Objects.hash(lstActualizacionDNI, lstLugarDeTramite, lstPersonas, Float.valueOf(masValorExpres),
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
		Sistema other = (Sistema) obj;
		return Objects.equals(lstActualizacionDNI, other.lstActualizacionDNI)
				&& Objects.equals(lstLugarDeTramite, other.lstLugarDeTramite)
				&& Objects.equals(lstPersonas, other.lstPersonas)
				&& Float.floatToIntBits(masValorExpres) == Float.floatToIntBits(other.masValorExpres)
				&& Float.floatToIntBits(valorExtranjeros) == Float.floatToIntBits(other.valorExtranjeros)
				&& Float.floatToIntBits(valorStandar) == Float.floatToIntBits(other.valorStandar);
	}



	@Override
	public String toString() {
		return "Sistema [valorStandar=" + valorStandar + ", valorExtranjeros=" + valorExtranjeros + ", masValorExpres="
				+ masValorExpres + ", lstPersonas=" + lstPersonas + ", lstLugarDeTramite=" + lstLugarDeTramite
				+ ", lstActualizacionDNI=" + lstActualizacionDNI + "]";
	}
	
}
