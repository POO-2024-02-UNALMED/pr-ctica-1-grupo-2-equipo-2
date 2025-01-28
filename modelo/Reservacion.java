package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reservacion {
    private LocalDateTime fechaHora;
    private int cantidadPersonas;
    private Mesa mesa;

    public Reservacion(LocalDateTime fechaHora, int cantidadPersonas, Mesa mesa){
        this.cantidadPersonas = cantidadPersonas;
        this.mesa = mesa;
        this.fechaHora = fechaHora;
    }

    public LocalDateTime getFechaHora() {
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
}

