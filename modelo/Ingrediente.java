package modelo;

import java.io.Serializable;

public class Ingrediente implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nombre;
	private int cantidad;
	private String ubicacion;
	
	public Ingrediente(String nombre,int cantidad,String ubicacion) {
		this.nombre=nombre;
		this.cantidad=cantidad;
		this.ubicacion=ubicacion;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad=cantidad;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion=ubicacion;
	}
}
