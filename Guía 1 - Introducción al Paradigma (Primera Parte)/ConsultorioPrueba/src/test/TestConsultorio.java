package test;

import consultorio.Medico;
import consultorio.Paciente;

public class TestConsultorio {

	public static void main(String[] args) {
		
		Medico medico1 = new Medico("Daniel","López","Nutrición");
		Paciente paciente1 = new Paciente("José","Pérez",1.75f,80f);
		Paciente paciente2 = new Paciente("José","Fernández",1.7f,102f);
		String nombreCompleto = paciente1.traerNombreCompleto();
		String nombreCompleto2 = paciente2.traerNombreCompleto();
		float IMC= medico1.calcularIMC(paciente1);
		float IMC2= medico1.calcularIMC(paciente2);
		
		System.out.println("Visita 1:\n");
		System.out.println("Medico: "+medico1.getNombre()+" "+medico1.getApellido());
		System.out.println("Paciente "+nombreCompleto+": IMC "+ IMC);
		System.out.println("Paciente "+nombreCompleto2+": IMC "+ IMC2);
		
		System.out.println(paciente1.equals(paciente2));
	
	}

}
