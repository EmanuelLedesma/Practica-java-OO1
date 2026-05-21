package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
	
	public Carrito(int idCarrito,LocalDate fecha, LocalTime hora, Cliente cliente) {
		super();
		this.idCarrito =idCarrito;
		this.fecha = fecha;
		this.hora = hora;
		this.lstItem = new ArrayList<ItemCarrito>();
		this.cliente = cliente;
	}
	
	public int getIdCarrito() {
		return idCarrito;
	}


	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public LocalTime getHora() {
		return hora;
	}


	public void setHora(LocalTime hora) {
		this.hora = hora;
	}


	public List<ItemCarrito> getLstItem() {
		return lstItem;
	}


	public void setLstItem(List<ItemCarrito> lstItem) {
		this.lstItem = lstItem;
	}


	private int idCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private List<ItemCarrito> lstItem;
	private Cliente cliente;
	
	
	public Cliente getClienteCarrito() {
		return cliente;
	}


	public void setClienteCarrito(Cliente cliente) {
		this.cliente = cliente;
	}


	
	
	
	public int calcularIdItem() {
		int id = 1;
		if(!lstItem.isEmpty()) {
			id = lstItem.get(lstItem.size()-1).getIdItem()+1;
		}
		return id;
	}
	
	public ItemCarrito traerItemProducto(Producto producto) {
		ItemCarrito encontrado = null;
		int i = 0;
		while(i<lstItem.size() && encontrado == null) {
			if(lstItem.get(i).getProductoItem().getIdProducto() == producto.getIdProducto()){
				encontrado = lstItem.get(i);
			}
			i++;
		}
		return encontrado;
	}
	
	
	public boolean agregarItem(Producto producto, int cantidad) throws Exception{
		ItemCarrito encontrado = traerItemProducto(producto);
		if(encontrado != null) {
			encontrado.setCantidad(encontrado.getCantidad() + cantidad);
		}else {
			int id = calcularIdItem();			
			lstItem.add(new ItemCarrito(id,producto,cantidad));
		}
		return true;
	}
	
	public boolean eliminarItem(Producto producto, int cantidad)throws Exception{
		ItemCarrito encontrado = traerItemProducto(producto);
		if(encontrado == null) {
			throw new Exception("El item no existe");
		}
		
		if(cantidad<encontrado.getCantidad()) {
			encontrado.setCantidad(encontrado.getCantidad()-cantidad);
		}else {
			lstItem.remove(encontrado);
		}
		
		return true;
	}
	
	public float calcularTotal() {
		float total = 0;
		for(ItemCarrito i: lstItem) {
			total += i.calcularSubTotal();
		}
		return total;		
	}

	
	
	

}
