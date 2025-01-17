package modelo;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Domicilio implements Serializable {
    private static final long serialVersionUID = 1L;
    private String direccion;
    private Repartidor repartidor;
    private EstadoPedido estado;
    private Zona zona;
    private LocalDateTime tiempoEstimadoEntrega;
    private String comentariosEntrega;
    private double distanciaKm;

    // Constructor
    public Domicilio(String direccion, Repartidor repartidor, Zona zona) {
        this.direccion = direccion;
        this.repartidor = repartidor;
        this.zona = zona;
        this.estado = EstadoPedido.RECIBIDO; // Estado predeterminado
        this.tiempoEstimadoEntrega = LocalDateTime.now().plusMinutes(30); // tiempo por defecto
        calcularDistancia();
    }

    // Método para deserialización
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // Lee los campos del objeto normalmente
        // La conversión de estado no es necesaria aquí si siempre es un EstadoPedido
    }

    private void calcularDistancia() {
        this.distanciaKm = 1 + Math.random() * 9; // valor aleatorio
    }

    // Getters y setters
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    
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
}
