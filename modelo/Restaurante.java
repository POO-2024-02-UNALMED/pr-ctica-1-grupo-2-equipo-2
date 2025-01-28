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
                }
            }
        }
        // Verificar si hay espacio disponible en el array

        if (!conEspacio.isEmpty()) { // Encontrar la primera posición vacía
            // Solicitar datos al usuario
            System.out.print("Ingrese el ID del mesero: ");
            int id = scanner.nextInt();
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
                System.out.println(i + ". " + conEspacio.get(i));
                i++;
            }
            System.out.print("\nIngrese la sucursal del mesero: ");
            int nombreSucursal = Entrada.input();
            while(nombreSucursal < 1 || nombreSucursal > i){
                nombreSucursal = Entrada.input();
                if(nombreSucursal < 1 || nombreSucursal > i){
                    System.out.println("Opción no disponible");
            }

            Sucursal sucursal = sucursales.get(nombreSucursal-1);

            System.out.print("Ingrese la experiencia del mesero (en años): ");
            int antiguedad = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            System.out.print("Ingrese la fecha de contratación (YYYY-MM-DD): ");
            String fechaDeContratacion = scanner.nextLine();

            // Crear y agregar el mesero al array
            sucursal = new Mesero(id, nombre, direccion, edad, sucursal, antiguedad, fechaDeContratacion);
            System.out.println("Mesero contratado exitosamente");
            return; // Salir después de contratar
        }

        System.out.println("No hay espacio disponible para contratar más meseros.");
    }

    // Método para mostrar todos los meseros
    public static void verMeseros() {
        System.out.println("Lista de meseros contratados:");
        for (int i = 0; i < meseros.length; i++) {
            if (meseros[i] != null) {
                System.out.println("- ID: " + meseros[i].getId() +
                                   ", Nombre: " + meseros[i].getNombre() +
                                   ", Sucursal: " + meseros[i].getSucursal().getUbicacion() +
                                   ", Fecha de contratación: " + meseros[i].getFechaDeContratacion()+
                                   ", sueldo del mesero: " + meseros[i].getSueldo());
            }
        }
    }
    public static void despedirMesero() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del mesero a despedir: ");
        int id = scanner.nextInt();

        for (int i = 0; i < meseros.length; i++) {
            if (meseros[i] != null && meseros[i].getId() == id) {
                System.out.println("Mesero despedido: " + meseros[i].getNombre());
                meseros[i] = null; // Eliminar al mesero del array
                return;
            }
        }
        System.out.println("Mesero no encontrado.");
    }

    // Método para un mesero especifico
public static void buscarMesero() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese el ID del mesero que desea buscar: ");
    int id = scanner.nextInt();

    for (int i = 0; i < meseros.length; i++) {
        if (meseros[i] != null && meseros[i].getId() == id) {
            System.out.println("\n Mesero encontrado:");
            System.out.println("ID: " + meseros[i].getId());
            System.out.println("Nombre: " + meseros[i].getNombre());
            System.out.println("Dirección: " + meseros[i].getDireccion());
            System.out.println("Edad: " + meseros[i].getEdad());
            System.out.println("Sucursal: " + meseros[i].getSucursal().getUbicacion());
            System.out.println("Fecha de Contratación: " + meseros[i].getFechaDeContratacion());
            System.out.println("sueldo: " + meseros[i].getSueldo());
            return; 
        }
    }

    System.out.println("\nNo se encontró un mesero con el ID especificado.");
}


//menu
public static void menuAdministrativo() {
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
                menuRecursosHumanos();
                break;
            case 2:
                System.out.println("Saliendo del sistema...");
                return; // Salir del menú administrativo
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }
    }
}
public static void menuRecursosHumanos() {
    Scanner scanner = new Scanner(System.in);
    DataManager dataManager = new DataManager();
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
                verMeseros();
                break;
            case 2:
                buscarMesero();
                break;
            case 3:
                contratarMesero(dataManager);
                break;
            case 4:
                despedirMesero();
                break;
            case 5:
                return; // Salir del menú de Recursos Humanos
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }
    }



}
}

