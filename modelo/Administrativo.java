package modelo;

import java.util.Scanner;
import baseDatos.DataManager;
import java.util.List;
import java.util.InputMismatchException;


public class Administrativo {

	private long contrasena;
	private String nombre;
	private long cedula;

	public Administrativo(String nombre, long cedula, long clave){
		this.nombre = nombre;
		this.cedula = cedula;
		this.contrasena = clave;
	}

	
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
	
	public static boolean verificarAdmin(long cedula, DataManager dataManager) {
		Scanner scanner;
		Administrativo tu = null;
		List<Administrativo> admins = dataManager.getAdmins();
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
	
	public static Administrativo getAdmin(long cedula, DataManager dataManager) {

		List<Administrativo> admins = dataManager.getAdmins();
		for (Administrativo i: admins) {
			if (i.cedula == cedula) {
				return i;
			}
		}
		return null;
	}


	/*
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
*/
	public void saludo(){
		System.out.println("Bienvenid@ admin. " + nombre);
	}
	public long getCedula(){return cedula;}
	public long getClave(){return contrasena;}
	public String getNombre(){return nombre;}
}

