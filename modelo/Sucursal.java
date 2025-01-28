package modelo;

import baseDatos.DataManager;
import error.Entrada;
import ordenFisica.OrdenFisica;
import ordenFisica.PedidoFisico;

import java.io.Serializable;
import java.util.List;

public class Sucursal implements Serializable{
    private static final long serialVersionUID = 1L;
	private int id;
	private String ubicacion;
	private double presupuesto;
	private List<Ingrediente> inventario;
    private List<Mesero> mesero;
	private List<Chef> chef;
	private List<Empleado> empleados;
    private Mesa[] mesas;
    private int[] direccion;
    private double gastoRecursos;
    private List<Plato> menu;


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

    public void aumentarPresupuesto(double aumento){
        presupuesto += aumento;
    }
    public Sucursal(int id, String ubicacionSucursal){
        this.id=id;
        this.ubicacion=ubicacionSucursal;
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
    
    public List<Ingrediente> getInventario(){
    	return inventario;
    }
    
    public void setInventario(List<Ingrediente> inventario) {
        this.inventario=inventario;
    }
    
    public List<Empleado> getEmpleado() {
    	return empleados;
    }
    
    public void setEmpleado(List<Empleado> empleados) {
    	this.empleados=empleados;
    }


    public double getGastoRecursos(){return gastoRecursos;}

    public void setGastoRecursos(double x){gastoRecursos = x;}

    public String toString(){
        return "*Sucursal de " + ubicacion + "(" + (Esquina.fromCoo(direccion).toString())  + "): " + " \n" +
                "Cantidad de mesas: " + mesas.length + "\n" +
                "Presupuesto: $" + Math.round(presupuesto)/1000000 + "M";
    }
    public void comprarMesas(){
        int compradas = 0;
        int cantidad = mesas.length;
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

    public void restarPresupuesto(double menos){presupuesto -= menos;}

    public static void cerrar(DataManager dataManager){
        System.out.println("Escoja qué sucursal desea cerrar");
        int i = 0;
        for(Sucursal sucursal:dataManager.getSucursales()){
            i++;
            System.out.println(i + ". " + sucursal);
        }
        System.out.println((i+1) + ". No cerrar nunguna");
        int eleccion = Entrada.input();
        if(eleccion < 0 || eleccion > dataManager.getSucursales().size()){
            System.out.println("No se ha cerrado ninguna sucursal");
            return;
        }
        Sucursal sucursal = dataManager.getSucursales().get(eleccion-1);
        double liquidacion = sucursal.getEspacio() * 1000000;
        for(Mesero mesero: sucursal.getMeseros()){
            if(mesero == null){break;}
            liquidacion += mesero.getSueldo() * 6;
        }
        for(Empleado empleado: sucursal.getEmpleado()){
            if(empleado == null){break;}
            liquidacion += empleado.getSueldo() * 6;
        }
        dataManager.getSucursales().remove(sucursal);
        System.out.println("Se ha cerrado la sucursal de " + sucursal.ubicacion);
        liquidacion /= dataManager.getSucursales().size();
        for(Sucursal sucursal1: dataManager.getSucursales()){
            sucursal1.aumentarPresupuesto(liquidacion);
        }
    }

        public List<Plato> getMenu() {
    	return menu;
    }
    
    public void setMenu(List<Plato> menu) {
    	this.menu=menu;
    }
    
    public String mostrarMenu() {
    	StringBuilder sb = new StringBuilder();
		int con = 0;
    	for (Plato plato : menu) {
    		con += 1;
    		sb.append(con).append(". ").append(plato.toString()).append("\n");
    	}
    	
    	String Mmenu= sb.toString();
    	return Mmenu;
    	
    }

        
    public void incrementarPresupuesto(int incremento) {
    	this.presupuesto += incremento;
    }
    
    public void usarDescuento1(int precioTotal) {
    	this.presupuesto -= precioTotal;
    }
    
    public void usarDescuento2(int precioTotal) {
    	this.presupuesto += precioTotal;
    }
	
}
