package modelo;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Vehiculo> lstVehiculos;

	public Sistema() {
		lstVehiculos = new ArrayList<Vehiculo>() ;
	}

	public List<Vehiculo> getLstVehiculos() {
		return lstVehiculos;
	}

	public void setLstVehiculos(List<Vehiculo> lstVehiculos) {
		this.lstVehiculos = lstVehiculos;
	}

	@Override
	public String toString() {
		return "Sistema [lstVehiculos=" + lstVehiculos + "]";
	}
	
	public Vehiculo traerVehiculo(String marca, String modelo) {
		Vehiculo encontrado = null;
		int i = 0;
		while(encontrado == null && i<lstVehiculos.size()) {
			if(lstVehiculos.get(i).getMarca().equals(marca) && lstVehiculos.get(i).getModelo().equals(modelo)) {
				encontrado = lstVehiculos.get(i);
			}
			i++;
		}
		return encontrado;
	}
	
	
	public int calcularIdVehiculo() {
		int id = 1;
		if(!lstVehiculos.isEmpty()) {
			id = lstVehiculos.get(lstVehiculos.size()-1).getIdVehiculo()+1;
		}
		return id;
	}
	
	public boolean agregarAuto(String marca, String modelo, int anio, int cantRuedas, double eficienciaMotor,
			int cantPuertas) {
		int id = calcularIdVehiculo();
		Auto nuevo = new Auto(id,marca,modelo,anio,cantRuedas,eficienciaMotor,cantPuertas);
		return lstVehiculos.add(nuevo); 
	}
	public boolean agregarMoto(String marca, String modelo, int anio, int cantRuedas, double eficienciaMotor,
			boolean incluyeCaja, boolean diseñoAereodinamico) {
		int id = calcularIdVehiculo();
		Moto nuevo = new Moto(id,marca,modelo,anio,cantRuedas,eficienciaMotor,incluyeCaja, diseñoAereodinamico);
		return lstVehiculos.add(nuevo); 
	}
	
	//!!!!!! ACORDARSE DE AGREGAR EL VEHICULO A LA LISTA FILTRADA Y NO A LA LISTA GENERAL.
	public List<Vehiculo> traerVehiculosDeTransporte() {
	    List<Vehiculo> listaFiltrada = new ArrayList<Vehiculo>();

	    for (Vehiculo o : lstVehiculos) {
	        if (o instanceof Auto || (o instanceof Moto m && m.isIncluyeCaja())) {
	            listaFiltrada.add(o);
	        }
	    }
	    return listaFiltrada;
	}
	
	public List<Vehiculo> traerVehiculosPorConsumo(int km, double topeConsumo){
		List<Vehiculo> listaFiltrada = new ArrayList<Vehiculo>();
		
		for (Vehiculo o : lstVehiculos) {
			if(o.calcularConsumo(km)<topeConsumo) {
				listaFiltrada.add(o);
			}
		}
		return listaFiltrada;
	}

	
}

