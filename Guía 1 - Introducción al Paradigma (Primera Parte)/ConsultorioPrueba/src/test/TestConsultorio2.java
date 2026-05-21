package test;

import consultorio.Medico;
import consultorio.Paciente;
public class TestConsultorio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Medico medico1 = new Medico("Daniel","López","Nutrición");
		Paciente paciente1 = new Paciente("José","Pérez",1.75f,80f);
		Paciente paciente2 = new Paciente("José","Fernández",1.7f,102f);
		String nombreCompleto = paciente1.traerNombreCompleto();
		String nombreCompleto2 = paciente2.traerNombreCompleto();
		paciente1.setEstatura(1.65f);
		paciente1.setPeso(69f);
		paciente2.setEstatura(1.70f);
		paciente2.setPeso(64f);
		float IMC= medico1.calcularIMC(paciente1);
		float IMC2= medico1.calcularIMC(paciente2);
		
		System.out.println("Visita 2:\n");
		System.out.println("Medico: "+medico1.getNombre()+" "+medico1.getApellido());
		System.out.println("Paciente "+nombreCompleto+": IMC "+ IMC);
		System.out.println("Paciente "+nombreCompleto2+": IMC "+ IMC2);
	}

}
