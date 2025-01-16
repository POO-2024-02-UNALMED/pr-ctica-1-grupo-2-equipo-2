package modelo;
import java.io.Serializable;

public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private double precio;
    private int stock;  // Añadir el stock

    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    // Método para actualizar el stock
    public void actualizarStock(int cantidad) {
        int nuevoStock = this.stock - cantidad;
        if (nuevoStock < 0) {
            throw new IllegalStateException("No hay suficiente stock para el producto.");
        }
        this.stock = nuevoStock;
    }

    @Override
    public String toString() {
        return "Producto{id=" + id + ", nombre='" + nombre + '\'' + ", precio=" + precio + ", stock=" + stock + '}';
    }
}

