package modelo;

public class Pelicula {
	
	private int idPelicula;
	private String pelicula;
	
	public Pelicula(int idPelicula, String pelicula) throws Exception{
		super();
		this.idPelicula = idPelicula;
		this.setPelicula(pelicula);
	}
	
	public int getIdPelicula() {
		return idPelicula;
	}
	private void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}
	public String getPelicula() {
		return pelicula;
	}
	public void setPelicula(String pelicula) throws Exception{
		if(this.validarNombre(pelicula)) throw new Exception("ERROR el nombre de la pelicula no puede estar vacio");
		this.pelicula = pelicula;
	}
	@Override
	public String toString() {
		return "Pelicula [idPelicula=" + idPelicula + ", pelicula=" + pelicula + "]";
	}
	
	public boolean validarNombre(String pelicula) {
		return pelicula.isEmpty(); //" "
	}
}
