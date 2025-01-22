package modelo;

import java.util.ArrayList;
import java.util.List;
import error.Entrada;
import baseDatos.DataManager;

public class Barrio {
    private boolean sucursal;
    private String nombre;
    private ArrayList<Esquina> esquinas;

    public Barrio(String nombre, int[] x, int[] y) {
        this.nombre = nombre;
        this.sucursal = false;
        this.esquinas = Esquina.determinarZona(x, y);
    }



    public boolean tieneRestaurante() {return sucursal;}


    public String toString() {return this.nombre;}

    public ArrayList<Esquina> getEsquinas(){return esquinas;}

    public void setSucursal(boolean x){this.sucursal = x;}

    public void generarLocal(double presupuesto){
        presupuesto /= 2;
        presupuesto /= 100000000;
        double[] precios = new double[4];
        double x = Math.random()*presupuesto+1000000000;
        x = Math.round(x);

    }

    public static Sucursal comprarTerreno(double presupuesto, List<Sucursal> sucursales, Barrio[] ciudad) {
        Barrio[] candidatos = ciudad;
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
            if (noHay == null) {
                break;
            }
            System.out.println((i + 1) + ". " + noHay[i]);
        }
        int eleccion = Entrada.input();
        while (eleccion > no) {
            System.out.println("Opción no disponible");
            System.out.println("Escoja otra opción");
            eleccion = Entrada.input();
        }
        Barrio barrio = noHay[eleccion - 1];
        ArrayList<Esquina> locales = barrio.getEsquinas();
        int i = 0;
        Esquina[] espacios = new Esquina[25];
        System.out.println("Escoja la ubicación");
        for (Esquina local : locales) {
            if (local == null) {
                break;
            }
            if (!Sucursal.calcularDistancia(local.getCoordenadas(), sucursales)) {
                continue;
            }
            espacios[i] = local;
            System.out.println((i + 1) + ". " + local);
            i++;
        }
        eleccion = Entrada.input();
        while (eleccion > i) {
            System.out.println("Opción no disponible");
            System.out.println("Escoja otra opción");
            eleccion = Entrada.input();
        }
        Esquina local = espacios[eleccion - 1];

        int[] direccion = local.getCoordenadas();
        String nombre = barrio.nombre;
        int j = 0;
        for(Sucursal sucursal: sucursales){j++;}
        double x = Math.random()*50+1;
        x = Math.round(x);
        int cantidad = 0;
        while(cantidad < x){cantidad++;}
        barrio.setSucursal(true);
        Sucursal restaurante = new Sucursal(j, nombre, cantidad, direccion);
        return restaurante;
    }
}
