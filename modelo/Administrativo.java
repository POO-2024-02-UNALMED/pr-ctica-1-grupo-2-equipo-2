package modelo;


import baseDatos.DataManager;
import error.Entrada;
import java.util.List;
import java.io.Serializable;



public class Administrativo implements  Serializable{
	
	private static final long serialVersionUID = 1L;
	private long contrasena;
	private String nombre;
	private long cedula;

	public Administrativo(String nombre, long cedula, long clave){
		this.nombre = nombre;
		this.cedula = cedula;
		this.contrasena = clave;
	}

	
	private boolean verificarCodigo() {
		long clave = Entrada.input();
		int i = 0;
		while (i < 3) {
			if (clave == contrasena) {
				return true;
			}else {
				System.out.println("Contraseña incorrecta");
				System.out.println("Igrésela nuevamente");
				clave = Entrada.input();
				i ++;
			}
		}
		System.out.println("Demasiados intentos");
		System.out.println("usted está siendo rastreado por suplantación de identidad");
		return false;
	}
	
	public static boolean verificarAdmin(long cedula, DataManager dataManager) {
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

	public static void nuevoAdmin(DataManager dataManager){
		boolean correcto = false;
		int id = 0;
		while(!correcto){
			id = Empleado.generarDocumento();
			correcto = dataManager.explorar(id);
		}
		System.out.println("Ingrese la clave que se le asignará al nuevo administrador");
		int clave = Entrada.input();
		Administrativo admin = new Administrativo(Empleado.generarNombre(),id,clave);
		dataManager.getAdmins().add(admin);
		System.out.println("El nuevo puesto de administrativo es para " + admin.nombre);
		System.out.println("no olvide la información");
		System.out.println("Cédula: " + admin.cedula);
		System.out.println("Contraseña: " + admin.contrasena);
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

