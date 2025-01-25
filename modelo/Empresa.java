package modelo;

import baseDatos.DataManager;
import error.Entrada;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;


public class Empresa implements Serializable{
	private static double deudas = 12000000;
	private static double renta = 1000000;
	private static double gastoRecursos = 15000000;
	private static double gastoSalarios;
	private static double presupuestoTotal;
	private static double presupuestoBruto = 40000000;
	private static double solvencia;
	
	private static void verFinanzas() {
		System.out.println("Deudas crediticias: " + deudas/1000000 + "M\n" +
				"Renta: $" + Math.round(renta/1000000) + "M\n" +
				"Gasto en salarios: $" + Math.round(gastoSalarios/1000000) + "M\n" +
				"Gasto en recursos: $" + Math.round(gastoRecursos/1000000) + "M\n" +
				"Capital bruto: $" + Math.round(presupuestoBruto/1000000) + "M\n" +
				"Capital neto: $" + Math.round(presupuestoTotal/1000000) + "M\n" +
				"Solvencia: $" + String.format("%.2f",solvencia()));
	}


	public static void setDeudas() {
		Empresa.deudas = 10000000;
	}

	private static void calcularFinanzas(DataManager dataManager){
		List<Sucursal> sucursales = dataManager.getSucursales();
		renta = 10000000 * sucursales.size();
		gastoSalarios = 0;
		gastoRecursos = 0;
		presupuestoBruto = 0;
		for (Sucursal sucursal: sucursales){
			for(Empleado empleado: sucursal.getEmpleado()){
				if(empleado == null){continue;}
				gastoSalarios += empleado.getSueldo() * 12;
			}
			for(Mesero mesero: sucursal.getMeseros()){
				if(mesero == null){continue;}
				gastoSalarios += mesero.getSueldo() * 12;
			}
			gastoRecursos += sucursal.getGastoRecursos();
			presupuestoBruto += sucursal.getPresupuesto();
		}
		for(Repartidor repartidor: dataManager.getRepartidores()) {
			gastoSalarios += 1000000 + (1000000 * (repartidor.getCalificacionPromedio() / 100));
		}
		presupuestoTotal = presupuestoBruto - renta - gastoRecursos;
	}
	private static double solvencia() {
		double pasivos = deudas + renta + gastoRecursos;
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

	private static void pagarDeuda(DataManager dataManager){
		double paga = 0;
		for(Sucursal sucursal: dataManager.getSucursales()){
			if(sucursal.getPresupuesto() - 20000000 < 40000000){continue;}
			paga += 20000000;
			sucursal.restarPresupuesto(20000000);
		}
		if(paga == 0) {
			System.out.println("No tenemos los suficeintes fondos para empezar a pagar");
			return;
		}
		deudas -= paga;
		System.out.println("Se han pagado $" + paga/1000000 + "M de la deuda");
	}
	
	public static void endeudar(double deuda) {
		deudas += deuda;
		System.out.println("Se han añadido $" + Math.round(deuda/1000000) + "M a su deuda");
	}

	private static void verSucursales(DataManager dataManager) {
		for (Sucursal sucursal : dataManager.getSucursales()) {
			System.out.println(sucursal);
		}
	}
	public static void menuFinanzas(DataManager dataManager) {
		boolean salir = false;
		while (!salir) {
			calcularFinanzas(dataManager);
			System.out.println("=== Menú Finanzas ===");
			System.out.println("¿Qué acción desea realizar");
			System.out.println("1. Ver finanzas generales");
			System.out.println("2. Ver sucursales");
			System.out.println("3. Abrir sucursal");
			System.out.println("4. Cerrar sucursal");
			System.out.println("5. Salir");

			int eleccion = Entrada.input();

			switch(eleccion) {
				case 1:
					verFinanzas();
					break;
				case 2:
					verSucursales(dataManager);
					break;
				case 3:
					double presupuesto = pedirPrestamo();
					if(presupuesto == 0){
						System.out.println("No se ha concretado ningún préstamo");
						break;
					}
					Sucursal newSucursal = Barrio.comprarTerreno(presupuesto, dataManager.getSucursales(), dataManager.getCiudad());
					newSucursal.comprarMesas(presupuesto,newSucursal.getEspacio());
					for(int i = 0; i < 5; i++){
						boolean correcto = false;
						while(!correcto){
							int cedula = Empleado.generarDocumento();
							correcto = dataManager.explorar(cedula);
							newSucursal.autoEmpleado(i,cedula);
						}

					}
					dataManager.addSucursal(newSucursal);
					Administrativo.nuevoAdmin(dataManager);
					System.out.println(newSucursal);
					break;
				case 4:
					Sucursal.cerrar(dataManager);
					break;
				case 5:
					salir = true;
					break;
				case 6:
					dataManager.quitarSucursal();
				default:
					System.out.println("Opción no disponible");
					break;
			}
		}
	}
}