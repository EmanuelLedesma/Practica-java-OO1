package modelo;

import java.util.List;
import java.util.ArrayList;

public class Incaa {
	private List<Pelicula> catalogo;
	private List<Genero> generos;

	public Incaa() {
		super();
		this.catalogo = new ArrayList<Pelicula>();
		this.generos = new ArrayList<Genero>();
	}

	public int calcularProximoId() {
		int id = 1;
		if (!catalogo.isEmpty()) {
			id = catalogo.get(catalogo.size() - 1).getIdPelicula() + 1;
		}
		return id;
	}
	
	public int calcularProximoIdGeneros() {
		int id = 1;
		if (!generos.isEmpty()) {
			id = generos.get(generos.size() - 1).getIdGenero() + 1;
		}
		return id;
	}

	public Pelicula traerPelicula(int idPelicula) {
		Pelicula encontrado = null;
		int i = 0;
		while (i < catalogo.size() && encontrado == null) {
			if (catalogo.get(i).getIdPelicula() == idPelicula) {
				encontrado = catalogo.get(i);
			}
			i++;
		}
		return encontrado;
	}
	
	public Pelicula traerPelicula(Genero genero) {
		Pelicula encontrado = null;
		int i = 0;
		while (i < catalogo.size() && encontrado == null) {
			if (catalogo.get(i).getGenero() == genero) {
				encontrado = catalogo.get(i);
			}
			i++;
		}
		return encontrado;
	}

	public Pelicula traerPeliculaNombre(String nombre) {
		Pelicula encontrado = null;
		int i = 0;
		while (i < catalogo.size() && encontrado == null) {
			if (catalogo.get(i).getNombre().equals(nombre)) {
				encontrado = catalogo.get(i);
			}
			i++;
		}
		return encontrado;
	}
	public Genero traerGenero(String nombre) {
		Genero encontrado = null;
		int i = 0;
		while (i < generos.size() && encontrado == null) {
			if (generos.get(i).getGeneroNombre().equals(nombre)) {
				encontrado = generos.get(i);
			}
			i++;
		}
		return encontrado;
	}

	public boolean agregarPelicula(String nombre, Genero genero) throws Exception {
		if (this.traerPeliculaNombre(nombre) != null) {
			throw new Exception("La película ya esta en el catálogo");
		}

		int id = calcularProximoId();
		return catalogo.add(new Pelicula(id, nombre, genero));
	}
	
	public boolean agregarGenero(String nombre) throws Exception {
		if (this.traerGenero(nombre) != null) {
			throw new Exception("El genero ya esta en el catálogo");
		}

		int id = calcularProximoIdGeneros();
		return generos.add(new Genero (id, nombre));
	}

	public List<Pelicula> traerPelicula(String partePelicula) {
		List<Pelicula> peliculasFiltradas = new ArrayList<Pelicula>();

		for (Pelicula p : catalogo) {
			if (p.getNombre().toLowerCase().contains(partePelicula.toLowerCase())) {
				peliculasFiltradas.add(p);
			}
		}
		return peliculasFiltradas;
	}

	public boolean modificarPelicula(int idPelicula, String pelicula, Genero genero) throws Exception {
		Pelicula modificada = traerPelicula(idPelicula);
		if (modificada == null) {
			throw new Exception("Pelicula no encontrada");
		}

		modificada.setNombre(pelicula);
		modificada.setGenero(genero);
		return true;
	}

	public boolean eliminarPelicula(int idPelicula) throws Exception {
		Pelicula encontrada = traerPelicula(idPelicula);
		if (encontrada == null) {
			throw new Exception("Pelicula no encontrada");
		}

		catalogo.remove(encontrada);
		return true;
	}
	
	public void mostrarLista(List<Pelicula> lista) {
		for (Pelicula p : lista) {
			System.out.println(p.getNombre());
		}
	}

	public void mostrarCatalogo() {
		for (Pelicula p : catalogo) {
			System.out.println(p.getNombre() + ": " + p.getGenero().getGeneroNombre());
		}
	}
	
	public List<Pelicula> traerPeliculaPorGenero(Genero genero) {
		List<Pelicula> peliculasFiltradas = new ArrayList<Pelicula>();

		for (Pelicula p : catalogo) {
			if (p.getGenero()==genero) {
				peliculasFiltradas.add(p);
			}
		}
		return peliculasFiltradas;
	}


}
