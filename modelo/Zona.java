package modelo;

import java.io.Serializable;

public class Zona implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private double costoEnvio;
    private boolean activa;

    public Zona(int id, String nombre, double costoEnvio, boolean activa) {
        this.id = id;
        this.nombre = nombre;
        this.costoEnvio = costoEnvio;
        this.activa = activa;
    }

    // Getters y setters
    public int getId() { 
        return id; 
    }

    public void setId(int id) { 
        this.id = id; 
    }

    public String getNombre() { 
        return nombre; 
    }

    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public double getCostoEnvio() { 
        return costoEnvio; 
    }

    public void setCostoEnvio(double costoEnvio) { 
        this.costoEnvio = costoEnvio; 
    }

    public boolean isActiva() { 
        return activa; 
    }

    public void setActiva(boolean activa) { 
        this.activa = activa; 
    }
}
