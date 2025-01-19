package modelo;

import java.util.ArrayList;
import java.util.Scanner;
import ordenFisica.Ingrediente;
import java.util.List;

public class Sucursal {
	private int id;
	private String ubicacion;
	private int presupuesto;
	private Ingrediente[] inventario;
	private Empleado[] empleados;
    private Mesero[] meseros;
    private Mesa[] mesas;
    private int[] direccion;
	
	
	public Sucursal(int id, String ubicacion,int presupuesto,Ingrediente[] inventario,Empleado[] empleados) {
		this.id=id;
		this.ubicacion=ubicacion;
		this.presupuesto=presupuesto;
		this.inventario=inventario;
		this.empleados=empleados;
	}
    public int getId() {
        return id;
    }

    public Sucursal(int id, String nombre, int cantidad, int[] direccion){
        this.id = id;
        this.ubicacion = nombre;
        this.mesas = new Mesa[cantidad];
        this.meseros = new Mesero[cantidad];
        this.direccion = direccion;
    }

    public static void comprarTerreno(double presupuesto, List<Sucursal> sucursal) {
        Barrio[] candidatos = Barrio.getCiudad();
        Barrio[] hay = new Barrio[16];
        Barrio[] noHay = new Barrio[16];
        int si = 0;
        int no = 0;
        for(Barrio barrio: candidatos) {
            if (barrio.tieneRestaurante()) {hay[si] = barrio; si++;}
            else {noHay[no] = barrio; no++;}
        }
        System.out.println("Escoja en cuál barrio desea abrir la nueva sucursal");
        for (int i = 0; i < no; i++) {
            if (noHay == null) {break;}
            System.out.println((i+1) + ". " + noHay[i]);
        }
        Scanner scanner = new Scanner(System.in);
        int eleccion = scanner.nextInt();
        while (eleccion > no) {
            System.out.println("Opción no disponible");
            System.out.println("Escoja otra opción");
            scanner = new Scanner(System.in);
            eleccion = scanner.nextInt();
        }
        Barrio barrio = noHay[no - 1];
        ArrayList<Esquina> locales = barrio.getEsquinas();
        int i = 0;
        for (Esquina local: locales) {
            System.out.println((i + 1) + ". " + local);
            i++;
        }
        scanner = new Scanner(System.in);
        eleccion = scanner.nextInt();
        while (eleccion > i) {
            System.out.println("Opción no disponible");
            System.out.println("Escoja otra opción");
            scanner = new Scanner(System.in);
            eleccion = scanner.nextInt();
        }
        boolean correcto = false;
        while (correcto == false) {

        }
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getUbicacion() {
    	return ubicacion;
    }
    
    public void setUbicacion(String ubicacion) {
    	this.ubicacion=ubicacion;
    }
    
    public int getPresupuesto() {
    	return presupuesto;
    }
    
    public void setPresupuesto(int presupuesto) {
    	this.presupuesto=presupuesto;
    }
    
    public Ingrediente[] getInventario(){
    	return inventario;
    }
    
    public void setInventario(Ingrediente[] inventario) {
        this.inventario=inventario;
    }
    
    public Empleado[] getEmpleado() {
    	return empleados;
    }
    
    public void setEmpleado(Empleado[] empleados) {
    	this.empleados=empleados;
    }
	
}
