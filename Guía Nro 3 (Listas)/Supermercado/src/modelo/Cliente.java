package modelo;

public class Cliente {
	private String nombreCliente;
	private long dni;
	private String direccion;
	private int idCliente;
	
	public Cliente(int idCliente, String cliente, long dni, String direccion) {
		super();
		this.idCliente = idCliente;
		this.nombreCliente = cliente;
		this.dni = dni;
		this.direccion = direccion;
	}
	
	
	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String cliente) {
		this.nombreCliente = cliente;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}	
	
}

