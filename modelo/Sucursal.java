package modelo;

import baseDatos.DataManager;
import error.Entrada;
import ordenFisica.Ingrediente;

import java.io.Serializable;
import java.util.List;

public class Sucursal implements Serializable{
    private static final long serialVersionUID = 1L;
	private int id;
	private String ubicacion;
	private double presupuesto;
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

    public Sucursal(int id, String nombre, int cantidad, int[] direccion, double presupuesto){
        this.id = id;
        this.ubicacion = nombre;
        this.mesas = new Mesa[cantidad];
        this.meseros = new Mesero[cantidad];
        this.direccion = direccion;
        this.presupuesto = presupuesto;
    }

    public static boolean calcularDistancia(int[] coordenadas, List<Sucursal> sucursales){
        boolean suficiente = true;
        int x = coordenadas[0];
        int y = coordenadas[1];
        for(Sucursal sucursal: sucursales){
            int x1 = sucursal.direccion[0];
            int y1 = sucursal.direccion[1];
            double distancia = Math.sqrt((x * x1) + (y * y1));
            if(distancia < 4){
                suficiente = false;
                break;
            }
            return suficiente;
        }
        return false;
    }

    public int getEspacio(){
        int i = 0;
        for(Mesa mesa: mesas){
            if(mesa == null){break;}
            i++;
        }
        return i;
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
    
    public double getPresupuesto() {
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

    public String toString(){
        return "*Sucursal de " + ubicacion + ": \n" +
                "Cantidad de mesas: " + getEspacio() + "\n" +
                "Presupuesto: $" + Math.round(presupuesto)/1000000 + "M";
    }
    public void comprarMesas(double presupuesto, int cantidad){
        int compradas = 0;
        while(compradas < cantidad/2) {
            System.out.println("¿Qué tipo de mesa desea adquirir");
            System.out.println("1. Pequeña: 4/ $500.000");
            System.out.println("2. Mediana: 6/ $800.000");
            System.out.println("3. Grande: 8/ $1.200.000");
            int eleccion = Entrada.input();
            switch(eleccion) {
                case 1:
                    System.out.println("¿Cuántas desea comprar?");
                    int numero = 0;
                    while (numero > cantidad || numero < 1) {
                        numero = Entrada.input();
                        if (numero > cantidad || numero < 1) {
                            System.out.println("No es posible comprar esa cantidad");
                        }
                    }
                    if(presupuesto < 500000 * numero){
                        System.out.println("No hay suficiente dinero");
                        break;
                    }else{
                        presupuesto -= 500000 * numero;
                        int j = 0;
                        for(Mesa mesa: mesas){
                            j++;
                            if(mesa == null){break;}
                        }
                        for(int i = 0; i < numero; i++){
                            mesas[i] = new Mesa(j, 4,this);
                            j++;
                        }
                    }
            }
        }
    }
}
