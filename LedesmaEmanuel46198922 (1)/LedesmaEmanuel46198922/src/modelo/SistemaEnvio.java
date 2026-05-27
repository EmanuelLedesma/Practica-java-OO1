package modelo;

import java.util.List;
import java.util.Objects;
import java.time.LocalDate;
import java.util.ArrayList;

public class SistemaEnvio {
	private double tarifaNacional;
	private double tarifaInternacional;
	private double adicionalPorKilogramo;
	private double adicionalPorKilometro;
	private double recargoExpress;
	private List<Cliente> lstCliente;
	private List<Envio> lstEnvio;
	public SistemaEnvio(double tarifaNacional, double tarifaInternacional, double adicionalPorKilogramo, double adicionalPorKilometro,
			double recargoExpress) {
		super();
		this.tarifaNacional = tarifaNacional;
		this.tarifaInternacional = tarifaInternacional;
		this.adicionalPorKilogramo = adicionalPorKilogramo;
		this.adicionalPorKilometro=adicionalPorKilometro;
		this.recargoExpress = recargoExpress;
		this.lstCliente = new ArrayList<Cliente>();
		this.lstEnvio = new ArrayList<Envio>();
	}
	public double getTarifaNacional() {
		return tarifaNacional;
	}
	public void setTarifaNacional(double tarifaNacional) {
		this.tarifaNacional = tarifaNacional;
	}
	public double getTarifaInternacional() {
		return tarifaInternacional;
	}
	public void setTarifaInternacional(double tarifaInternacional) {
		this.tarifaInternacional = tarifaInternacional;
	}
	public double getAdicionalPorKilogramo() {
		return adicionalPorKilogramo;
	}
	public void setAdicionalPorKilogramo(double adicionalPorKilogramo) {
		this.adicionalPorKilogramo = adicionalPorKilogramo;
	}
	public double getRecargoExpress() {
		return recargoExpress;
	}
	public void setRecargoExpress(double recargoExpress) {
		this.recargoExpress = recargoExpress;
	}
	public List<Cliente> getLstCliente() {
		return lstCliente;
	}
	public void setLstCliente(List<Cliente> lstCliente) {
		this.lstCliente = lstCliente;
	}
	public List<Envio> getLstEnvio() {
		return lstEnvio;
	}
	public void setLstEnvio(List<Envio> lstEnvio) {
		this.lstEnvio = lstEnvio;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Double.valueOf(adicionalPorKilogramo), lstCliente, lstEnvio, Double.valueOf(recargoExpress),
				Double.valueOf(tarifaInternacional), Double.valueOf(tarifaNacional));
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SistemaEnvio other = (SistemaEnvio) obj;
		return Double.doubleToLongBits(adicionalPorKilogramo) == Double.doubleToLongBits(other.adicionalPorKilogramo)
				&& Objects.equals(lstCliente, other.lstCliente) && Objects.equals(lstEnvio, other.lstEnvio)
				&& Double.doubleToLongBits(recargoExpress) == Double.doubleToLongBits(other.recargoExpress)
				&& Double.doubleToLongBits(tarifaInternacional) == Double.doubleToLongBits(other.tarifaInternacional)
				&& Double.doubleToLongBits(tarifaNacional) == Double.doubleToLongBits(other.tarifaNacional);
	}
	@Override
	public String toString() {
		return "SistemaEnvio [tarifaNacional=" + tarifaNacional + ", tarifaInternacional=" + tarifaInternacional
				+ ", adicionalPorKilogramo=" + adicionalPorKilogramo + ", recargoExpress=" + recargoExpress
				+  "]";
	}
	
	public int calcularIdCliente() {
		int id = 1;
		if(!lstCliente.isEmpty()) {
			id = lstCliente.get(lstCliente.size()-1).getId()+1;
		}
		return id;
	}
	
	public int calcularIdEnvio() {
		int id = 1;
		if(!lstEnvio.isEmpty()) {
			id = lstEnvio.get(lstEnvio.size()-1).getId()+1;
		}
		return id;
	}
	
	public boolean agregarCliente(String apellido,String nombre,String email) {
		int id = calcularIdCliente();
		Cliente nuevoCliente = new Cliente(id, nombre, apellido, email);
		return lstCliente.add(nuevoCliente);
	}
	
	
	
	
	
	public Cliente traerCliente(String email) {
		Cliente encontrado = null;
		int i = 0;
		while(i < lstCliente.size() && encontrado == null) {
			if(lstCliente.get(i).getEmail()==email) {
				encontrado = lstCliente.get(i);
			}
			i++;
		}
		return encontrado;
	}
	
	
	public boolean agregarEnvio(String codigoTracking, Cliente remitente, Cliente destinatario,
			LocalDate fechaIngreso, String estado, boolean esExpress, double peso,
			String provincia, String codigoPostal) {

		int id = calcularIdEnvio();

		
		EnvioNacional envio = new EnvioNacional(id, codigoTracking, remitente, destinatario, fechaIngreso, estado, esExpress, peso, provincia, codigoPostal);
		envio.setCostoFinal(envio.calcularCostoFinal(tarifaNacional, adicionalPorKilogramo, recargoExpress));
		return this.lstEnvio.add(envio);
	}
	
	public boolean agregarEnvioInternacional(String codigoTracking, Cliente remitente, Cliente destinatario,
			LocalDate fechaIngreso, String estado, boolean esExpress, double peso,
			String paisDeDestino, double distancia) {

		int id = calcularIdEnvio();
		EnvioInternacional envio = new EnvioInternacional(id, codigoTracking, remitente, destinatario, fechaIngreso, estado, esExpress, peso, paisDeDestino, distancia);
		envio.setCostoFinal(envio.calcularCostoFinal(tarifaInternacional, adicionalPorKilometro, recargoExpress));
		
		return this.lstEnvio.add(envio);
	}
	
	public List<Envio> traerEnvio(LocalDate fechaIngreso, String destino) {
		List<Envio> listaFiltrada = new ArrayList<Envio>();

		for (Envio o : lstEnvio) {

			if (o.getFechaIngreso().equals(fechaIngreso)) {

				if (o instanceof EnvioNacional) {

					EnvioNacional nacional = (EnvioNacional) o;

					if (nacional.getProvincia().equalsIgnoreCase(destino)) {
						listaFiltrada.add(o);
					}

				} else if (o instanceof EnvioInternacional) {

					EnvioInternacional internacional = (EnvioInternacional) o;

					if (internacional.getPaisDestino().equalsIgnoreCase(destino)) {
						listaFiltrada.add(o);
					}
				}
			}
		}

		return listaFiltrada;
	}
	
	public double calcularRecaudacion(LocalDate fechaIngreso, String destino) {

		double total = 0;

		List<Envio> lista = traerEnvio(fechaIngreso, destino);

		for (Envio o : lista) {
			total += o.getCostoFinal();
		}

		return total;
	}
	
	//public boolean validarCodigoTracking(String codigoTracking){
		//los envios tienen un codigo de seguimiento que tiene el formato: xx123456789
		//las dos primeras letras indican el tipo de envio y las ultimas dos el pais en donde se despacho el envio
		//el novenonumero es el digito verificador
		//se calcular: codigo : CP473234829AR 47312482 es el codigonumerico 9 es el verificador
//	}
	
}
