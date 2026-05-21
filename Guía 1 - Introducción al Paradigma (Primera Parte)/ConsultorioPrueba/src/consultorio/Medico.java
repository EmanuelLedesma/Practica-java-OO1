package consultorio;

public class Medico {
	
	public Medico(String nombre, String apellido, String especialidad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
	}
	private String nombre;
	private String apellido;
	private String especialidad;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	public float calcularIMC(Paciente paciente) {
		float peso= paciente.getPeso();
		float estatura = paciente.getEstatura();
		float IMC = peso/(estatura*estatura);
		return IMC;
	}
	
	
}
