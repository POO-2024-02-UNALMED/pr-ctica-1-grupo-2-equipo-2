package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import error.Entrada;
import baseDatos.DataManager;

public class Barrio implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean sucursal;
    private String nombre;
    private double costoEnvio;
    private ArrayList<Esquina> esquinas;

    public Barrio(String nombre, double costoEnvio, int[] x, int[] y) {
        this.nombre = nombre;
        this.costoEnvio = costoEnvio;
        this.sucursal = false;
        this.esquinas = Esquina.determinarZona(x, y);
    }


    public boolean tieneRestaurante() {return sucursal;}

    public String toString() {return this.nombre;}

    public ArrayList<Esquina> getEsquinas(){return esquinas;}

    public void setSucursal(boolean x){this.sucursal = x;}

    //Determina cuáles son las localizaciones que hacen parte del barrio
    private static int esquinasPer(int [] direccion){
        int x = direccion[0];
        int y = direccion[1];
        if(x == 0 && (y == 1 || y == -1)){return 1;}
        if((x == 8 || x== -8) && (y == 8 || y == -8)){return 1;}
        if(x == 0 && (y == 7 || y == -7)){return 1;}
        if(y == 0 && (x == 8 || x == -8)){return 1;}
        if((x == 4 || x ==-4) && (y == 4 || y == -4)){return 1;}
        if((x == 4 || x == -4) && (y == 0 || y == 8 || y == -8)){return 1;}
        if((y == 4 || y == -4) && (x == 0 || x == 8 || x == -8)){return 1;}
        if(x == 0 || y == 0){return 2;}
        if(x == -4 || y == -4){return 2;}
        if(x == -8 || y == -8){return 2;}
        if(x == 4 || y == 4){return 2;}
        if(x == 8 || y == 8){return 2;}
        return 4;
    }

    //Busca la ubicación para abrir una nueva sucursal
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
        Esquina esquina = espacios[eleccion - 1];
        int[] direccion = esquina.getCoordenadas();
        int esqPer = esquinasPer(direccion);
        double[] valor = new double[esqPer];
        int[] cantidad = new int[esqPer];
        System.out.println("Escoja cuál de los locales disponibles le parece más interesante:");
        for(int n = 0; n < esqPer; n++){
            valor[n] = Math.random()*(presupuesto/2)+100000000;
            System.out.print((n+1) + ". Precio: $");
            System.out.print(Math.round(valor[n])/1000000 + "M");
            double r = Math.random()*(presupuesto/(1.5*10000000))+15;
            int s = 0;
            while(s < r){s++;}
            if(s > 50){
                cantidad[n] = 50;
            }else{
                cantidad[n] = s;
            }
            System.out.println(", Capacidad: " + cantidad[n] + " mesas");
        }
        int este = 5;
        while (este > cantidad.length || este < 1){
            este = Entrada.input();
            if(este > cantidad.length || este < 1){
                System.out.println("Esa opción no está disponible");
            }
        }
        int espacio = cantidad[este - 1];
        presupuesto -= valor[este - 1];
        presupuesto -= 10000000;
        String nombre = barrio.nombre;
        barrio.setSucursal(true);
        int j = sucursales.size();
        barrio.setSucursal(true);
        return new Sucursal(j, nombre, espacio, direccion, presupuesto);
    }

    public String getNombre(){return nombre;}

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

}
