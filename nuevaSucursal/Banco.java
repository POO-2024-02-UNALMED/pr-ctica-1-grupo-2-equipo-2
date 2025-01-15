package nuevaSucursal;

import java.util.Scanner;


public class Banco {
	final static private Banco[] bancos = {
			new Banco("Bancolombia", 7, 600000000),
			new Banco("B. Bogotá", 9,1000000000),
			new Banco("Avevillas", 3,200000000),
			new Banco("Davivienda", 5, 500000000)};
	final private String nombre;
	final private int exigencia;
	final private double prestamoMin;
	
	private Banco(String nombre, int exigencia, double prestamoMin) {
		this.nombre = nombre;
		this.exigencia = exigencia;
		this.prestamoMin = prestamoMin;
	}
	
	public String toString() {
		double millones = prestamoMin/1000000;
		return nombre + " pagará como mínimo: $" + millones + "M";
		}
	
	private double aceptar(double solvencia, double deudas) {
		int tolerancia = 10 - exigencia;
		double capacidad = (solvencia - 1) * 10;
		if (deudas >= 10000000 * tolerancia || solvencia < 1.1) {
			return 0;
		}else {
			if (capacidad < exigencia) {
				System.out.println(capacidad);
				System.out.println(exigencia);
				return 0;
			}
		}
		double valorAgregado = prestamoMin * ((capacidad - exigencia)/10);
		return prestamoMin + valorAgregado;
	}
	
	public static double prestamo(double solvencia, double deudas) {
		boolean aceptado = false;
		int eleccion = -1;
		double prestamo = 0;
		while (aceptado == false) {
			int x = 0;
			for (Banco i: bancos) {
				System.out.print(++x + ". ");
				System.out.println(i);	
			}
			System.out.println("Escoja que banco le interesa más");
			Scanner scanner = new Scanner(System.in);
			eleccion = scanner.nextInt();
			if (eleccion <=0 || eleccion > bancos.length) {
				System.out.println("No ha escogido ninguna opción");
				return 0;
			}		
			eleccion -= 1;
			Banco elejido = bancos[eleccion];
			prestamo = elejido.aceptar(solvencia, deudas);
			if (prestamo == 0) {
				System.out.println("Su solicitud no ha sido aceptada");
				System.out.println("Escoja otra opción");
			}else {
				System.out.println("Se la han prestado $" + prestamo/1000000 + "M");
				int anos = 0;
				boolean correcto = false;
				while (correcto == false) {
					System.out.println("Escriba la cantidad de años que desea de préstamo");
					scanner = new Scanner(System.in);
					anos = scanner.nextInt();
					if (anos <= 0 || anos > 10) {
						System.out.println("No se va a aceptar un plazo de esa cantidad de años");
					}else {
						System.out.println("Tendrá que pagar en " + anos + " años");
						correcto = true;
					}
				}
				double interes = prestamo * anos * 0.03;
				Empresa.endeudar(prestamo + interes);
				aceptado = true;
			}
		}
		return prestamo;
	}
}
