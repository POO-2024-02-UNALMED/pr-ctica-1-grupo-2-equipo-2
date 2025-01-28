package modelo;

import java.io.Serializable;
import java.util.list;
import ordenFisica.OrdenFisica;
import ordenFisica.PedidoFisico;

public class Plato implements Serializable{
	private static final long serialVersionUID = 1L;
	private float precio;
	private String nombre;
	private  List<Ingrediente> ingredientesNecesarios;
	
	public Plato(String nombre,float precio,List<Ingrediente> I_N) {
		this.nombre= nombre;
		this.precio=precio;
		this.ingredientesNecesarios=I_N;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public void setPrecio(float precio) {
		this.precio=precio;
	}

		public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public List<Ingrediente> getI_N() {
		return ingredientesNecesarios;
	}
	
	public void setI_N(List<Ingrediente> I_N) {
		this.ingredientesNecesarios=I_N;
	}

	public String toString() {
		return nombre;
	}

	public int getId(){return id;}
}
