package modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reservacion implements Serializable {
    private final static long serialVersionUID = 1L;
    private String fechaHora;
    private int cantidadPersonas;
    private Mesa mesa;

    public Reservacion(String fechaHora, int cantidadPersonas, Mesa mesa){
        this.cantidadPersonas = cantidadPersonas;
        this.mesa = mesa;
        this.fechaHora = fechaHora;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public String toString(){
        return fechaHora + "\nMesa : " + mesa.getId() + "\nCantidad de personas: " + cantidadPersonas;
    }
}

