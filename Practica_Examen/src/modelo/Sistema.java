package modelo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sistema {
	private List<Cliente> lstClientes;
	private List<Producto> lstProductos;
	private List<Venta> lstVentas;
	
	public Sistema() {
		super();
		this.lstClientes = new ArrayList<Cliente>();
		this.lstProductos = new ArrayList<Producto>();
		this.lstVentas = new ArrayList<Venta>();
	}
	public List<Cliente> getLstClientes() {
		return lstClientes;
	}
	public void setLstClientes(List<Cliente> lstClientes) {
		this.lstClientes = lstClientes;
	}
	public List<Producto> getLstProductos() {
		return lstProductos;
	}
	public void setLstProductos(List<Producto> lstProductos) {
		this.lstProductos = lstProductos;
	}
	public List<Venta> getLstVentas() {
		return lstVentas;
	}
	public void setLstVentas(List<Venta> lstVentas) {
		this.lstVentas = lstVentas;
	}
	@Override
	public String toString() {
		return "Sistema [lstClientes=" + lstClientes + ", lstProductos=" + lstProductos + ", lstVentas=" + lstVentas
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(lstClientes, lstProductos, lstVentas);
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
		return Objects.equals(lstClientes, other.lstClientes) && Objects.equals(lstProductos, other.lstProductos)
				&& Objects.equals(lstVentas, other.lstVentas);
	}
	
	public int calcularIdCliente(){
		int id = 1;
		if(!lstClientes.isEmpty()) {
			id = lstClientes.get(lstClientes.size()-1).getIdCliente() +1;
		}
		return id;
	}
	
	
	public int calcularIdProducto(){
		int id = 1;
		if(!lstProductos.isEmpty()) {
			id = lstProductos.get(lstProductos.size()-1).getIdProducto() +1;
		}
		return id;
	}
	
	public int calcularIdVenta(){
		int id = 1;
		if(!lstVentas.isEmpty()) {
			id = lstVentas.get(lstVentas.size()-1).getIdVenta() +1;
		}
		return id;
	}
	
	public Cliente traerCliente(long id) {
		Cliente encontrado = null;
		int i = 0;
		while(i < lstClientes.size() && encontrado == null) {
			if(lstClientes.get(i).getIdCliente()==id) {
				encontrado = lstClientes.get(i);
			}
			i++;
		}
		return encontrado;
	}
	public Producto traerProducto(int id) {
		Producto encontrado = null;
		int i = 0;
		while(i < lstProductos.size() && encontrado == null) {
			if(lstProductos.get(i).getIdProducto()==id) {
				encontrado = lstProductos.get(i);
			}
			i++;
		}
		return encontrado;
	}
	public Producto traerProducto(String nombre) {
		Producto encontrado = null;
		int i = 0;
		while(i < lstProductos.size() && encontrado == null) {
			if(lstProductos.get(i).getNombre().equals(nombre)) {
				encontrado = lstProductos.get(i);
			}
			i++;
		}
		return encontrado;
	}
	
	public Venta traerVenta(int id) {
		Venta encontrado = null;
		int i = 0;
		while(i < lstVentas.size() && encontrado == null) {
			if(lstVentas.get(i).getIdVenta() ==id) {
				encontrado = lstVentas.get(i);
			}
			i++;
		}
		return encontrado;
	}
	
	public Venta traerVenta(Cliente cliente) {
		Venta encontrado = null;
		int i = 0;
		while(i < lstVentas.size() && encontrado == null) {
			if(lstVentas.get(i).getCliente().getNombre().equalsIgnoreCase(cliente.getNombre())) {
				encontrado = lstVentas.get(i);
			}
			i++;
		}
		return encontrado;
	}
	
	public boolean agregarCliente(String nombre,long dni) {
		if(traerCliente(dni) != null) {
			throw new IllegalArgumentException("Error: el cliente ya existe");
		}
		int id = calcularIdCliente();
		return lstClientes.add(new Cliente(id,nombre,dni));
	}
	
	public boolean agregarProducto(String nombre,double precio) {
		if(traerProducto(nombre) != null) {
			throw new IllegalArgumentException("Error: El producto ya existe");
		}
		int id = calcularIdProducto();
		return lstProductos.add(new Producto(id,nombre,precio));
	}
	
	public boolean agregarVenta(LocalDate fecha,Cliente cliente) {
		if(traerVenta(cliente) != null) {
			throw new IllegalArgumentException("Error: el cliente ya existe");
		}
		int id = calcularIdVenta();
		return lstVentas.add(new Venta(id,fecha,cliente));
	}
	
	
	
	

}
