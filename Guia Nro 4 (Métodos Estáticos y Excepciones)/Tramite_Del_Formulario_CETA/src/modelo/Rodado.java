package modelo;

public class Rodado {

	private int idRodado;
	private String dominio;
	private int modelo;
	private String marca;
	
	public Rodado(int idRodado, String dominio, int modelo, String marca) {
		super();
		this.idRodado = idRodado;
		this.dominio = dominio;
		this.modelo = modelo;
		this.marca = marca;
	}
	
	@Override
	public String toString() {
		return "Ceta [idRodado=" + idRodado + ", dominio=" + dominio + ", modelo=" + modelo + ", marca=" + marca + "]";
	}
	public int getIdRodado() {
		return idRodado;
	}
	public void setIdRodado(int idRodado) {
		this.idRodado = idRodado;
	}
	public String getDominio() {
		return dominio;
	}
	
	public void setDominio(String dominio) {
		if(!validarDominio(dominio)) {
			throw new IllegalArgumentException("Error: Dominio invalido");
		}
		this.dominio = dominio;
	}
	
	public int getModelo() {
		return modelo;
	}
	public void setModelo(int modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public static boolean validarDominio(String dominio) {
	    boolean esValido = false;

	    // 1. Validamos que no sea nulo antes de hacer cualquier cosa
	    if (dominio != null) {
	        
	        // 2. Evaluamos el Formato Viejo (Ej: ABC123)
	        if (dominio.length() == 6) {
	            String letras = dominio.substring(0, 3);   // Corta las posiciones 0, 1, 2
	            String numeros = dominio.substring(3, 6);  // Corta las posiciones 3, 4, 5
	            
	            if (Funciones.esCandenaLetras(letras) && Funciones.esCadenaNros(numeros)) {
	                esValido = true;
	            }
	        } 
	        // 3. Evaluamos el Formato Nuevo (Ej: AB123CD)
	        else if (dominio.length() == 7) {
	            String letras1 = dominio.substring(0, 2);  // Corta las posiciones 0, 1
	            String numeros = dominio.substring(2, 5);  // Corta las posiciones 2, 3, 4
	            String letras2 = dominio.substring(5, 7);  // Corta las posiciones 5, 6
	            
	            if (Funciones.esCandenaLetras(letras1) && Funciones.esCadenaNros(numeros) && Funciones.esCandenaLetras(letras2)) {
	                esValido = true;
	            }
	        }
	    }

	    return esValido;
	}
	


}
