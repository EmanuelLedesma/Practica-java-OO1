package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

public class Sistema {
	List<Producto> lstProductos;
	List<Categoria> lstCategorias;
	List<MovimientoInventario> lstMovimientos;
	
	public Sistema() {
		super();
		lstProductos = new ArrayList<Producto>();
		lstCategorias = new ArrayList<Categoria>();
		lstMovimientos = new ArrayList<MovimientoInventario>();
	}
	
	public Categoria traerCategoria(String nombre){
		Categoria encontrado = null;
		int i = 0;
		while(encontrado == null && i < lstCategorias.size()) {
			if(lstCategorias.get(i).getNombre().equals(nombre)) {
				encontrado = lstCategorias.get(i);
			}
			i++;
		}
		return encontrado;
	}
	
	public Producto traerProducto(int codigo){
		Producto encontrado = null;
		int i = 0;
		while(encontrado == null && i < lstProductos.size()) {
			if(lstProductos.get(i).getCodigo() == codigo) {
				encontrado =  lstProductos.get(i);
			}
			i++;
		}
		return encontrado;
	}
	
	public List<MovimientoInventario> traerVentas(LocalDate fechaDesde, LocalDate fechaHasta){
		List<MovimientoInventario> listaFiltrada = new ArrayList<MovimientoInventario>();
		
		for(MovimientoInventario o:lstMovimientos) {
			if(!o.getFecha().isBefore(fechaDesde) && !o.getFecha().isAfter(fechaHasta) && o.getCantidad()<0) {
				listaFiltrada.add(o);
			}
		}
		return listaFiltrada;
	}
	
	public List<MovimientoInventario> traerVentasRefrigerado(LocalDate fecha){
		List<MovimientoInventario> listaFiltrada = new ArrayList<MovimientoInventario>();
		
		for(MovimientoInventario o:lstMovimientos) {
			if(o.getProducto() instanceof ProductoPerecedero producto) {
//				if((((ProductoPerecedero)o.getProducto() ).isRequiereRefrigeracion() == true) 
//					&& fecha.isEqual(o.getFecha())) {
//					listaFiltrada.add(o);
//				}
				// Producto ProductoPerecedero = (ProductoPerecedero) producto
				if(producto.isRequiereRefrigeracion()==true && fecha.isEqual(o.getFecha())) {
					listaFiltrada.add(o);
				}
				
			}
		}
		return listaFiltrada;
	}
	
	public List<Producto> traerProductosAReabastecer(Categoria categoria){
		List<Producto> listaFiltrada = new ArrayList<Producto>();
		
		for(Producto o: lstProductos) {
			if(o.esNecesarioReabastecer() && o.getCategoria().equals(categoria)) {
				listaFiltrada.add(o);
			}
		}
		return listaFiltrada;
	}
	
	public boolean agregarProductoNoPerecedero(int codigo, String nombre, float precio, Categoria categoria,
		int cantidadDisponible, int mesesDeGarantia, int cantidadMinima) {
		Producto encontrado = traerProducto(codigo);
		if(encontrado!=null) {
			throw new IllegalArgumentException("Error: Ya existe un producto con ese codigo");
		}
		int id = 1;
		if(!lstProductos.isEmpty()) {
			id = lstProductos.get(lstProductos.size()-1).getIdProducto() +1;
		}
		
		return lstProductos.add(new AlimentoNoPerecedero(id,codigo, nombre,precio,categoria,cantidadDisponible,
				mesesDeGarantia, cantidadMinima));
	}
	
	public boolean agregarProductoPerecedero(int codigo, String nombre, float precio, Categoria categoria,
			int cantidadDisponible, LocalDate fechaVencimiento, boolean requiereRefrigeracion) {
			Producto encontrado = traerProducto(codigo);
			if(encontrado!=null) {
				throw new IllegalArgumentException("Error: Ya existe un producto con ese codigo");
			}
			int id = 1;
			if(!lstProductos.isEmpty()) {
				id = lstProductos.get(lstProductos.size()-1).getIdProducto() +1;
			}
			
			return lstProductos.add(new ProductoPerecedero(id,codigo, nombre,precio,categoria,cantidadDisponible,
					fechaVencimiento, requiereRefrigeracion));
		}
	
	public boolean agregarCategoria(String nombre){
		Categoria categoria = new Categoria(nombre);
		return lstCategorias.add(categoria);
	}
	
	public boolean agregarMovimientoInventario(Producto producto, LocalDate fecha, int cantidad) {
			if(producto.cantidadDisponible < - cantidad && cantidad<0) {
				throw new IllegalArgumentException("Error: stock insuficiente");
			}
			int id = 1;
			if(!lstMovimientos.isEmpty()) {
				id = lstMovimientos.get(lstMovimientos.size()-1).getIdMovimientoInventario() +1;
			}
			producto.setCantidadDisponible(producto.getCantidadDisponible()+cantidad);
			return lstMovimientos.add(new MovimientoInventario(id,producto, fecha,cantidad));
		}
	
	public List<Producto> getLstProductos() {
		return lstProductos;
	}
	public void setLstProductos(List<Producto> lstProductos) {
		this.lstProductos = lstProductos;
	}
	public List<Categoria> getLstCategorias() {
		return lstCategorias;
	}
	public void setLstCategorias(List<Categoria> lstCategorias) {
		this.lstCategorias = lstCategorias;
	}
	public List<MovimientoInventario> getLstMovimientos() {
		return lstMovimientos;
	}
	public void setLstMovimientos(List<MovimientoInventario> lstMovimientos) {
		this.lstMovimientos = lstMovimientos;
	}
	@Override
	public int hashCode() {
		return Objects.hash(lstCategorias, lstMovimientos, lstProductos);
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
		return Objects.equals(lstCategorias, other.lstCategorias)
				&& Objects.equals(lstMovimientos, other.lstMovimientos)
				&& Objects.equals(lstProductos, other.lstProductos);
	}
	
	
	
}
