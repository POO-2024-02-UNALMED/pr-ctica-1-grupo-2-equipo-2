package ordenFisica;

import modelo.Sucursal;

public class OrdenFisica {
	private Mesa mesa;
	private Cliente cliente;
	private Mesero mesero;
	private Sucursal sucursal;
	private boolean pendiente;
	
	public OrdenFisica(Mesa mesa, Cliente cliente,Mesero mesero,Sucursal sucursal) {
		this.mesa =mesa;
		this.cliente=cliente;
		this.mesero=mesero;
		this.sucursal=sucursal;
		this.pendiente=true;
	}
	
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa=mesa;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente=cliente;
	}
	
	public Mesero getMesero() {
		return mesero;
	}
	
	public void setMesero(Mesero mesero) {
		this.mesero=mesero;
	}
	
	public Sucursal getSucursal() {
		return sucursal;
	}
	
	public void setSucursal(Sucursal sucursal) {
		this.sucursal=sucursal;
	}
	
	public boolean getPendiente() {
		return pendiente;
	}
	
	public void setPendiente(boolean pendiente) {
		this.pendiente=pendiente;
	}
}
