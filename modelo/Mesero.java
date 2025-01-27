package modelo;

import java.io.Serializable;

public class Mesero extends Empleado implements Serializable{
	private Sucursal sucursal;
	private int antiguedad;
	private final String fechaDeContratacion;
	private int ultimaCalificacion;
	private int pedidosAtendidos;
	private int puntaje;
	private double sueldo;
    private boolean isDisponible;
    private int proximoObjetivo;

	public Mesero(int id,String nombre,String direccion,int edad,Sucursal sucursal,int antiguedad,String fechaDeContratacion,int ultimaCalificacion,boolean isDisponible, double sueldo) {
		super(id,nombre,direccion,edad);
		this.sucursal=sucursal;
		this.antiguedad=antiguedad;
		this.fechaDeContratacion=fechaDeContratacion;
		this.ultimaCalificacion=ultimaCalificacion;
		this.pedidosAtendidos=0;
		this.puntaje=0;
		this.sueldo=sueldo;
		this.isDisponible=isDisponible;
		this.proximoObjetivo=20;
	}

	public Mesero(int id, String nombre, String direccion, int edad,Sucursal sucursal, int antiguedad, String fechaDeContratacion) {
        super(id,nombre,direccion,edad);
        this.sucursal = sucursal;
        this.antiguedad = antiguedad;
        this.fechaDeContratacion = fechaDeContratacion;
		if (antiguedad >= 1 && antiguedad < 2) {
            this.sueldo = 1500000;
        } else if (antiguedad >= 2 && antiguedad < 3) {
            this.sueldo = 1800000;
        } else if (antiguedad >= 3) {
            this.sueldo = 2200000;
        } else {
            this.sueldo = 1300000;
        }

    }

	public Mesero(int id,String direccio, int edad ,Sucursal sucursal,double sueldo){
		this(id,generarNombre(),direccio,edad,sucursal,1,"24/01/24",0,true,sueldo);
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
	
    public double getSueldo() {
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

    public void ganarPuntos(Mesero mesero,int Calificacion) {
	
    	this.pedidosAtendidos += 1;
	
    	switch(Calificacion) {
    		case 1:
    			if (this.puntaje != 0) {
    				this.puntaje -= 2;
    			}else{
    				this.puntaje = 0;
    			}
    			break;
    		case 2:
    			if (this.puntaje != 0) {
    				this.puntaje -= 1;
    			}else{
    				this.puntaje = 0;
    			}
    			break;
    		case 3:
    			if (this.puntaje != 0) {
    				this.puntaje -= 0;
    			}else{
    				this.puntaje = 0;
    			}
    			break;
    		case 4:
    			if (this.puntaje != 0) {
    				this.puntaje += 1;
    			}
    			break;
    		case 5:
    			if (this.puntaje != 0) {
    				this.puntaje += 2;
    			}
    			break;
    	}
	
    	if (this.sueldo >= 2300000) {
    		this.puntaje = 0;
    		this.sueldo =2300000;
    	}
	
    	if (this.puntaje >= this.proximoObjetivo) {
		
    		double aumento = (this.getSueldo() * 0.1);
		
    		int numeroRedondeado = (int) Math.round(aumento);
		
    		this.sueldo += numeroRedondeado;
		
    		puntaje = 0;
		
    		proximoObjetivo += 50;
	
    	}

    	
}



}
