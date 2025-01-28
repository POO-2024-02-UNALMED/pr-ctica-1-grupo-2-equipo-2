package modelo;

import java.io.Serializable;

public class Mesa implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private int capacidad;
	private Sucursal sucursal;
	private boolean unida;
	private boolean reservada;
	
	public Mesa(int id,int capacidad,Sucursal sucursal) {
		this.id=id;
		this.capacidad=capacidad;
		this.sucursal=sucursal;
		this.unida= false;
		this.reservada = false;
	}


	public void reservar() {
		this.reservada = true;
	}

	public void liberar() {
		this.reservada = false;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public void setCapacidad(int capacidad) {
		this.capacidad=capacidad;
	}
	
	public Sucursal getSucursal() {
		return sucursal;
	}
	
	public void setSucursal(Sucursal sucursal) {
		this.sucursal=sucursal;
	}
	
	public boolean getUnida() {
		return unida;
	}
	
	public void setUnida(boolean unida) {
		this.unida=unida;
	}
	
	public void UnirMesas(Mesa mesa1, Mesa mesa2) {
		
	}
	public String toString(){return id + " " + capacidad;}

	public boolean isReservada() {
		return reservada;
	}
}
