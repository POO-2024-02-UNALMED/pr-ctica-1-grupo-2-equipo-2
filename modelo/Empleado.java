package modelo;

import java.io.Serializable;

public class Empleado implements Serializable{
    private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String direccion;
	private int edad;
    private int sueldo;
    private int rol;

	
	public Empleado(int id,String nombre,String direccion,int edad) {
		this.id=id;
		this.nombre=nombre;
		this.direccion=direccion;
		this.edad=edad;

	}
    public String toString(){
        return nombre;
    }

    public double getSueldo(){return sueldo;}
	public int getId() {
		return id;
	}
    
    	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
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
    
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public final static String generarNombre(){
        double x = Math.random()*70+1;
        x = Math.round(x);
        double y = Math.random()*70+1;
        y = Math.round(y);
        int i = 0,j = 0;
        while(i < x){i++;}
        while(j < y){j++;}
        String nombre = Nombre.getNombre(i);
        String apellido = Apellido.getNombre(j);
        return nombre + " " + apellido;
    }


    public final static int generarDocumento(){
        double x = Math.random()*99999+10000;
        x = Math.round(x);
        int i = 0;
        while(i < x){i++;}
        return i;
    }

    
}
