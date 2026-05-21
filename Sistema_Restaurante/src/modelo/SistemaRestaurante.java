package modelo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SistemaRestaurante {
	private List<Cliente> lstCliente;
	private List<Mesa> lstMesas;
	private List<Reserva> lstReservas;
	
	public SistemaRestaurante() {
		this.lstCliente = new ArrayList<Cliente>();
		this.lstMesas = new ArrayList<Mesa>();
		this.lstReservas = new ArrayList<Reserva>();
	}
	@Override
	public String toString() {
		return "SistemaRestaurante [lstCliente=" + lstCliente + ", lstMesas=" + lstMesas + ", lstReservas="
				+ lstReservas + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(lstCliente, lstMesas, lstReservas);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SistemaRestaurante other = (SistemaRestaurante) obj;
		return Objects.equals(lstCliente, other.lstCliente) && Objects.equals(lstMesas, other.lstMesas)
				&& Objects.equals(lstReservas, other.lstReservas);
	}
	public List<Cliente> getLstCliente() {
		return lstCliente;
	}
	public void setLstCliente(List<Cliente> lstCliente) {
		this.lstCliente = lstCliente;
	}
	public List<Mesa> getLstMesas() {
		return lstMesas;
	}
	public void setLstMesas(List<Mesa> lstMesas) {
		this.lstMesas = lstMesas;
	}
	public List<Reserva> getLstReservas() {
		return lstReservas;
	}
	public void setLstReservas(List<Reserva> lstReservas) {
		this.lstReservas = lstReservas;
	}

	
	public int calcularIdCliente(){
		int id = 1;
		if(!lstCliente.isEmpty()) {
			id = lstCliente.get(lstCliente.size()-1).getIdCliente() + 1;
		}
		return id;
	}
	public int calcularIdMesa(){
		int id = 1;
		if(!lstMesas.isEmpty()) {
			id = lstMesas.get(lstMesas.size()-1).getIdMesa() + 1;
		}
		return id;
	}
	public int calcularIdReserva(){
		int id = 1;
		if(!lstReservas.isEmpty()) {
			id = lstReservas.get(lstReservas.size()-1).getIdReserva() + 1;
		}
		return id;
	}
	
	public Cliente traerCliente(long dni){
		Cliente encontrado = null;
		int i = 0;
		while(i<lstCliente.size() && encontrado == null ) {
			if(lstCliente.get(i).getDni() == dni) {
				encontrado = lstCliente.get(i);
			}
			i++;
		}
		return encontrado;		
	}
	
	public Mesa traerMesa(int numeroMesa){
		Mesa encontrado = null;
		int i = 0;
		while(i<lstMesas.size() && encontrado == null ) {
			if(lstMesas.get(i).getNumeroMesa() == numeroMesa) {
				encontrado = lstMesas.get(i);
			}
			i++;
		}
		return encontrado;		
	}
	
	public Reserva traerReserva(int numeroMesa, LocalDate fechaReserva){
		Reserva encontrado = null;
		int i = 0;
		while(i<lstReservas.size() && encontrado == null ) {
			if(lstReservas.get(i).getMesa().getNumeroMesa() == numeroMesa && lstReservas.get(i).getFecha().isEqual(fechaReserva)) {
				encontrado = lstReservas.get(i);
			}
			i++;
		}
		return encontrado;		
	}
	
	public List<Reserva> traerReservasPorFechas(LocalDate fechaDesde, LocalDate fechaHasta){
		List<Reserva> encontrados = new ArrayList<Reserva>();
		for(Reserva r: lstReservas) {
			if(!r.getFecha().isBefore(fechaDesde) && !r.getFecha().isAfter(fechaHasta) ) {
				encontrados.add(r);
			}
		}
		return encontrados;		
	}
	
	public List<Mesa> traerMesasLibres(LocalDate fecha){
		List<Mesa> mesasFiltradas = new ArrayList<Mesa>(lstMesas);
		for(Reserva r: lstReservas) {
			if(r.getFecha().isEqual(fecha)) {
				mesasFiltradas.remove(r.getMesa());
			}
		}
		return mesasFiltradas;
	}
	
	public boolean agregarCliente(String nombre, String apellido, long dni, String telefono) {
		if(traerCliente(dni)!=null) {
			throw new IllegalArgumentException("Error: El cliente ya existe");
		}
		int id = calcularIdCliente();
		return lstCliente.add(new Cliente(id,nombre,apellido,dni,telefono));
		
	}
	
	public boolean agregarMesa(int numeroMesa, int capacidad) {
		if(traerMesa(numeroMesa)!=null) {
			throw new IllegalArgumentException("Error: La mesa ya existe");
		}
		int id = calcularIdMesa();
		return lstMesas.add(new Mesa(id,numeroMesa,capacidad));
		
	}
	
	public boolean agregarReserva(Cliente cliente, LocalDate fechaReserva, Mesa mesa, int cantComensales) {
		if(traerReserva(mesa.getNumeroMesa(),fechaReserva) != null) {
			throw new IllegalArgumentException("Error: la mesa ya esta reservada para esa fecha");
		}
		int id = calcularIdReserva();
		return lstReservas.add(new Reserva(id,cliente,fechaReserva,mesa,cantComensales));
	}
	
	
	
	
	//especificar las listas
	// El constructor del sistema NO CONFUNDIR

	
	
	
}
