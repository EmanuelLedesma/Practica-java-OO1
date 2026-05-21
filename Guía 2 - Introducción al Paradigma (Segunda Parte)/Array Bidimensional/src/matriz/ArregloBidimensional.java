package matriz;

public class ArregloBidimensional {
	private double[][] matrizA;
	
	public ArregloBidimensional(double[][] matrizA) {
		super();
		this.matrizA = matrizA;
	}
	
	public double[][] sumar(double[][] matrizB){
		// 1. Declaramos la variable de retorno e inicializamos en null
		double[][] resultado = null;
	    //Estoy comparando Filas y columnas de ambas matrices
	    if (matrizB != null && this.matrizA.length == matrizB.length && this.matrizA[0].length == matrizB[0].length) {
	    	// 3. Inicializamos la matriz resultado con el tamaño correcto
	    	resultado= new double [this.matrizA.length][this.matrizA[0].length];
	    	for(int i = 0; i < this.matrizA.length; i++) {
	    		for(int j = 0; j < this.matrizA[i].length; j++) {
	    			resultado[i][j] = matrizA[i][j] + matrizB[i][j];
	    		}
	    	}
	    	
	    }
	    return resultado; 
	}
	
	public double[][] restar(double[][] matrizB){
		// 1. Declaramos la variable de retorno e inicializamos en null
		double[][] resultado = null;
	    //Estoy comparando Filas y columnas de ambas matrices
	    if (this.matrizA.length == matrizB.length && this.matrizA[0].length == matrizB[0].length) {
	    	// 3. Inicializamos la matriz resultado con el tamaño correcto
	    	resultado= new double [this.matrizA.length][this.matrizA[0].length];
	    	for(int i = 0; i < this.matrizA.length; i++) {
	    		for(int j = 0; j < this.matrizA[i].length; j++) {
	    			resultado[i][j] = this.matrizA[i][j] - matrizB[i][j];
	    		}
	    	}
	    	
	    }
	    return resultado; 
	}
	
	public void imprimirMatriz() {
		imprimirMatriz(this.matrizA);
	}
	
	public void imprimirMatriz(double[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {

				System.out.printf("%10.2f ", matriz[i][j]);
			}
			System.out.println();
		}
	}
	
	public void llenarAleatorio() {
	    for (int i = 0; i < this.matrizA.length; i++) {
	        for (int j = 0; j < this.matrizA[i].length; j++) {
	            // Genera un número aleatorio entre 1 y 20
	            // La fórmula es: (Math.random() * Cantidad_de_posibilidades) + Numero_Minimo
	            this.matrizA[i][j] = (int)(Math.random() * 20 + 1);
	        }
	    }
	}
	
	public double[][] transpuesta() {
	    double[][] matrizTranspuesta = null;
	    if (this.matrizA != null && this.matrizA.length > 0) {
	        int filasOriginal = this.matrizA.length;
	        int columnasOriginal = this.matrizA[0].length;
	        //matriz con dimensiones INVERTIDAS 
	        matrizTranspuesta = new double[columnasOriginal][filasOriginal];
	        for (int i = 0; i < filasOriginal; i++) {
	            for (int j = 0; j < columnasOriginal; j++) {
	                matrizTranspuesta[j][i] = this.matrizA[i][j];
	            }
	        }
	    }
	    return matrizTranspuesta;
	}
	
	public double[][] multiplicar(double numero){
		double[][] productoMatriz = null;
		if (this.matrizA != null && this.matrizA.length > 0) {
			int filasOriginal = this.matrizA.length;
	        int columnasOriginal = this.matrizA[0].length;
	        productoMatriz = new double [filasOriginal][columnasOriginal];
	        for (int i = 0; i < filasOriginal; i++) {
	        	for (int j = 0; j < columnasOriginal; j++) {
	        		productoMatriz [i][j]= this.matrizA[i][j] * numero;
	        	}
	        }
		}
		return productoMatriz;	
	}
	
	public double[][] multiplicar(double[][] matriz) {
		double[][] productoMatriz = null;
		if (this.matrizA != null && this.matrizA.length > 0 && this.matrizA.length == matriz[0].length) {
			int filasMatrizA = this.matrizA.length;
			//Este es el limite de k que recorre simultáneamente la fila de A y la columna de B.
			int columnasA = this.matrizA[0].length;
			int columnasMatrizB = matriz[0].length;
			productoMatriz = new double[filasMatrizA][columnasMatrizB];
			for (int i = 0; i < filasMatrizA; i++) {
				for (int j = 0; j < columnasMatrizB; j++) {
					for (int k = 0; k < columnasA; k++) {
						//Va multiplicando el primer elemento de la fila por el primero de la columna, luego el segundo por el segundo, y así.
						productoMatriz [i][j] += this.matrizA[i][k] * matriz[k][j];
					}
				}
				
			}
		}
		return productoMatriz;
	}
	
	
	
}
