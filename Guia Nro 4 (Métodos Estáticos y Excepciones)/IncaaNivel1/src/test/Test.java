package test;

import modelo.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Incaa incaa = new Incaa();
		
		try {
			incaa.agregarPelicula("Harry Potter 1");
			incaa.agregarPelicula("Harry Potter 2");
			incaa.agregarPelicula("Harry Potter 3");
			incaa.agregarPelicula("Harry Potter 4");
			incaa.agregarPelicula("Harry Potter 5");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		for(Pelicula p : incaa.getCatalogo()) {
			System.out.println(p);
		}
		
		try {
			incaa.agregarPelicula("Harry Potter 1");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		try {
			incaa.agregarPelicula("");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

}
