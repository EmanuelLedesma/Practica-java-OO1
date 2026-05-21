package modelo;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Supermercado {
	private List<Producto> gondola;
	public List<Cliente> getLstCliente() {
		return lstCliente;
	}


	public void setLstCliente(List<Cliente> lstCliente) {
		this.lstCliente = lstCliente;
	}


	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}


	public void setLstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}

	private List<Cliente> lstCliente;
	private List<Carrito> lstCarrito;
	
	public Supermercado() {
		super();
		this.gondola = new ArrayList<Producto>();
		this.lstCarrito = new ArrayList<Carrito>();
		this.lstCliente = new ArrayList<Cliente>();
	}
	
	
	public List<Producto> getGondola() {
		return gondola;
	}

	public void setGondola(List<Producto> gondola) {
		this.gondola = gondola;
	}
	
	public int calcularIdProducto() {
		int id = 1;
		if(!gondola.isEmpty()) {
			id = gondola.get(gondola.size()-1).getIdProducto()+1;
		}
		return id;
	}
	
	public int calcularIdCliente() {
		int id = 1;
		if(!lstCliente.isEmpty()) {
			id = lstCliente.get(lstCliente.size()-1).getIdCliente()+1;
		}
		return id;
	}
	
	
	
	public int calcularIdCarrito() {
		int id = 1;
		if(!lstCarrito.isEmpty()) {
			//conseguir el id del último carrito de la lista y sumarle 1
			id = lstCarrito.get(lstCarrito.size()-1).getIdCarrito()+1;
		}
		return id;
	}
	
	public Producto traerProducto(int idProducto) {
		Producto productoEncontrado = null;
		int i = 0;
		while(i<gondola.size() && productoEncontrado == null) {
			if(gondola.get(i).getIdProducto()==idProducto) {
				productoEncontrado = gondola.get(i);
			}
			i++;
		}
		return productoEncontrado;
	}
	public Producto traerProducto(String nombreProducto) {
		Producto productoEncontrado = null;
		int i = 0;
		while(i<gondola.size() && productoEncontrado == null) {
			if(gondola.get(i).getProducto().equals(nombreProducto)) {
				productoEncontrado = gondola.get(i);
			}
			i++;
		}
		return productoEncontrado;
	}
	
	public Cliente traerCliente(int idCliente) {
		Cliente encontrado = null;
		int i = 0;
		while(i<lstCliente.size() && encontrado == null) {
			if(lstCliente.get(i).getIdCliente() == idCliente) {
				encontrado = lstCliente.get(i);
			}
			i++;
		}
		return encontrado;
	}
	
	public Cliente traerCliente(String nombreCliente) {
		Cliente encontrado = null;
		int i = 0;
		while(i<lstCliente.size() && encontrado == null) {
			if(lstCliente.get(i).getNombreCliente().equals(nombreCliente)) {
				encontrado = lstCliente.get(i);
			}
			i++;
		}
		return encontrado;
	}
	
	public Carrito traerCarrito(int idCarrito) {
		Carrito encontrado = null;
		int i = 0;
		while(i<lstCarrito.size() && encontrado == null) {
			if(lstCarrito.get(i).getIdCarrito() == idCarrito) {
				encontrado = lstCarrito.get(i);
			}
			i++;
		}
		return encontrado;
	}
	
	public List<Carrito> traerCarritos(Cliente cliente) {
	    List<Carrito> carritosDelCliente = new ArrayList<Carrito>();
	    for (Carrito c : lstCarrito) {	        
	        if (c.getClienteCarrito().getIdCliente() == cliente.getIdCliente()) {
	            carritosDelCliente.add(c);
	        }
	    }
	    return carritosDelCliente;
	}
	
	public Carrito traerCarrito(LocalDate fecha, LocalTime hora, Cliente cliente) {
	    Carrito encontrado = null;
	    int i = 0;
	    while(i < lstCarrito.size() && encontrado == null) {
	        Carrito c = lstCarrito.get(i);
	        // Validamos que coincidan las tres cosas: Cliente (por ID), Fecha y Hora
	        if(c.getClienteCarrito().getIdCliente() == cliente.getIdCliente() && c.getFecha().equals(fecha) && c.getHora().equals(hora)) {

	            encontrado = c;
	        }
	        i++;
	    }
	    return encontrado;
	}
	
	
	public boolean agregarProducto(String producto, float precio) throws Exception{
		if(this.traerProducto(producto)!=null) {
			throw new Exception("Error: el producto ya existe");			
		}
		
		int id = calcularIdProducto();
		return gondola.add(new Producto(id, producto, precio));		
	}
	
	
	public boolean agregarCliente(String cliente, long dni, String direccion)throws Exception {
		Cliente encontrado = this.traerCliente(cliente);
		if(encontrado != null) {
			throw new Exception("Error: el cliente ya existe");
		}
		
		int id= calcularIdCliente();
		encontrado =  new Cliente(id,cliente,dni,direccion); 
		return lstCliente.add(encontrado);
		
	}
	
	public boolean agregarCarrito(LocalDate fecha, LocalTime hora, Cliente cliente) throws Exception {
		Carrito encontrado = this.traerCarrito(fecha,hora,cliente);
		if(encontrado != null) {
			throw new Exception("Error: el carrito ya existe");
		}
		int id = calcularIdCarrito();
		encontrado = new Carrito(id,fecha,hora,cliente);
		return lstCarrito.add(encontrado);
	}
	
	
	public boolean modificarProducto(int idProducto, String producto, float precio) throws Exception{
		Producto encontrado = traerProducto(idProducto);
		if(encontrado == null) {
			throw new Exception("Error: el producto no existe");
		}
		
		encontrado.setProducto(producto);
		encontrado.setPrecio(precio);
		return true;
	}
	
	public boolean eliminarProducto(int idProducto) throws Exception{
		Producto encontrado = traerProducto(idProducto);
		if(encontrado == null) {
			throw new Exception("Error: el producto no existe");
		}
		return gondola.remove(encontrado);
	}
	
	public boolean eliminarCliente(int idCliente) throws Exception{
		Cliente encontrado = traerCliente(idCliente);
		if(encontrado == null) {
			throw new Exception("Error: el cliente no existe");
		}
		
		return lstCliente.remove(encontrado);
	}
	
	public boolean eliminarCarrito(int idCarrito) throws Exception{
		Carrito encontrado = traerCarrito(idCarrito);
		if(encontrado == null) {
			throw new Exception("Error: el carrito no existe");
		}	
		return lstCarrito.remove(encontrado);
	}
		
	public float calcularTotal(Cliente cliente)throws Exception {
		float total = 0;
		Cliente encontrado = traerCliente(cliente.getIdCliente()); 
		if(encontrado == null) {
			throw new Exception("Error: el cliente no existe");
		}
		for(Carrito c: traerCarritos(cliente)) {
			total += c.calcularTotal();
		}
		return total;		
	}
	
	public float calcularTotal(int dniCliente)throws Exception {
		float total = 0;
		Cliente encontrado = traerCliente(dniCliente); 
		if(encontrado == null) {
			throw new Exception("Error: el cliente no existe");
		}
		for(Carrito c: traerCarritos(encontrado)) {
			total += c.calcularTotal();
		}
		return total;		
	}
	
	
	public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin) {
	    float totalPeriodo = 0;
	    for (Carrito carrito : lstCarrito) {
	        LocalDate fechaCarrito = carrito.getFecha();
	        if (!fechaCarrito.isBefore(fechaInicio) && !fechaCarrito.isAfter(fechaFin)) {
	            totalPeriodo = totalPeriodo + carrito.calcularTotal();
	        }
	    }
	    return totalPeriodo;
	}
	
	public float calcularTotal(LocalDate fecha) {
		float total = 0;
		for(Carrito c: lstCarrito) {
			LocalDate fechaCarrito = c.getFecha();
			if(fechaCarrito.equals(fecha)) {
				total += c.calcularTotal();
			}
		}
		return total;
	}
	
	
	public float calcularTotal(int mes, int anio) throws Exception {
		if(mes<=0 || mes>12) {
			throw new Exception("Error: mes incorrecto");
		}
		float total = 0;
		for(Carrito c: lstCarrito) {
			LocalDate fechaCarrito = c.getFecha();
			if(fechaCarrito.getYear() == anio && fechaCarrito.getMonthValue() == mes ) {
				total += c.calcularTotal();
			}
		}
		return total;
	}
	
	public float calcularTotal(LocalDate fecha, Cliente cliente)throws Exception {
		float total = 0;
		Cliente encontrado = traerCliente(cliente.getIdCliente());
		if(encontrado == null) {
			throw new Exception("Error: El cliente no existe");
		}
		
		List<Carrito> carritosCliente = traerCarritos(cliente);
		
		for(Carrito c: carritosCliente) {
			
			if(c.getFecha().equals(fecha)) {
				total+=c.calcularTotal();
			}
		}
		
		return total;	
	}
	
	public float calcularTotal(int mes, int anio, Cliente cliente)throws Exception {
		float total = 0;
		Cliente encontrado = traerCliente(cliente.getIdCliente());
		if(encontrado == null) {
			throw new Exception("Error: El cliente no existe");
		}
		if(mes<=0 || mes >12) {
			throw new Exception ("Error: El mes es incorrecto");
		}
		
		List<Carrito> carritosCliente = traerCarritos(cliente);
		
		for(Carrito c: carritosCliente) {
			
			if(c.getFecha().getMonthValue() == mes && c.getFecha().getYear() == anio) {
				total+=c.calcularTotal();
			}
		}
		
		return total;	
	}
	
	public float calcularTotal(int mes, int anio, int idCliente)throws Exception {
		float total = 0;
		Cliente encontrado = traerCliente(idCliente);
		if(encontrado == null) {
			throw new Exception("Error: El cliente no existe");
		}
		if(mes<=0 || mes >12) {
			throw new Exception ("Error: El mes es incorrecto");
		}
		
		List<Carrito> carritosCliente = traerCarritos(encontrado);
		
		for(Carrito c: carritosCliente) {
			
			if(c.getFecha().getMonthValue() == mes && c.getFecha().getYear() == anio) {
				total+=c.calcularTotal();
			}
		}
		
		return total;	
	}
	
}
