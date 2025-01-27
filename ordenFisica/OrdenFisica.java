package ordenFisica;

import java.io.Serializable;

import modelo.Mesa;
import modelo.Mesero;
import modelo.Sucursal;

public class OrdenFisica implements Serializable{
	private static final long serialVersionUID = 1L;
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

		public void HacerPedido(Sucursal sucursal) {
		
		System.out.println(sucursal.mostrarMenu());
		
		boolean verificacion = false;
    	try (Scanner scanner = new Scanner(System.in)){
			int CantPer = 0;
			while (!verificacion) {
				System.out.println("¿Cuantos platos desea ordenar?");
				try {
					CantPer = scanner.nextInt();
					verificacion= true;
				} catch (InputMismatchException e){
					System.out.println("Entrada no válida. Por favor, ingrese un número.");
					scanner.next();
				}
			}
			
		if (CantPer < 6 && CantPer>0) {
			int i = 0;
			List<String> pedido1 = new ArrayList<>();
			while (i < CantPer) {
				boolean verficacion2 = false;
				while (!verficacion2) {
					System.out.println("¿que plato desea ordenar? ingrese el numero del plato");
					try {
						CantPer = scanner.nextInt();
						verificacion= true;
					} catch (InputMismatchException e){
						System.out.println("Entrada no válida. Por favor, ingrese un número.");
						scanner.next();
					}
				}
						}


			
						
					}
			}
			}
}
