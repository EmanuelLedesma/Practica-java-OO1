package modelo;

public class Pelicula {
	
	public Pelicula(int idPelicula, String nombre, Genero genero) {
		super();
		this.idPelicula = idPelicula;
		this.nombre = nombre;
		this.genero = genero;
	}
	
	private int idPelicula;
	private String nombre;
	private Genero genero;
	
	public int getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
}
