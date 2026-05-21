package Numeros;

public class Numero {
	private int n;
	
	public Numero(int n) {
		super();
		this.n = n;
	}

	

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	public int sumar(int n1) {
		return this.n + n1;
	}
	
	public int multiplicar(int n1) {
		return this.n * n1;
	}
	
	public boolean esPar() {
		return this.n % 2==0;
	}
	
	public boolean esPrimo() {
	    // 1. Inicializamos con la lógica de que n > 1
	    boolean esPrimo = (this.n > 1); 
	    int divisor = 2;
	    
	    // 2. Usamos la raíz cuadrada como límite 
	    // Si un número no tiene divisores hasta su raíz, no los tendrá después.
	    double limite = Math.sqrt(this.n);

	    // 3. El While controla toda la salida
	    while (esPrimo && divisor <= limite) {
	        if (this.n % divisor == 0) {
	            esPrimo = false; // Al cambiar a false, el while termina solo
	        }
	        divisor++;
	    }

	    return esPrimo;
	}
	
	public String convertirAString() {
		return String.valueOf(this.n);
	}
	
	public double convertirADouble() {
		return Double.parseDouble(this.convertirAString());
	}
	
	public double calcularPotencia(int exp) {
		return Math.pow(this.convertirADouble(), exp);
	}
	
	public int calcularFactorial() {
		return this.calcularFactorial(this.n);		
	}
	
	public int calcularFactorial(int numero) {
	    if (numero < 0) return 1;
	    
	    int fact = 1;
	    for (int i = 1; i <= numero; i++) {
	        fact *= i;
	    }
	    return fact;
	}
	
	public int numeroCombinatorio(int n1) {
		if(this.n>0 && n1>0 && this.n>n1) {
			return this.calcularFactorial() / (this.calcularFactorial(n1)*this.calcularFactorial(this.n-n1));
		}
		return 0;
	}
	
}