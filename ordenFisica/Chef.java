package ordenFisica;

import modelo.Empleado;
import modelo.Sucursal;

public class Chef extends Empleado {
	private Sucursal sucursal;
	private int antiguedad;
	final private String fechaDeContratacion;
	private int ultimaCalificacion;
	private int puntaje;
	private int sueldo;
    private boolean isDisponible;
    private int proximoObjetivo;
	
	public Chef(int id,String nombre,String direccion,int edad,Sucursal sucursal,int antiguedad,String fechaDeContratacion,int ultimaCalificacion,boolean isDisponible) {
		super(id,nombre,direccion,edad);
		this.sucursal=sucursal;
		this.antiguedad=antiguedad;
		this.fechaDeContratacion=fechaDeContratacion;
		this.ultimaCalificacion=ultimaCalificacion;
		this.puntaje=0;
		this.sueldo=1800000;
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
    
    public int getPuntaje() {
    	return puntaje;
    }
    
    public void setPuntaje(int puntaje) {
    	this.puntaje=puntaje;
    }
    

	public void ganarPuntos(Chef chef, int Calificacion) {
    	
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
	
    	if (this.sueldo >= 3500000) {
    		this.puntaje = 0;
    		this.sueldo = 3500000;
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

