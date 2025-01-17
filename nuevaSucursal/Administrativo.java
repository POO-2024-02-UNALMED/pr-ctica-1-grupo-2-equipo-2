package nuevaSucursal;

import java.util.Scanner;


public class Administrativo {

	private static Administrativo[] admins = null;
	private long contrasena;
	private String nombre;
	private long cedula;

	private Administrativo(String nombre, long cedula, long clave){
		this.nombre = nombre;
		this.cedula = cedula;
		this.contrasena = clave;
		if (admins == null) {
			admins = new Administrativo[1];
			admins[0] = this;
		}else {
			int cantidad = admins.length;
			Administrativo[] adicion = new Administrativo[cantidad + 1];
			for (int i = 0; i == cantidad-1; i++) {
				adicion[i] = admins[i];
			}
			adicion[cantidad] = this;
		}
	}

	static {new Administrativo("Pepito", 12345, 4488123);}
	
	private boolean verificarCodigo() {
		Scanner scanner = new Scanner(System.in);
		long clave = scanner.nextLong();
		int i = 0;
		while (i < 3) {
			if (clave == contrasena) {
				return true;
			}else {
				System.out.println("Contraseña incorrecta");
				System.out.println("Igrésela nuevamente");
				scanner = new Scanner(System.in);
				clave = scanner.nextLong();
				i ++;
			}
		}
		System.out.println("Demasiados intentos");
		System.out.println("usted está siendo rastreado por suplantación de identidad");
		return false;
	}
	
	public static boolean verificarAdmin(long cedula) {
		Scanner scanner;
		Administrativo tu = null;
		for (Administrativo i: admins) {
			if (i.cedula == cedula) {
				tu = i;
				break;
			}else {
				System.out.println("Ese documento no está registrado como administrador");
				return false;
			}
		}
		System.out.println("Ingrese su código de seguridad");
		if (tu.verificarCodigo()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static Administrativo getAdmin(long cedula) {
		for (Administrativo i: admins) {
			if (i.cedula == cedula) {
				return i;
			}
		}
		return null;
	}


	
	public void menuAdmin() {
		System.out.println("Bienvenid@ admin. " + nombre);
		boolean salir = false;
		int eleccion;
		while (salir == false) {
			System.out.println("Elija la acción que desea realizar");
			System.out.println("1. Ver recursos humanos");
			System.out.println("2. Ver finanzas");
			System.out.println("3. Salir");
			Scanner scanner = new Scanner(System.in);
			eleccion = scanner.nextInt();
			switch(eleccion) {
			case 2:
				Empresa.menuFinanzas();
				break;
			case 3:
				salir = true;
				System.out.println("Sesión cerrada");
				break;
			default:
				System.out.println("Opción no disponible");
				break;
			}
		}
		return;
	}
}
