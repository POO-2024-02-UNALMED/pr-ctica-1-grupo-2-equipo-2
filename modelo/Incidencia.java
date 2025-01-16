package modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Incidencia implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String descripcion;
    private TipoIncidencia tipo;
    private LocalDateTime fecha;
    private String resolucion;

    public enum TipoIncidencia {
        RETRASO,
        PRODUCTO_DANADO,
        PRODUCTO_INCORRECTO,
        CLIENTE_AUSENTE,
        OTRO
    }

    public Incidencia(String descripcion) {
        this.descripcion = descripcion;
    }

    public Incidencia(int id, String descripcion, TipoIncidencia tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fecha = LocalDateTime.now();
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoIncidencia getTipo() {
        return tipo;
    }

    public void setTipo(TipoIncidencia tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    
}
