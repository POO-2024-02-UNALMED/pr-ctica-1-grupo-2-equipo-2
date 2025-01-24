package modelo;

import baseDatos.DataManager;
import error.Entrada;

import java.io.Serializable;
import java.util.ArrayList;


public class Empresa implements Serializable{
	private static final long serialVersionUID = 1L;
	private static double deudas = 12000000;
	private static double renta = 8000000;
	private static double gastoRecursos;
	private static double gastoSalarios;
	private static double presupuestoTotal;
	private static double presupuestoBruto = 40000000;
	private static double solvencia;
	
	private static void verFinanzas() {
		System.out.println("Deudas crediticias: " + deudas + "\n" +
				"Renta: " + renta + "\n" +
				"Gasto en salarios: " + gastoSalarios + "\n" +
				"Gasto en recursos: " + gastoRecursos + "\n" +
				"Capital bruto: " + presupuestoBruto + "\n" +
				"Capital neto: " + deudas + "\n" +
				"Solvencia: " + solvencia());
	}

	public static void setDeudas() {
		Empresa.deudas = Entrada.input();
	}

	private static void calcularFinanzas(){
	}
	private static double solvencia() {
		double pasivos = deudas + renta + gastoRecursos + gastoSalarios;
		double activos = presupuestoBruto;
		return activos/pasivos;
	}
	
	private static boolean isSolvente() {
		if (solvencia() <= 1.1) {
			return false;
		}else {
			return true;
		}
	}
	
	private static double pedirPrestamo() {
		double presupuesto = Banco.prestamo(solvencia(), deudas);
		return presupuesto;
	}
	
	public static void endeudar(double deuda) {
		deudas += deuda;
		System.out.println("Se han añadido $" + deuda/1000000 + "M a su deuda");
	}

	private static void verSucursales(DataManager dataManager) {
		for (Sucursal sucursal : dataManager.getSucursales()) {
			System.out.println(sucursal);
		}
	}
	public static void menuFinanzas(DataManager dataManager) {
		boolean salir = false;
		while (salir == false) {
			System.out.println("=== Menú Finanzas ===");
			System.out.println("¿Qué acción desea realizar");
			System.out.println("1. Ver finanzas generales");
			System.out.println("2. Calcular finanzas");
			System.out.println("3. Ver sucursales");
			System.out.println("4. Abrir sucursal");
			System.out.println("5. Cerrar sucursal");
			System.out.println("6. Salir");

			int eleccion = Entrada.input();

			switch(eleccion) {
				case 1:
					verFinanzas();
					break;
				case 3:
					verSucursales(dataManager);
					break;
				case 4:
					double presupuesto = pedirPrestamo();
					if(presupuesto == 0){
						System.out.println("No se ha concretado ningún préstamo");
						break;
					}
					Sucursal newSucursal = Barrio.comprarTerreno(presupuesto, dataManager.getSucursales(), dataManager.getCiudad());
					newSucursal.comprarMesas(presupuesto,newSucursal.getEspacio());
					dataManager.addSucursal(newSucursal);
					System.out.println(newSucursal);
					break;
				case 6:
					salir = true;
					break;
				case 7:
					setDeudas();
					break;
				default:
					System.out.println("Opción no disponible");
					break;
			}
		}
	}
}