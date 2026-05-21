package modelo;

public class Producto {
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) throws Exception {
	    if (producto == null || producto == "") {
	    	throw new Exception("Error: nombre nulo o vacio");
	    }
		this.producto = producto;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) throws Exception {
	    if (precio <= 0) {
	        throw new Exception("Error: El precio debe ser mayor a 0.");
	    }
	    this.precio = precio;
	}
	public Producto(int idProducto, String producto, float precio) throws Exception {
		super();
		this.idProducto = idProducto;
		this.setPrecio(precio);
		this.setProducto(producto);
	}
	private int idProducto;
	private String producto;
	private float precio;
	
}
