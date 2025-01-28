import java.util.InputMismatchException;
import java.util.Scanner;
import baseDatos.DataManager;
import baseDatos.Persistencia;
import error.Entrada;
import modelo.*;
import ordenFisica.OrdenFisica;


public class Main {
    private static DataManager dataManager;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        dataManager = Persistencia.cargarDatos();
        if (dataManager == null) {
            dataManager = new DataManager();
        }

        while (running) {
            Empresa.calcularFinanzas(dataManager);
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Ver sucursales");
            System.out.println("2. Contratacion");
            System.out.println("3. Pedir orden física");
            System.out.println("4. Pedir Domicilio");
            System.out.println("5. Realizar reservación");
            System.out.println("6. Finalizar programa");

            System.out.print("Seleccione una opción: ");
            boolean correcto = false;
            int opcion = 0;
            while (!correcto) {
                scanner = new Scanner(System.in);
                try {
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Error, entrada no válida. Por favor, ingrese un número.");
                    scanner.nextLine();
                    continue;
                }
                correcto = true;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Escriba su número de cédula");
                    int cedula = Entrada.input();
                    if (Administrativo.verificarAdmin(cedula,dataManager)) {
                        Administrativo admin = Administrativo.getAdmin(cedula, dataManager);
                        admin.saludo();
                        Empresa.menuFinanzas(dataManager);
                    }
                    break;
                case 2:
                    System.out.println("iniciar como administrativo");
                    System.out.println("ingrese su numero de cedula");
                    int ced = Entrada.input();
                    if (Administrativo.verificarAdmin(ced, dataManager)){
                        Administrativo admin = Administrativo.getAdmin(ced,dataManager);
                        admin.saludo();
                        Restaurante.menuAdministrativo(dataManager);
                    }

                    break;
                case 3:
                    Cliente cliente = PedirDomicilio.cargarCliente(dataManager);
                    int i = 0;
                    int eleccion = 0;
                    for( Sucursal sucursal: dataManager.getSucursales()){
                        i++;
                        System.out.println(i + ". " + sucursal);
                    }
                    System.out.println("Escoja en cuál sucursal se está realizando la orden");
                    while(eleccion < 1 || eleccion > dataManager.getSucursales().size()){
                        eleccion = Entrada.input();
                        if (eleccion < 1 || eleccion > dataManager.getSucursales().size()){
                            System.out.println("Esa opción no está disponible");
                        }
                    }
                    Sucursal sucursal = dataManager.getSucursales().get(eleccion - 1);
                    System.out.println("Ingrese la cantidad de personas que se presenta con usted(Incluyéndolo a usted)");
                    int cantidad = 0;
                    while (cantidad < 1 || cantidad > 8){
                        cantidad = Entrada.input();
                        if(cantidad < 1 || cantidad > 8){
                            System.out.println("No es posible registrar esa cantidad");
                        }
                    }
                    Mesa mes = null;
                    for (Mesa mesa: sucursal.getMesas()){
                        if(mesa.getCapacidad() > cantidad && !mesa.isReservada()){
                            mes = mesa;
                            break;
                        }
                    }
                    if(mes == null){
                        System.out.println("No hay mesas disponibles");
                        break;
                    }
                    Mesero meso = null;
                    for(Mesero mesero: sucursal.getMeseros()){
                        if(mesero.getIsDisponible()){
                            meso = mesero;
                            mesero.setIsDisponible(false);
                            break;
                        }
                    }
                    if (meso == null){
                        System.out.println("No hay nadie que pua atender en este momento");
                        break;
                    }
                    OrdenFisica orden = new OrdenFisica(mes, cliente, meso, sucursal);
                    orden.HacerPedido(sucursal);
                    System.out.println("Guardando datos y finalizando programa...");
                    Persistencia.guardarDatos(dataManager);
                    running = false;
                    break;
                case 4:
                    PedirDomicilio pedido = new PedirDomicilio(dataManager);
                    pedido.realizarPedido();
                    break;
                case 5:
                    Sucursal.menuReserva(dataManager);
                    break;
                case 6:
                    System.out.println("Guardando datos y finalizando programa...");
                    Persistencia.guardarDatos(dataManager);
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        scanner.close();
    }
}