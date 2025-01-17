package nuevaSucursal;

import ordenFisica.Mesa;
import ordenFisica.Mesero;

public class Sucursal {
	private int id;
    private String nombre;
    private Mesa[] mesas;
    private Mesero[] meseros;
    private double presupuesto;

    public Sucursal(int id, String nombre, int cantidad){
        this.id = id;
        this.nombre = nombre;
        this.mesas = new Mesa[cantidad];
        this.meseros = new Mesero[cantidad];
    }
}