package modelo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import baseDatos.DataManager;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import error.Entrada;
import modelo.Mesero;



public class Restaurante {
    private static ArrayList<Mesero> meseros = new ArrayList<>(); // Array para almacenar meseros

    // Método para contratar un mesero
    public static void contratarMesero(DataManager dataManager) {
        Scanner scanner = new Scanner(System.in); // Crear el Scanner para leer datos del usuario
        ArrayList<Sucursal> conEspacio = new ArrayList<Sucursal>();
        List<Sucursal> sucursales = dataManager.getSucursales();
        for(Sucursal sucursal: sucursales){
            for(Mesero mesero: sucursal.getMeseros()){
                if(mesero == null){
                    conEspacio.add(sucursal);
                    break;
                }
            }
        }
        // Verificar si hay espacio disponible en el array

        if (!conEspacio.isEmpty()) { // Encontrar la primera posición vacía
            // Solicitar datos al usuario
            boolean correcto = false;
            int id = 0;
            System.out.print("Ingrese el ID del mesero: ");
            while (!correcto){
                id = scanner.nextInt();
                correcto = dataManager.explorar(id);
                if(!correcto) {
                    System.out.println("Ese id ya está en uso");
                }
            }
            scanner.nextLine(); // Limpiar el buffer de entrada
            System.out.print("Ingrese el nombre del mesero: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la dirección del mesero: ");
            String direccion = scanner.nextLine();

            System.out.print("Ingrese la edad del mesero: ");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            int i = 0;

            while(i < conEspacio.size()){
                System.out.println(i+1 + ". " + conEspacio.get(i));
                i++;
            }
            System.out.print("\nIngrese la sucursal del mesero: ");
            int nombreSucursal = Entrada.input();
            while(nombreSucursal < 1 || nombreSucursal > i){
                nombreSucursal = Entrada.input();
                if(nombreSucursal < 1 || nombreSucursal > i) {
                    System.out.println("Opción no disponible");
                }
            }

            Sucursal sucursal = sucursales.get(nombreSucursal-1);

            System.out.print("Ingrese la experiencia del mesero (en años): ");
            int antiguedad = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            System.out.print("Ingrese la fecha de contratación (YYYY-MM-DD): ");
            String fechaDeContratacion = scanner.nextLine();

            // Crear y agregar el mesero al array
            sucursal.nuevoMesero(new Mesero(id, nombre, direccion, edad, sucursal, antiguedad, fechaDeContratacion));
            System.out.println("Mesero contratado exitosamente");
            return; // Salir después de contratar
        }

        System.out.println("No hay espacio disponible para contratar más meseros.");
    }

    // Método para mostrar todos los meseros
    public static void verMeseros(DataManager dataManager) {
        System.out.println("Lista de meseros contratados:");
        for (Sucursal sucursal: dataManager.getSucursales()) {
            for(Mesero mesero: sucursal.getMeseros()){
                if (mesero != null) {
                    System.out.println("- ID: " + mesero.getId() +
                            ", Nombre: " + mesero.getNombre() +
                            ", Sucursal: " + mesero.getSucursal().getUbicacion() +
                            ", Fecha de contratación: " + mesero.getFechaDeContratacion()+
                            ", sueldo del mesero: " + mesero.getSueldo());
                }
            }
        }
    }
    public static void despedirMesero(DataManager dataManager) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del mesero a despedir: ");
        int id = scanner.nextInt();

        for (Sucursal sucursal: dataManager.getSucursales()) {
            for(Mesero mesero: sucursal.getMeseros())
                if (mesero != null && mesero.getId() == id) {
                System.out.println("Mesero despedido: " + mesero.getNombre());// Eliminar al mesero del array
                sucursal.despedir(id);
                scanner.close();
                return;
            }
        }
        System.out.println("Mesero no encontrado.");
    }

    // Método para un mesero especifico
public static void buscarMesero(DataManager dataManager) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese el ID del mesero que desea buscar: ");
    int id = scanner.nextInt();

    for (Sucursal sucursal : dataManager.getSucursales()) {
        for (Mesero mesero : sucursal.getMeseros()) {
            if (mesero != null && mesero.getId() == id) {
                System.out.println("\n Mesero encontrado:");
                System.out.println("ID: " + mesero.getId());
                System.out.println("Nombre: " + mesero.getNombre());
                System.out.println("Dirección: " + mesero.getDireccion());
                System.out.println("Edad: " + mesero.getEdad());
                System.out.println("Sucursal: " + mesero.getSucursal());
                System.out.println("Fecha de Contratación: " + mesero.getFechaDeContratacion());
                System.out.println("sueldo: " + mesero.getSueldo());
                return;
            }
        }

        System.out.println("\nNo se encontró un mesero con el ID especificado.");
    }
}

//menu
public static void menuAdministrativo(DataManager dataManager) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("\nMenú Administrativo:");
        System.out.println("1. Ver Recursos Humanos");
        System.out.println("2. Salir del sistema");
        System.out.print("Seleccione una opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        switch (opcion) {
            case 1:
                menuRecursosHumanos(dataManager);
                break;
            case 2:
                System.out.println("Saliendo del sistema...");
                return; // Salir del menú administrativo
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }
    }
}
public static void menuRecursosHumanos(DataManager dataManager) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.println("\nMenú de Recursos Humanos:");
        System.out.println("1. Ver meseros");
        System.out.println("2. buscar mesero");
        System.out.println("3. Contratar mesero");
        System.out.println("4. Despedir mesero");
        System.out.println("5. Regresar al menú administrativo");
        System.out.print("Seleccione una opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        switch (opcion) {
            case 1:
                verMeseros(dataManager);
                break;
            case 2:
                buscarMesero(dataManager);
                break;
            case 3:
                contratarMesero(dataManager);
                break;
            case 4:
                despedirMesero(dataManager);
                break;
            case 5:
                return; // Salir del menú de Recursos Humanos
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }
    }



}
}

