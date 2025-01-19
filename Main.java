import java.util.InputMismatchException;
import java.util.Scanner;
import baseDatos.DataManager;
import baseDatos.Persistencia;
import modelo.Administrativo;
import modelo.Empresa;


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
            System.out.println("2. Funcionalidad 2");
            System.out.println("3. Funcionalidad 3");
            System.out.println("4. Pedir Domicilio");
            System.out.println("5. Funcionalidad 5");
            System.out.println("6. Finalizar programa");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Escriba su número de cédula");
                    Scanner scanner1 = new Scanner(System.in);
                    long cedula;
                    try {
                        cedula = scanner1.nextLong();
                        scanner.nextLine(); // Limpiar buffer
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada no válida. Por favor, ingrese un número.");
                        scanner.nextLine(); // Limpiar el buffer
                        continue;
                    }
                    if (Administrativo.verificarAdmin(cedula,dataManager) == true) {
                        Administrativo admin = Administrativo.getAdmin(cedula, dataManager);
                        admin.saludo();
                        Empresa.menuFinanzas(dataManager);
                    }else{
                        break;
                    }
                case 2:
                    System.out.println("Funcionalidad 2 en desarrollo.");
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