package test;
import modelo.Supermercado;
import modelo.Producto;
import modelo.Carrito;
import modelo.Cliente;
import modelo.ItemCarrito; // Asegurate de tener este import si usás la lista
import java.time.LocalDate;
import java.time.LocalTime;


public class TestSupermercado1 {

	public static void main(String[] args) {
		
		
		Supermercado coto = new Supermercado();

        System.out.println("==================================================");
        System.out.println("    TEST AUTOMATIZADO - MÉTODOS CRÍTICOS NIVEL 2  ");
        System.out.println("==================================================");

        // ----------------------------------------------------------------------
        // SETUP: Preparación rápida de la base de datos (Productos y Clientes)
        // ----------------------------------------------------------------------
        System.out.println("\n[SETUP] Iniciando carga de datos base...");
        try {
            // 5 Productos requeridos
            coto.agregarProducto("Leche Sachet", 1200.50f);
            coto.agregarProducto("Pan Lactal", 1800.00f);
            coto.agregarProducto("Docena de Huevos", 2500.00f);
            coto.agregarProducto("Café Molido", 4500.75f);
            coto.agregarProducto("Azúcar Blanca", 1100.00f);

            // Clientes
            coto.agregarCliente("Juan Perez", 30123456, "Calle Falsa 123");
            coto.agregarCliente("Maria Gomez", 40123456, "Av. Siempre Viva 742");
            
            System.out.println("[SETUP] 5 Productos y 2 Clientes cargados con éxito.");
            
        } catch (Exception e) {
            System.out.println("Error en el Setup: " + e.getMessage());
        }

        // ----------------------------------------------------------------------
        // TEST A: Excepciones de Alta (Validación de Reglas de Negocio)
        // ----------------------------------------------------------------------
        System.out.println("\n---> TEST A: Forzar Excepciones en Altas (Clientes)");
        try {
            System.out.println("Intentando agregar a 'Juan Perez' nuevamente...");
            coto.agregarCliente("Juan Perez", 30123456, "Otra Calle 999");
            System.out.println("❌ ERROR: El sistema permitió el duplicado.");
        } catch (Exception e) {
            System.out.println("✅ Excepción atrapada correctamente: " + e.getMessage());
        }

        // ----------------------------------------------------------------------
        // SETUP DE COMPRAS: Simulando historial para los filtros de fechas
        // ----------------------------------------------------------------------
        System.out.println("\n[SETUP] Generando historial de compras...");
        try {
            Cliente juan = coto.traerCliente(1);
            Cliente maria = coto.traerCliente(2);

            // Carrito 1: Juan en ENERO
            LocalDate fechaEnero = LocalDate.of(2024, 1, 15);
            coto.agregarCarrito(fechaEnero, LocalTime.now(), juan);
            Carrito car1 = coto.traerCarrito(1);
            car1.agregarItem(coto.traerProducto(1), 2); // 2 Leches ($2401.0)
            car1.agregarItem(coto.traerProducto(2), 1); // 1 Pan ($1800.0) -> Total: $4201.0

            // Carrito 2: Juan en FEBRERO
            LocalDate fechaFebrero = LocalDate.of(2024, 2, 10);
            coto.agregarCarrito(fechaFebrero, LocalTime.now(), juan);
            Carrito car2 = coto.traerCarrito(2);
            car2.agregarItem(coto.traerProducto(4), 1); // 1 Café -> Total: $4500.75

            // Carrito 3: Maria en ENERO
            
            coto.agregarCarrito(fechaEnero, LocalTime.now(), maria);
            Carrito car3 = coto.traerCarrito(3);
            car3.agregarItem(coto.traerProducto(3), 1); // 1 Huevos -> Total: $2500.0

            System.out.println("[SETUP] Historial de compras generado con éxito.");

        } catch (Exception e) {
            System.out.println("Error armando carritos: " + e.getMessage());
        }

        // ----------------------------------------------------------------------
        // TEST B: Totales por Rango de Fechas
        // ----------------------------------------------------------------------
        System.out.println("\n---> TEST B: calcularTotal(fechaInicio, fechaFin)");
        try {
            LocalDate inicio = LocalDate.of(2024, 1, 1);
            LocalDate fin = LocalDate.of(2024, 1, 31);
            
            float totalEnero = coto.calcularTotal(inicio, fin);
            System.out.println("Facturación TOTAL de Enero (Esperado aprox $6701.0): $" + totalEnero);
        } catch (Exception e) {
            System.out.println("Excepción inesperada: " + e.getMessage());
        }

        // ----------------------------------------------------------------------
        // TEST C: Totales por Mes, Año y Cliente (El método más complejo)
        // ----------------------------------------------------------------------
        System.out.println("\n---> TEST C: calcularTotal(mes, anio, idCliente)");
        try {
            // Buscamos las compras de Juan (ID 1) en Enero (Mes 1)
            float totalJuanEnero = coto.calcularTotal(1, 2024, 1);
            System.out.println("Gastos de Juan en Enero (Esperado $4201.0): $" + totalJuanEnero);
            
            // Buscamos las compras de Juan (ID 1) en Febrero (Mes 2)
            float totalJuanFebrero = coto.calcularTotal(2, 2024, 1);
            System.out.println("Gastos de Juan en Febrero (Esperado $4500.75): $" + totalJuanFebrero);

        } catch (Exception e) {
            System.out.println("Excepción inesperada: " + e.getMessage());
        }

        // ----------------------------------------------------------------------
        // TEST D: Validaciones de Excepciones Críticas (Mes inválido y Cliente falso)
        // ----------------------------------------------------------------------
        System.out.println("\n---> TEST D1: Excepción por Mes Inválido [Requerimiento 18 & 21]");
        try {
            System.out.println("Intentando calcular total del mes 15...");
            coto.calcularTotal(15, 2024, 1); // Forzamos mes inválido
            System.out.println("❌ ERROR: El sistema permitió un mes incorrecto.");
        } catch (Exception e) {
            System.out.println("✅ Excepción atrapada correctamente: " + e.getMessage());
        }

        System.out.println("\n---> TEST D2: Excepción por Cliente Inexistente [Requerimiento 22]");
        try {
            System.out.println("Intentando calcular total del cliente ID 99...");
            coto.calcularTotal(1, 2024, 99); // Forzamos cliente inexistente
            System.out.println("❌ ERROR: El sistema procesó un cliente falso.");
        } catch (Exception e) {
            System.out.println("✅ Excepción atrapada correctamente: " + e.getMessage());
        }

        System.out.println("\n==================================================");
        System.out.println("                 FIN DE LOS TEST                  ");
        System.out.println("==================================================");
		
        
        for(Cliente c : coto.getLstCliente()){
        	System.out.println(c.getNombreCliente());
        }
		
	}
}
