package Array;
import java.util.Arrays;

public class ArregloUnidimensional {
	private int[] vector;

	public ArregloUnidimensional(int[] vector) {
		super();
		this.vector = vector;
	}
	
	public int[] getVector() {
		return this.vector;
	}

	public void setVector(int[] vector) {
		this.vector = vector;
	}

	public int traerElMenor() {
		int menor = this.vector[0];
		for(int i = 1; i<this.vector.length;i++) {
			
			if(this.vector[i]<menor) {
				menor = this.vector[i];
			}
		
		}
		return menor;
	}
	
	public int traerElMayor() {
		int mayor = this.vector[0];
		for(int i = 1; i<this.vector.length;i++) {
			
			if(this.vector[i]>mayor) {
				mayor = this.vector[i];
			}
		
		}
		return mayor;
}
	
	public double calcularPromedio() {
		double suma = 0;
		for(int i = 0; i<this.vector.length;i++) {
			suma = suma + this.vector[i];
		}
		return suma/this.vector.length;
	}
	
	public int[] ordenarAscendente() {
		for (int i = 0;i<this.vector.length-1;i++) {
			boolean intercambio = false;
			for(int j=0;j<this.vector.length-i-1;j++) {
				if(this.vector[j]>this.vector[j+1]) {
					int temp = this.vector[j+1];
					this.vector[j+1] = this.vector[j];
					this.vector[j] = temp;
					intercambio = true;
				}
			}
			if (intercambio == false) break; //El break aca es para romper con el bucle cuando el vec. esta ordenado.
		}
		return this.vector;
	}
	
	public int[] ordenarDescendente() {
		for (int i = 0;i<this.vector.length-1;i++) {
			boolean intercambio = false;
			for(int j=0;j<this.vector.length-i-1;j++) {
				if(this.vector[j]<this.vector[j+1]) {
					int temp = this.vector[j+1];
					this.vector[j+1] = this.vector[j];
					this.vector[j] = temp;
					intercambio = true;
				}
			}
			if (intercambio == false) break; //El break aca es para romper con el bucle cuando el vec. esta ordenado.
		}
		return this.vector;
	}
	
	public void resetearVector() {
	    Arrays.fill(this.vector, 0);
	}
	
	public void ordenarRapido() {
	    Arrays.sort(this.vector);
	}
	
	public int buscarPosicion(int numeroABuscar) {
	    // Primero ordenamos, sino la búsqueda fallará
	    Arrays.sort(this.vector); 
	    return Arrays.binarySearch(this.vector, numeroABuscar);
	}
	
	public void imprimirVector(int[] vec) {
		System.out.println(Arrays.toString(vec));
	}
	
	public double traerFrecuencia(int numero) {
		int aux=0;
		for(int i=0; i<this.vector.length;i++) {
			if(this.vector[i]==numero) {
				aux++;
			}
		}
		return (double) aux / this.vector.length;
	}
	
	public int traerModa() {
		int moda=this.vector[0];
		for(int i=1; i<this.vector.length;i++){
				if(traerFrecuencia(moda)< traerFrecuencia(this.vector[i])) {
					moda = this.vector[i];
				}
			}
		return moda;
	}
	
}
