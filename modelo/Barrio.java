package modelo;

import java.util.ArrayList;

public class Barrio {
    private final static Barrio[] ciudad = new Barrio[16];
    private boolean sucursal;
    private String nombre;
    private final ArrayList<Esquina> esquinas;

    public Barrio(String nombre, int[] x, int[] y) {
        this.nombre = nombre;
        this.sucursal = false;
        this.esquinas = Esquina.determinarZona(x, y);
    }

    static {
        int[] a = {-8, -4};
        int[] b = {-4 , 0};
        int[] c = {0, 4};
        int[] d = {4, 8};
        ciudad[0] = new Barrio("La Estrella", a, d);
        ciudad[1] = new Barrio("Sabaneta", b, d);
        ciudad[2] = new Barrio("Itagüí", c, d);
        ciudad[3] = new Barrio("Envigado", d, d);
        ciudad[4] = new Barrio("Robledo", d, c);
        ciudad[5] = new Barrio("Bello", c, c);
        ciudad[6] = new Barrio("Poblado", b, c);
        ciudad[7] = new Barrio("Niquía", a, c);
        ciudad[8] = new Barrio("Alpujarra", a, b);
        ciudad[9] = new Barrio("Cisneros", b, b);
        ciudad[10] = new Barrio("San Antonio", c, b);
        ciudad[11] = new Barrio("Berrío", d, b);
        ciudad[12] = new Barrio("Prado", d, a);
        ciudad[13] = new Barrio("Caribe", c, a);
        ciudad[14] = new Barrio("Acevedo", b, a);
        ciudad[15] = new Barrio("Madera", a, a);

    }

    public boolean tieneRestaurante() {return sucursal;}

    public static Barrio[] getCiudad() {return ciudad;}

    public String toString() {return this.nombre;}

    public ArrayList<Esquina> getEsquinas(){return esquinas;}

    public void setSucursal(boolean x){this.sucursal = x;}

    public static Barrio getBarrio(int num){return ciudad[num];}

}
