package test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.*;

public class testPersona {
    public static void main(String[] args) {
        // 1. Creamos una lista polimórfica de tipo Persona
        List<Persona> personas = new ArrayList<>();

        // 2. Agregamos objetos de distintas subclases
        personas.add(new Empleado("Beltran", "Briones", 46198922, LocalDate.of(2005, 1, 12), 123456789, 500f));
        personas.add(new Cliente("Beltrane", "Brionese", 46198921, LocalDate.of(2005, 1, 13), "20-982389-83", 10000f));

        // 3. Recorremos la lista usando Pattern Matching for instanceof
        for (Persona p : personas) {
            System.out.println("--- Procesando a: " + p.getNombre() + " ---");
            
            // Método común de la superclase
            System.out.println("Edad actual: " + p.calcularEdad(LocalDate.now()));

            // Pattern Matching: Java verifica el tipo y asigna la variable en un solo paso
            if (p instanceof Empleado emp) {
                // 'emp' ya es de tipo Empleado, no hace falta castear
                System.out.println("Sueldo calculado: $" + emp.calcularSueldo(0));
            } 
            else if (p instanceof Cliente cli) {
                // 'cli' ya es de tipo Cliente, no hace falta castear
                System.out.println("Acción cliente: " + cli.hablar());
                System.out.println("Estado crédito: " + cli.estadoCredito());
            }
            System.out.println(); // Salto de línea para limpieza visual
        }
    }
}