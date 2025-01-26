import java.util.Scanner;
import baseDatos.DataManager;
import baseDatos.Persistencia;
import error.Entrada;
import modelo.Administrativo;
import modelo.Empresa;
import modelo.Restaurante;


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
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Ver sucursales");
            System.out.println("2. contratacion");
            System.out.println("3. Funcionalidad 3");
            System.out.println("4. Pedir Domicilio");
            System.out.println("5. Funcionalidad 5");
            System.out.println("6. Finalizar programa");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Escriba su número de cédula");
                    int cedula = Entrada.input();
                    if (Administrativo.verificarAdmin(cedula,dataManager)) {
                        Administrativo admin = Administrativo.getAdmin(cedula, dataManager);
                        admin.saludo();
                        Empresa.menuFinanzas(dataManager);
                    }else{
                        break;
                    }
                case 2:
                    System.out.println("iniciar como administrativo");
                    System.out.println("ingrese su numero de cedula");
                    int ced = Entrada.input();
                    if (Administrativo.verificarAdmin(ced, dataManager)){
                        Administrativo admin = Administrativo.getAdmin(ced,dataManager);
                        admin.saludo();
                        Restaurante.menuAdministrativo();

                    }

                    break;
                case 3:
                    System.out.println("Funcionalidad 3 en desarrollo.");
                    break;
                case 4:
                    PedirDomicilio pedido = new PedirDomicilio(dataManager);
                    pedido.realizarPedido();
                    break;
                case 5:
                    System.out.println("Funcionalidad 5 en desarrollo.");
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