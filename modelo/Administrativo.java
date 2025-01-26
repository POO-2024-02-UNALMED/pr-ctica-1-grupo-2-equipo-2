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

	//Se asegura de que la contraseña sea correcta
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
	//BUsca si un administrador coincide con el usuario
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
	//Crea un nuevo administrador
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

	public void saludo(){
		System.out.println("Bienvenid@ admin. " + nombre);
	}
	public long getCedula(){return cedula;}
	public long getClave(){return contrasena;}
	public String getNombre(){return nombre;}


}

