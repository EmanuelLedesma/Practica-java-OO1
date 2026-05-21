package test;
import modelo.*;
public class TestSistemaVentas {

	public static void main(String[] args) {
		
		Sistema s = new Sistema(); 
		
		//======================================================================================
		//======================================================================================
		try {

			
			System.out.println("Objetos agregados con éxito: ");
			for(Cliente o:s) {
				System.out.println(o);
			}
			System.out.println("\n");
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//======================================================================================
		//======================================================================================

		
		
		System.out.println("\n");
		System.out.println("Test 1: ----------------------------");
		
		
		System.out.println("\n");
		System.out.println("Test 2: ----------------------------");
		
		
		System.out.println("\n");
		System.out.println("Test 3: ----------------------------");
		
		
		System.out.println("\n");
		System.out.println("Test 4: ----------------------------");
		
		
		System.out.println("\n");
		System.out.println("Test 5: ----------------------------");

	}

}
