package modelo;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Domicilio implements Serializable {
    private static final long serialVersionUID = 1L;
    private Barrio barrio;
    private Repartidor repartidor;
    private EstadoPedido estado;
    private Zona zona;
    private LocalDateTime tiempoEstimadoEntrega;
    private String comentariosEntrega;
    private double distanciaKm;

    // Constructor
    public Domicilio(Barrio barrio, Repartidor repartidor, Zona zona) {
        this.barrio = barrio;
        this.repartidor = repartidor;
        this.zona = zona;
        this.estado = EstadoPedido.RECIBIDO; 
        this.tiempoEstimadoEntrega = LocalDateTime.now().plusMinutes(30); 
    }

    // Método para deserialización
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // Lee los campos del objeto normalmente
        // La conversión de estado no es necesaria aquí si siempre es un EstadoPedido
    }


    // Getters y setters
    
    public Repartidor getRepartidor() { return repartidor; }
    public void setRepartidor(Repartidor repartidor) { this.repartidor = repartidor; }
    
    public EstadoPedido getEstado() { return estado; }
    public void setEstado(EstadoPedido estado) { this.estado = estado; }
    
    public Zona getZona() { return zona; }
    public void setZona(Zona zona) { this.zona = zona; }
    
    public double getDistanciaKm() { return distanciaKm; }
    
    public LocalDateTime getTiempoEstimadoEntrega() { return tiempoEstimadoEntrega; }
    public void setTiempoEstimadoEntrega(LocalDateTime tiempo) { this.tiempoEstimadoEntrega = tiempo; }
    
    public String getComentariosEntrega() { return comentariosEntrega; }
    public void setComentariosEntrega(String comentarios) { this.comentariosEntrega = comentarios; }

    public Barrio getBarrio() { return this.barrio; }

    public void setBarrio(Barrio barrioSeleccionado) {
        this.barrio = barrioSeleccionado;
    }

    public double getCostoEnvio() {
        return barrio != null ? barrio.getCostoEnvio() : 0.0;
    }

}
