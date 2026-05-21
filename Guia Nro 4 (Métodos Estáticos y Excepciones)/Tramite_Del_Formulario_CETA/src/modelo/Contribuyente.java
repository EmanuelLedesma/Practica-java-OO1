package modelo;

public class Contribuyente {
	private String apellido;
	private String nombre;
	private long dni;
	private char sexo;
	private String cuil;
	
	
	public Contribuyente(int idContribuyente, String apellido, String nombre, long dni, char sexo, String cuil) {
		super();
		this.idContribuyente = idContribuyente;
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		setSexo(sexo);
		setCuil(cuil);
		
	}
	
	public int getIdContribuyente() {
		return idContribuyente;
	}


	public void setIdContribuyente(int idContribuyente) {
		this.idContribuyente = idContribuyente;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public long getDni() {
		return dni;
	}


	public void setDni(long dni) {
		this.dni = dni;
	}


	public char getSexo() {
		return sexo;
	}


	public void setSexo(char sexo) {
		if (!validarSexo(sexo)){
		}
		this.sexo = sexo;
	}


	public String getCuil() {
		return cuil;
	}


	public void setCuil(String cuil) {
		if(!validarCuil(cuil)){
			throw new IllegalArgumentException("Error: Cuil Invalido");
		}
		this.cuil = cuil;
	}
	
	private int idContribuyente;
	@Override
	public String toString() {
		return "Contribuyente [idContribuyente=" + idContribuyente + ", apellido=" + apellido + ", nombre=" + nombre
				+ ", dni=" + dni + ", sexo=" + sexo + ", cuil=" + cuil + "]";
	}
	
	public boolean validarSexo(char sexo) {
		char sexoNormalizado = Character.toLowerCase(sexo);
	    return (sexoNormalizado == 'm' || sexoNormalizado == 'f');
	}
	
	public boolean validarCuil(String cuil){
		int resto = 0;
		int z = -1;
		boolean esValido = false;
		if(cuil!= null && Funciones.esCadenaNros(cuil) && cuil.length() == 11) {
			int suma = 0;
			int [] multiplicadores = {5,4,3,2,7,6,5,4,3,2};
			
			for(int i = 0; i<10; i++) {
				int digito = Character.getNumericValue(cuil.charAt(i));
				suma += digito * multiplicadores[i];
			}
			resto = suma % 11;
		}
		
		int zOriginal = Character.getNumericValue(cuil.charAt(10));
		
		if (resto == 0) {
            z = 0;
        } else if (resto == 1) {

            String xy = cuil.substring(0, 2);
            if (xy.equals("23") && (zOriginal == 9 || zOriginal == 4)) {
                z = zOriginal; 
            }
        } else {
            
            z = 11 - resto; 
        }
		
		if(z == zOriginal) {
			esValido = true;
		}
		
		return esValido;
	}
	

	
	
}
