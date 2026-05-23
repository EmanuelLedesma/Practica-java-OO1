package modelo;

import java.util.List;
import java.util.Objects;

public class Sistema {
	List<Producto> lstProductos;
	List<Categoria> lstCategorias;
	List<MovimientoIventario> lstMovimientos;
	
	public Sistema(List<Producto> lstProductos, List<Categoria> lstCategorias,
			List<MovimientoIventario> lstMovimientos) {
		super();
		this.lstProductos = lstProductos;
		this.lstCategorias = lstCategorias;
		this.lstMovimientos = lstMovimientos;
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
	

	
	public boolean agregarCategoria(String nombre){
		Categoria categoria = new Categoria(nombre);
		return lstCategorias.add(categoria);
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
	public List<MovimientoIventario> getLstMovimientos() {
		return lstMovimientos;
	}
	public void setLstMovimientos(List<MovimientoIventario> lstMovimientos) {
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
