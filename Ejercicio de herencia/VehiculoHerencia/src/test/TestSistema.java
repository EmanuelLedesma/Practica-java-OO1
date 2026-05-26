package test;
import java.util.List;

import modelo.*;

public class TestSistema {

	public static void main(String[] args) {
		Sistema sistema = new Sistema();

        System.out.println("==================================================");
        System.out.println("       INICIANDO TESTS DE HERENCIA Y CONSUMO      ");
        System.out.println("==================================================\n");

        System.out.println("--- 1. ALTA DE VEHÍCULOS (Polimorfismo) ---");
        try {
            // Auto normal
            sistema.agregarAuto("Toyota", "Corolla", 2020, 4, 0.5, 4);
            System.out.println("✅ Auto agregado.");
            
            // Moto normal
            sistema.agregarMoto("Honda", "Titan", 2022, 2, 0.3, false, false);
            System.out.println("✅ Moto básica agregada.");
            
            // Moto con caja (+0.03 ineficiencia)
            sistema.agregarMoto("Zanella", "Cargo", 2019, 3, 0.4, true, false);
            System.out.println("✅ Moto con caja agregada.");
            
            // Moto aerodinámica (-0.05 ineficiencia)
            sistema.agregarMoto("Yamaha", "CBR", 2023, 2, 0.2, false, true);
            System.out.println("✅ Moto aerodinámica agregada.");
            
            // Moto con caja y aerodinámica (combinación: +0.03 -0.05)
            sistema.agregarMoto("BMW", "R1200", 2021, 2, 0.6, true, true);
            System.out.println("✅ Moto combinada agregada.");

            // Prueba de Sad Path: Eficiencia fuera de rango (0.1 a 0.9)
            System.out.println("\nIntento agregar vehículo con eficiencia inválida...");
            sistema.agregarAuto("Ford", "Fiesta", 2018, 4, 1.5, 5); 
        } catch (Exception e) {
            System.out.println("✅ Excepción atrapada correctamente: " + e.getMessage());
        }

        System.out.println("\n--- 2. BÚSQUEDA Y ANTIGÜEDAD ---");
        try {
            Vehiculo auto = sistema.traerVehiculo("Toyota", "Corolla");
            System.out.println(auto.toString());
            System.out.println("Antigüedad calculada: " + auto.aniosAntiguedad() + " años.");
        } catch (Exception e) {
             System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- 3. CÁLCULO DE CONSUMO (Para 100 km) ---");
        try {
            // Auto: 100 * 0.5 = 50.0
            Vehiculo v1 = sistema.traerVehiculo("Toyota", "Corolla");
            System.out.println("Consumo Corolla (Esperado 50.0): " + v1.calcularConsumo(100));

            // Moto Caja: 100 * (0.4 + 0.03) = 43.0
            Vehiculo v2 = sistema.traerVehiculo("Zanella", "Cargo");
            System.out.println("Consumo Moto Caja (Esperado ~43.0): " + v2.calcularConsumo(100));

            // Moto Aero: 100 * (0.2 - 0.05) = 15.0
            Vehiculo v3 = sistema.traerVehiculo("Yamaha", "CBR");
            System.out.println("Consumo Moto Aero (Esperado ~15.0): " + v3.calcularConsumo(100));

            // Moto Ambas: 100 * (0.6 + 0.03 - 0.05) = 58.0
            Vehiculo v4 = sistema.traerVehiculo("BMW", "R1200");
            System.out.println("Consumo Moto Ambas (Esperado ~58.0): " + v4.calcularConsumo(100));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- 4. VEHÍCULOS DE TRANSPORTE ---");
        // Debería traer todos los autos y solo las motos con caja
        try {
            List<Vehiculo> transportes = sistema.traerVehiculosDeTransporte();
            for (Vehiculo v : transportes) {
                System.out.println(v.toString());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- 5. VEHÍCULOS POR CONSUMO (Tope: 45.0 para 100 km) ---");
        // Debería traer solo la Moto Caja (43.0) y la Moto Aero (15.0)
        try {
            List<Vehiculo> eficientes = sistema.traerVehiculosPorConsumo(100, 45.0);
            for (Vehiculo v : eficientes) {
                System.out.println(v.toString());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("\n==================================================");
        System.out.println("                 FIN DE LOS TESTS                 ");
        System.out.println("==================================================");
    }
}


