package modelo;

import error.Entrada;

public class Banco {
	final static private Banco[] bancos = {
			new Banco("Bancolombia", 7, 900000000),
			new Banco("B. Bogotá", 9,1300000000),
			new Banco("Avevillas", 3,400000000),
			new Banco("Davivienda", 5, 700000000)};
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

	private static double calcularPrestamo(double solvencia, double prestamo) {
		solvencia -= 1;
		double recargo = solvencia*10;
		int i;
		for(i = 0; i < recargo; i++) {}
		while (recargo > solvencia) {
			double x = Math.random()*i+1;
			x = Math.round(x);
			x /= 10;
			recargo = x;

		}
		return prestamo * recargo;
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
			eleccion = Entrada.input();
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
				prestamo += calcularPrestamo(solvencia, prestamo);
				prestamo = Math.round(prestamo);
				System.out.println("Se la han prestado $" + prestamo/1000000 + "M");
				int anos = 0;
				boolean correcto = false;
				while (correcto == false) {
					System.out.println("Escriba la cantidad de años que desea de préstamo");
					anos = Entrada.input();
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
