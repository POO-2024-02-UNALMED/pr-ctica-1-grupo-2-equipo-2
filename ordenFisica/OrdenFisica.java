package ordenFisica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import modelo.Cliente;
import modelo.Mesa;
import modelo.Mesero;
import modelo.Sucursal;
import modelo.Plato;
import modelo.Chef;

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
		

		
		boolean verificacion = false;
    	try (Scanner scanner1 = new Scanner(System.in)){
			int CantPer = 0;
			while (!verificacion) {
				System.out.println("¿Cuantos platos desea ordenar?");
				try {
					CantPer = scanner1.nextInt();
					verificacion= true;
				} catch (InputMismatchException e){
					System.out.println("Entrada no válida. Por favor, ingrese un número.");
					scanner1.next();
				}
			}

			if (CantPer <= 0) {
				while (CantPer <= 0) {
					boolean verificacion2 = false;
					while (!verificacion2) {
						System.out.println("Numero de platos debe ser mayor a 0 ingrese un numero valido");
						try {
							CantPer = scanner1.nextInt();
							verificacion2= true;
						} catch (InputMismatchException e){
							System.out.println("Entrada no válida. Por favor, ingrese un número.");
							scanner1.next();
						}
					}
				}
			}
		List<Integer> pedido1 = new ArrayList<>();
		List<Plato> platoF =new ArrayList<>();
			System.out.println(sucursal.mostrarMenu());
		if (CantPer < 6 && CantPer>0) {
			int i = 0;
			int plato = 0;
			while (i < CantPer) {
				boolean verificacion2 = false;
				while (!verificacion2) {
					System.out.println("¿que plato desea ordenar? ingrese el numero del plato");
					try {
						plato = scanner1.nextInt();
						for (Plato plato2 : sucursal.getMenu() ) {
							if (plato2.getId() == plato) {
								System.out.printf("Pedido confirmado de ", plato2);
								platoF.add(plato2);
							}
						}
						pedido1.add(plato);
						verificacion2= true;
					} catch (InputMismatchException e){
						System.out.println("Entrada no válida. Por favor, ingrese el numero del plato");
						scanner1.next();
					}
				}
				i += 1;		
			}

			
			
						
					}
		
		if(CantPer >= 6) {
			boolean verificacion2 = false;
			int plato = 0;
			while (!verificacion2) {
				System.out.println("¿Numero de platos es mayor a 6 por ende solo se dara un plato a todo el grupo, que plato desea?");
				try {
					plato = scanner1.nextInt();
					verificacion2= true;
					pedido1.add(plato);
				} catch (InputMismatchException e){
					System.out.println("Entrada no válida. Por favor, ingrese un número.");
					scanner1.next();
			
		}

			}
			scanner1.close();
			}

		PedidoFisico pedido = new PedidoFisico (this.mesa, this.cliente,this.mesero,sucursal, CantPer, Chef.asignar(sucursal), platoF);{
			
		pedido.Facturacion(pedido);
		}
		}
	}
}
