package ordenFisica;

import java.util.List;

import modelo.Mesa;
import modelo.Mesero;
import modelo.Sucursal;
import modelo.Chef;
import modelo.Plato;
import modelo.Cliente;

public class PedidoFisico extends OrdenFisica {
	private int numeroDePersonas;
	private Chef chef;
	private List<Plato> pedido;
	
	public PedidoFisico(Mesa mesa, Cliente cliente, Mesero mesero, Sucursal sucursal, int N_D_P, Chef chef, List<Plato> pedido) {
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
	
	public List<Plato> getPedido() {
		return pedido;
	}
	
	public void setPedido(List<Plato> pedido) {
		this.pedido=pedido;
	}

		public void Facturacion(PedidoFisico pedido) {
		
		System.out.printf("Tierra del sabor %s\n", pedido.getSucursal().getUbicacion());
		System.out.printf("%s\n", pedido.getCliente().getNombre());
		System.out.printf("%s\n", pedido.getChef().getNombre());
		System.out.printf("%s\n", pedido.getMesero().getNombre());
		int PrecioTotal = 0;
		for(Plato plato : pedido.getPedido()) {
            System.out.println(plato.getNombre());
            PrecioTotal += plato.getPrecio();
		}
		
		System.out.printf(" el total es de %d\n", PrecioTotal);
		pedido.getSucursal().incrementarPresupuesto(PrecioTotal);
		
		(pedido.getCliente()).darCalificacionM(pedido.getMesero());
		(pedido.getCliente()).darCalificacionC(pedido.getChef());
		
		if (PrecioTotal <= 20000) {
			pedido.getCliente().sumarPuntos(1);	
			}
		if (PrecioTotal >= 20000 && PrecioTotal <= 100000) {
			pedido.getCliente().sumarPuntos(2);	
			}
		if (PrecioTotal >= 100000) {
			pedido.getCliente().sumarPuntos(3);	
			}
		
		if (pedido.getCliente().getPuntos() >= 20) {
			pedido.getSucursal().usarDescuento1(PrecioTotal);
			PrecioTotal = pedido.getCliente().reclamarPuntos(PrecioTotal);
    		int numeroRedondeado = (int) Math.round(PrecioTotal);
			pedido.getSucursal().usarDescuento2(numeroRedondeado);
			System.out.printf(" el total verificado es de %d\n", numeroRedondeado);
			
		}
		
		
		
	}
}
