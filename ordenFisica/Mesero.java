package ordenFisica;

import modelo.Sucursal;

public class Mesero extends Empleado {
	private Sucursal sucursal;
	private int antiguedad;
	private String fechaDeContratacion;
	private int ultimaCalificacion;
	private int pedidosAtendidos;
	private int puntaje;
	private int sueldo;
    private boolean isDisponible;
    private int proximoObjetivo;

	public Mesero(int id,String nombre,String direccion,int edad,Sucursal sucursal,int antiguedad,String fechaDeContratacion,int ultimaCalificacion,boolean isDisponible) {
		super(id,nombre,direccion,edad);
		this.sucursal=sucursal;
		this.antiguedad=antiguedad;
		this.fechaDeContratacion=fechaDeContratacion;
		this.ultimaCalificacion=ultimaCalificacion;
		this.pedidosAtendidos=0;
		this.puntaje=0;
		this.sueldo=1300000;
		this.isDisponible=isDisponible;
		this.proximoObjetivo=20;
	}
	
	
	public Sucursal getSucursal() {
		return sucursal;
	}
	
	public void setSucursal(Sucursal sucursal) {
		this.sucursal=sucursal;
	}
	
	public int getAntiguedad() {
		return antiguedad;
	}
	
	public void setAntiguedad(int antiguedad) {
		this.antiguedad=antiguedad;
	}
	
	public String getFechaDeContratacion() {
		return fechaDeContratacion;
	}
	
	public int getUltimaCalificacion() {
		return ultimaCalificacion;
	}
	
	public void setUltimaCalificacion(int U_C){
		ultimaCalificacion=U_C;
		
	}
	
    public int getSueldo() {
    	return sueldo;
    }
    
    public void setSueldo(int sueldo) {
    	this.sueldo=sueldo;
    }
    
    public boolean getIsDisponible() {
    	return isDisponible;
    }
    
    public void setIsDisponible(boolean I_D) {
    	isDisponible=I_D;
    }
    
    public int getProximoObjetivo() {
    	return proximoObjetivo;
    }
    
    public void setProximoObjetivo(int P_O) {
    	proximoObjetivo=P_O;
    }
    public int getPedidosAtendidos() {
    	return pedidosAtendidos;
    }
    
    public void setPedidosAtendidos(int pedidosAtendidos) {
    	this.pedidosAtendidos=pedidosAtendidos;
    }
    
    public int getPuntaje() {
    	return puntaje;
    }
    
    public void setPuntaje(int puntaje) {
    	this.puntaje=puntaje;
    }
    
public void ganarPuntos(Mesero mesero) {
	
}

}
