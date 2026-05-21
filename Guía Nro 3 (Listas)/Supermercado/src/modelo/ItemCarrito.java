package modelo;

public class ItemCarrito {
	private Producto producto;
	private int cantidad;
	private int idItem;
	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	public Producto getProductoItem() {
		return producto;
	}
	public void setProductoItem(Producto producto) throws Exception {
		if(producto == null) {
			throw new Exception("Error: producto nulo");
		}
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) throws Exception{
		if(cantidad<=0) {
			throw new Exception("Error: la cantidad tiene que ser mayor a 0");
		}
		this.cantidad = cantidad;
	}
	
	public float calcularSubTotal() {
	    return this.getCantidad() * this.getProductoItem().getPrecio();
	}
	
	public ItemCarrito(int idItem, Producto producto, int cantidad) throws Exception{
		super();
		this.idItem = idItem;
		this.setProductoItem(producto);
		this.setCantidad(cantidad);
	}
	

}
