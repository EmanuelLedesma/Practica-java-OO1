package test;

import java.time.LocalDate;
import java.util.List;

import modelo.*;

public class testSistemaInventario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1)");
		
		Sistema s = new Sistema();
		s.agregarCategoria("Bebidas");
		s.agregarCategoria("Almacen");
		s.agregarCategoria("Decoracion");
		
		for(Categoria o:s.getLstCategorias()) {
			System.out.println(o);
		}
		System.out.println("\n");
		
		//-----------------------------------------
		Categoria bebidas = s.traerCategoria("Bebidas");
        Categoria almacen = s.traerCategoria("Almacen");
        Categoria decoracion = s.traerCategoria("Decoracion");

        s.agregarProductoPerecedero(1001, "Yogurt", 900.0f, bebidas, 0, LocalDate.of(2024, 10, 20), true);
        s.agregarProductoPerecedero(1002, "Agua", 1000.0f, bebidas, 0, LocalDate.of(2024, 11, 20), false);
        s.agregarProductoPerecedero(2001, "Arroz", 1000.0f, almacen, 0, LocalDate.of(2025, 1, 1), false);
        s.agregarProductoPerecedero(3001, "Pegamento", 8000.0f, decoracion, 0, LocalDate.of(2024, 10, 18), false);
        
        s.agregarProductoNoPerecedero(3002, "Lija", 250.0f, decoracion, 0, 0, 6);
        s.agregarProductoNoPerecedero(3003, "Martillo", 600.0f, decoracion, 0, 0, 12);
        
        
        System.out.println("\n--- 2) AGREGAR E IMPRIMIR PRODUCTOS ---");
        for(Producto p : s.getLstProductos()) {
     	   System.out.println(p);
        }
        System.out.println("\n--- 3) AGREGAR E IMPRIMIR MOVIMIENTOS ---");
        // //COMPRAS
    s.agregarMovimientoInventario(s.traerProducto(1001), LocalDate.of(2024, 10, 10), 50);
    s.agregarMovimientoInventario(s.traerProducto(1002), LocalDate.of(2024, 10, 10), 30);
    s.agregarMovimientoInventario(s.traerProducto(2001), LocalDate.of(2024, 10, 10), 80);
    s.agregarMovimientoInventario(s.traerProducto(3001), LocalDate.of(2024, 10, 10), 40);
    s.agregarMovimientoInventario(s.traerProducto(3002), LocalDate.of(2024, 10, 10), 11);
    s.agregarMovimientoInventario(s.traerProducto(3003), LocalDate.of(2024, 10, 10), 40);

        // //VENTAS
    s.agregarMovimientoInventario(s.traerProducto(1001), LocalDate.of(2024, 10, 13), -10);
    s.agregarMovimientoInventario(s.traerProducto(1002), LocalDate.of(2024, 10, 13), -4);
    s.agregarMovimientoInventario(s.traerProducto(3002), LocalDate.of(2024, 10, 13), -3);
    
    for(MovimientoInventario m : s.getLstMovimientos()) {
 	   System.out.println(m);
    }
    
    System.out.println("\n--- 3.2) VENTAS ENTRE 2 FECHAS ---");
    List<MovimientoInventario> ventas = s.traerVentas(LocalDate.of(2024, 10, 13), LocalDate.of(2024, 10, 13));
    for(MovimientoInventario m : ventas) {
        System.out.println(m);
    }
    
    System.out.println("4");
    List<MovimientoInventario> ventasRefrigerados = s.traerVentasRefrigerado(LocalDate.of(2024, 10, 13));
    for(MovimientoInventario m : ventasRefrigerados) {
        System.out.println(m);
    }
    
    System.out.println("5");
    List<Producto> reabastecer = s.traerProductosAReabastecer(decoracion);
    for(Producto o : reabastecer) {
    	System.out.println(o);
    }
    
    try {
    	s.agregarProductoPerecedero(1001, "Yogurt", 900.0f, bebidas, 0, LocalDate.of(2024, 10, 20), true);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
    
    try {
    	s.agregarMovimientoInventario(s.traerProducto(3003), LocalDate.of(2024, 10, 10), -50);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}

    
	}
	
	

	
	
	
}
