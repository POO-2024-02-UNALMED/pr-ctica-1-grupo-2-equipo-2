package modelo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Repartidor implements Serializable {
    private int id;
    private String nombre;
    private boolean isDisponible;
    private double calificacionPromedio;
    private List<Zona> zonasAsignadas = new ArrayList<>();

    private static final long serialVersionUID = 1L;

    public Repartidor(int id, String nombre, boolean isDisponible) {
        this.id = id;
        this.nombre = nombre;
        this.isDisponible = isDisponible;
    }

    // Getter y setter para zonasAsignadas
    public List<Zona> getZonasAsignadas() {
        return zonasAsignadas;
    }

    public void setZonasAsignadas(List<Zona> zonasAsignadas) {
        this.zonasAsignadas = zonasAsignadas;
    }

    // Getter y setter para id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter y setter para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y setter para isDisponible
    public boolean isDisponible() {
        return isDisponible;
    }

    public void setDisponible(boolean isDisponible) {
        this.isDisponible = isDisponible;
    }

    // Método para asignar zona a un repartidor
    public void asignarZona(Zona zona) {
        this.zonasAsignadas.add(zona);
    }

    public double getCalificacionPromedio() {
        return calificacionPromedio;
    }

    public void setCalificacionPromedio(double calificacionPromedio) {
        this.calificacionPromedio = calificacionPromedio;
    }

    @Override
    public String toString() {
        return "Repartidor{id=" + id + ", nombre='" + nombre + '\'' + ", isDisponible=" + isDisponible + '}';
    }
}
