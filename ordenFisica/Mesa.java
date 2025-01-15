package ordenFisica;

public class Mesa {
	private int id;
	private int capacidad;
	private Sucursal sucursal;
	private boolean unida;
	
	public Mesa(int id,int capacidad,Sucursal sucursal) {
		this.id=id;
		this.capacidad=capacidad;
		this.sucursal=sucursal;
		this.unida= false;
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
}
