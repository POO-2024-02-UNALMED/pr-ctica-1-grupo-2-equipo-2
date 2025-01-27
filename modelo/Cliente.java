package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Serializable {
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private List<Pedido> historialPedidos;

    private static final long serialVersionUID = 1L;

    public Cliente(int id, String nombre, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.historialPedidos = new ArrayList<>();
    }

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Pedido> getHistorialPedidos() {
        return historialPedidos;
    }

    public void setHistorialPedidos(List<Pedido> historialPedidos) {
        this.historialPedidos = historialPedidos;
    }

    public void agregarPedido(Pedido pedido) {
        this.historialPedidos.add(pedido);
    }
    
     public void darCalificacionM(Mesero mesero) {
    	boolean verificacion = false;
    	try (Scanner scanner = new Scanner(System.in)){
			int Calificacion = 0;
			while (!verificacion) {
				System.out.println("ingrese la calificacion que el cliente le dio al mesero que lo atendio del 1 al 5");
				try {
					Calificacion = scanner.nextInt();
					verificacion= true;
				} catch (InputMismatchException e){
					System.out.println("Entrada no válida. Por favor, ingrese un número.");
					scanner.next();
				}
			}
			
			if 	(Calificacion < 1) {
				Calificacion = 1;
			}
			
			if(Calificacion > 5) {
					Calificacion = 5;
				}
			
   
			mesero.setUltimaCalificacion(Calificacion);
			mesero.ganarPuntos(mesero, Calificacion);
		}
    	
    	
    }
    
    public void darCalificacionC(Chef chef) {
    	boolean verificacion = false;
    	try (Scanner scanner = new Scanner(System.in)){
			int Calificacion = 0;
			while (!verificacion) {
				System.out.println("ingrese la calificacion que el cliente le dio al chef que lo atendio del 1 al 5");
				try {
					Calificacion = scanner.nextInt();
					verificacion= true;
				} catch (InputMismatchException e){
					System.out.println("Entrada no válida. Por favor, ingrese un número.");
					scanner.next();
				}
			}
			
			if 	(Calificacion < 1) {
				Calificacion = 1;
			}
			
			if(Calificacion > 5) {
					Calificacion = 5;
				}
			
   
			chef.setUltimaCalificacion(Calificacion);
			chef.ganarPuntos(chef, Calificacion);
    }
	}
}
