package modelo;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public class Ceta {
	private int idCeta;
	private GregorianCalendar fecha;
	private Contribuyente vendedor;
	private Contribuyente comprador;
	private double ValorDeTransferencia;
	private boolean firmaDelComprador;
	
	public Ceta(int idCeta, GregorianCalendar fecha, Contribuyente vendedor, Contribuyente comprador,
			double valorDeTransferencia, boolean firmaDelComprador) {
		super();
		this.idCeta = idCeta;
		setFecha(fecha);
		this.vendedor = vendedor;
		setComprador(comprador);
		ValorDeTransferencia = valorDeTransferencia;
		this.firmaDelComprador = firmaDelComprador;
	}
	
	public int getIdCeta() {
		return idCeta;
	}

	public void setIdCeta(int idCeta) {
		this.idCeta = idCeta;
	}

	public GregorianCalendar getGregorianCalendar() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		if(!validarFecha(fecha)){
			throw new IllegalArgumentException("Error: la fecha no puede ser posterior al día de hoy");
		}
		this.fecha = fecha;
	}

	public Contribuyente getVendedor() {
		
		return vendedor;
	}

	public void setVendedor(Contribuyente vendedor) {
		this.vendedor = vendedor;
	}

	public Contribuyente getComprador() {
		return comprador;
	}

	public void setComprador(Contribuyente comprador) {
		if(comprador == vendedor) {
			throw new IllegalArgumentException("Error: el vendedor y el comprador son el mismo");
		}
		this.comprador = comprador;
	}

	public double getValorDeTransferencia() {
		return ValorDeTransferencia;
	}

	public void setValorDeTransferencia(double valorDeTransferencia) {
		ValorDeTransferencia = valorDeTransferencia;
	}

	public boolean isFirmaDelComprador() {
		return firmaDelComprador;
	}

	public void setFirmaDelComprador(boolean firmaDelComprador) {
		this.firmaDelComprador = firmaDelComprador;
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
	
	public boolean validarFecha(GregorianCalendar fecha) {
        GregorianCalendar hoy = new GregorianCalendar();        
        return !fecha.after(hoy);
    }
	
	
	
}
