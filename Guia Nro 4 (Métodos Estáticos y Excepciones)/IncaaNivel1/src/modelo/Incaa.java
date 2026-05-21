package modelo;

import java.util.List;
import java.util.ArrayList;

public class Incaa {
	
	//atributos
	private List<Pelicula> catalogo;

	public Incaa() {
		super();
		this.catalogo = new ArrayList<Pelicula>();
	}

	public List<Pelicula> getCatalogo() {
		return catalogo;
	}

	public boolean agregarPelicula(String pelicula) throws Exception {
		if(this.traerPeliculaNombre(pelicula) != null) throw new Exception("ERROR pelicula ya existe " + pelicula);
		int id;
		if(catalogo.isEmpty()) {
			id = 1;
		}else {
			id = catalogo.get(catalogo.size() - 1).getIdPelicula() + 1;
		}
		return catalogo.add(new Pelicula(id,pelicula));
	}
	
	public Pelicula traerPelicula(int idPelicula) {
		Pelicula p = null;
		int i = 0;
		while(p == null && i < catalogo.size()) {
			if(catalogo.get(i).getIdPelicula() == idPelicula) {
				p = catalogo.get(i);
			}
			i++;
		}
		return p;
	}
	
	public Pelicula traerPeliculaNombre(String pelicula) {
		Pelicula p = null;
		int i = 0;
		while(p == null && i < catalogo.size()) {
			if(catalogo.get(i).getPelicula().equalsIgnoreCase(pelicula)) {
				p = catalogo.get(i);
			}
			i++;
		}
		return p;
	}
	
	public List<Pelicula> traerPelicula(String partePelicula){
		List<Pelicula> aux = new ArrayList<Pelicula>();
		for(Pelicula p : catalogo) {
			if(p.getPelicula().contains(partePelicula)) {
				aux.add(p);
			}
		}
		return aux;
	}
	
	public void modificarPelicula(int idPelicula, String pelicula) throws Exception {
		Pelicula p = traerPelicula(idPelicula);
		p.setPelicula(pelicula);
	}
	
	public boolean eliminarPelicula(int idPelicula) {
		Pelicula p = traerPelicula(idPelicula);
		return catalogo.remove(p);
	}

}
