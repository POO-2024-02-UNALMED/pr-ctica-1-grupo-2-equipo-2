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

    public void calcularDistancia(int[] coordenadas){

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
