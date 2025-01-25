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
    private double gastoRecursos;


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
        this.empleados = new Empleado[15];
    }
    public Sucursal(int id, String nombre, int cantidad, int[] direccion, double presupuesto, String auto){
        this(id,nombre,cantidad,direccion,presupuesto);
        int mitad = mesas.length/2;
        int tercio = mesas.length/3;
        int i = 0;
        while(i < mitad){
            mesas[i] = new Mesa(i+1,4,this);
            System.out.println(mesas[i]);
            i++;
        }
        while(i < (mitad + tercio)) {
            mesas[i] = new Mesa(i + 1, 6, this);
            i++;
        }
        while(i < mesas.length){
            mesas[i] = new Mesa(i+1,8,this);
            i++;
        }

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
        return true;
    }

    public int getEspacio(){
        return mesas.length;
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

    public Mesero[] getMeseros(){return meseros;}

    public double getGastoRecursos(){return gastoRecursos;}

    public void setGastoRecursos(double x){gastoRecursos = x;}

    public String toString(){
        return "*Sucursal de " + ubicacion + "(" + (Esquina.fromCoo(direccion).toString())  + "): " + " \n" +
                "Cantidad de mesas: " + mesas.length + "\n" +
                "Presupuesto: $" + Math.round(presupuesto)/1000000 + "M";
    }
    public void comprarMesas(double presupuesto, int cantidad){
        int compradas = 0;
        while(compradas < cantidad) {
            System.out.println("¿Qué tipo de mesa desea adquirir");
            System.out.println("1. Pequeña: 4/ $500.000");
            System.out.println("2. Mediana: 6/ $800.000");
            System.out.println("3. Grande: 8/ $1.200.000");
            int eleccion = Entrada.input();
            switch(eleccion) {
                case 1:
                    System.out.println("¿Cuántas desea comprar?");
                    int numero = 0;
                    while (numero > cantidad - compradas || numero < 1) {
                        numero = Entrada.input();
                        if (numero < 1) {System.out.println("No es posible comprar esa cantidad");}
                        if (numero > cantidad - compradas) {System.out.println("No hay suficiente espacio para comprar esa cantidad");
                        System.out.println("Escoja otra");}
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
                        int i = 0;
                        while (i < numero ){
                            mesas[j - 1] = new Mesa(j, 4,this);
                            compradas++;
                            j++;
                            i++;
                        }
                    }
                    break;
                case 2:
                    System.out.println("¿Cuántas desea comprar?");
                    numero = 0;
                    while (numero > cantidad - compradas || numero < 1) {
                        numero = Entrada.input();
                        if (numero < 1) {System.out.println("No es posible comprar esa cantidad");}
                        if (numero > cantidad - compradas) {System.out.println("No hay suficiente espacio para comprar esa cantidad");}
                        System.out.println("Escoja otra");
                    }
                    if(presupuesto < 800000 * numero){
                        System.out.println("No hay suficiente dinero");
                        break;
                    }else{
                        presupuesto -= 800000 * numero;
                        int j = 0;
                        for(Mesa mesa: mesas){
                            j++;
                            if(mesa == null){break;}
                        }
                        int i = 0;
                        while (i < numero ){
                            mesas[j - 1] = new Mesa(j, 6,this);
                            compradas++;
                            j++;
                            i++;
                        }
                    }
                    break;
                case 3:
                    System.out.println("¿Cuántas desea comprar?");
                    numero = 0;
                    while (numero > cantidad - compradas || numero < 1) {
                        numero = Entrada.input();
                        if (numero < 1) {System.out.println("No es posible comprar esa cantidad");}
                        if (numero > cantidad - compradas) {System.out.println("No hay suficiente espacio para comprar esa cantidad");}
                        System.out.println("Escoja otra");
                    }
                    if(presupuesto < 1200000 * numero){
                        System.out.println("No hay suficiente dinero");
                        break;
                    }else{
                        presupuesto -= 1200000 * numero;
                        int j = 0;
                        for(Mesa mesa: mesas){
                            j++;
                            if(mesa == null){break;}
                        }
                        int i = 0;
                        while (i < numero ){
                            mesas[j - 1] = new Mesa(j, 8,this);
                            compradas++;
                            j++;
                            i++;
                        }
                    }
                    break;
            }
        }
    }

    public void mesasAuto(){
        int mitad = mesas.length/2;
        int tercio = mesas.length/3;
        int i = 0;
        while(i < mitad){
            mesas[i] = new Mesa(i+1,4,this);
            i++;
        }
        while(i < (mitad + tercio)) {
            mesas[i] = new Mesa(i + 1, 6, this);
            i++;
        }
        while(i < mesas.length){
            mesas[i] = new Mesa(i+1,8,this);
            i++;
        }
    }
    public void autoEmpleado(int numero, int id){
        String direccion = Esquina.fromCoo(this.direccion).toString();
        meseros[numero] = new Mesero(id,direccion,20,this,1500000);
        System.out.println("Se ha contratado a " + meseros[numero] + " para prestar servicio como meser@");
        presupuesto -= 1500000;
    }
}
