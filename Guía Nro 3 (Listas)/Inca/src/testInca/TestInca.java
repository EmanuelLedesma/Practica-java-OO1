package testInca;
import modelo.Genero;
import modelo.Incaa;

public class TestInca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Incaa catalogo = new Incaa();
		try {
			catalogo.agregarGenero("Acción");
			catalogo.agregarGenero("Aventura");
			catalogo.agregarGenero("Comedia");
			catalogo.agregarPelicula("Iron man",catalogo.traerGenero("Acción"));
			catalogo.agregarPelicula("Iron man 2",catalogo.traerGenero("Acción"));
			catalogo.agregarPelicula("Iron man 3",catalogo.traerGenero("Acción"));
			catalogo.agregarPelicula("Suicide Squad",catalogo.traerGenero("Acción"));
			catalogo.agregarPelicula("La era de hielo 2",catalogo.traerGenero("Aventura"));
		} catch ( Exception e ){
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		System.out.println("-------------------------------------");
		System.out.println("TESTEO DE FUNCIONES");
		System.out.println("-------------------------------------");
		
		System.out.println("Metodo traerPelicula(1): "+ catalogo.traerPelicula(1).getNombre() );
		System.out.println("-------------------------------------");
		
		System.out.println("Filtrar películas: ");
		catalogo.mostrarLista(catalogo.traerPelicula("iron"));
		System.out.println("-------------------------------------");
		
		System.out.println("CATALOGO DE PELÍCULAS:");
		catalogo.mostrarCatalogo();
		
		
		System.out.println("-------------------------------------");
		try {
			catalogo.modificarPelicula(1, "Alvin y las ardillas",catalogo.traerGenero("Comedia"));
		} catch ( Exception e ){
			System.out.println("Excepcion: " + e.getMessage());
		}
		System.out.println("Metodo Modificar película(1): ");
		System.out.println(catalogo.traerPelicula(1).getNombre());
		System.out.println("-------------------------------------");
		
		try {
			catalogo.eliminarPelicula(5);
		}catch ( Exception e ){
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		System.out.println("Metodo eliminarPelicula(5):");
		System.out.println("CATALOGO MODIFICADO: ");
		catalogo.mostrarCatalogo();
		System.out.println("-------------------------------------");
		System.out.println("Peliculas de comedia:");
		Genero comedia = catalogo.traerGenero("Comedia");
		catalogo.mostrarLista(catalogo.traerPeliculaPorGenero(comedia));
		System.out.println("-------------------------------------");
		
		System.out.println("-------------------------------------");
	
	}

}
