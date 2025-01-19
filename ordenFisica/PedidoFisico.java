package ordenFisica;

import modelo.Sucursal;

public class PedidoFisico extends OrdenFisica {
	private int numeroDePersonas;
	private Chef chef;
	private Plato[] pedido;
	
	public PedidoFisico(Mesa mesa, Cliente cliente, Mesero mesero, Sucursal sucursal, int N_D_P, Chef chef, Plato[] pedido) {
		super(mesa,cliente,mesero,sucursal);
		this.numeroDePersonas=N_D_P;
		this.chef=chef;
		this.pedido=pedido;
	}
	
	public int getNumeroDePersonas() {
		return numeroDePersonas;
	}
	
	public void setNumeroDePersonas(int N_D_P) {
		this.numeroDePersonas=N_D_P;
	}
	
	public Chef getChef() {
		return chef;
	}
	
	public void setChef(Chef chef) {
		this.chef=chef;
	}
	
	public Plato[] getPedido() {
		return pedido;
	}
	
	public void setPedido(Plato[] pedido) {
		this.pedido=pedido;
	}
}
