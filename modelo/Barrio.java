package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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

    public static void comprarTerreno(double presupuesto, List<Sucursal> sucursal, Barrio[] ciudad) {
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
        Scanner scanner = new Scanner(System.in);
        int eleccion = scanner.nextInt();
        while (eleccion > no) {
            System.out.println("Opción no disponible");
            System.out.println("Escoja otra opción");
            scanner = new Scanner(System.in);
            eleccion = scanner.nextInt();
        }
        Barrio barrio = noHay[eleccion - 1];

         ArrayList<Esquina> locales = barrio.getEsquinas();
         int i = 0;
         for (Esquina local : locales) {
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
}
