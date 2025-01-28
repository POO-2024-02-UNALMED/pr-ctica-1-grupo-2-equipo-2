package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

import error.Entrada;
import ordenFisica.OrdenFisica;
import ordenFisica.PedidoFisico;

public class Cliente implements Serializable {
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private List<Pedido> historialPedidos;
    private int puntos;

    private static final long serialVersionUID = 1L;

    public Cliente(int id, String nombre, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.puntos = 0;
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

        public int getPuntos() {
        return this.puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
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

     public void darCalificacionM(Mesero mesero, Chef chef) {
    	boolean verificacion = false;
    	try (Scanner scanner = new Scanner(System.in)){
			int Calificacion = 0;
			while (!verificacion) {
				System.out.println("ingrese la calificacion que el cliente le puso al servicio que lo atendio del 1 al 5");
				try {
					Calificacion = scanner.nextInt();
					verificacion= true;
				} catch (InputMismatchException e){
					System.out.println("Entrada no válida. Por favor, ingrese un número.");
					scanner.nextInt();
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
			chef.setUltimaCalificacion(Calificacion);
			chef.ganarPuntos(chef, Calificacion);
		}


    }



        public void sumarPuntos(int suma){
    	 if (suma == 1) {
    		 this.puntos +=1;
    	 }
    	 if (suma == 2) {
    		 this.puntos +=2;
    	 }
    	 if (suma == 3) {
    		 this.puntos +=3;
    	 }
    }

    
    public int reclamarPuntos(int precio){
		boolean verificacion2 = false;
		int respuesta = 0;
    	try (Scanner scanner = new Scanner(System.in)){
		while (!verificacion2) {
			System.out.println("Tiene un descuento disponible desea reclamarlo? 1)Si 2) No (ingrese el numero)");
			try {
				respuesta = scanner.nextInt();
				if (respuesta == 1 || respuesta == 2) {
					verificacion2= true;
				}else {
					System.out.println("porfavor ingrese el numero 1) Si 2) No");
				}
			} catch (InputMismatchException e){
				System.out.println("Entrada no válida. Por favor, ingrese un número.");
				scanner.next();
				
    }
	}
		if (respuesta == 1) {
			System.out.println("Descuento reclamado");
			precio -= precio*0.2;
			this.puntos -= 20;
			return(precio);
			
		}else {
			System.out.println("Descuento guardado");
			return(precio);
		}
    }
    }
    public String toString(){return nombre;}
}
