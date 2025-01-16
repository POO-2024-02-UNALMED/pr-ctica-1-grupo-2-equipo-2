import modelo.*;
import servicio.GestorPedidos;
import baseDatos.DataManager;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class PedirDomicilio {
    private DataManager dataManager;
    private GestorPedidos gestorPedidos;
    private Domicilio domicilio;
    private final Scanner scanner = new Scanner(System.in);

    public PedirDomicilio(DataManager dataManager) {
        this.dataManager = dataManager;
        this.gestorPedidos = new GestorPedidos(dataManager);
    }

    public void realizarPedido() {
        System.out.println("\n¿Desea realizar un nuevo pedido o ir al menú de gestión?");
        System.out.println("1. Realizar nuevo pedido");
        System.out.println("2. Ir al menú de gestión");
        System.out.print("Seleccione una opción: ");

        int opcion;
        try {
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida. Por favor, ingrese un número.");
            scanner.nextLine(); // Limpiar el buffer
            return;
        }

        if (opcion == 1) {
            try {
                Cliente cliente = seleccionarOcrearCliente(scanner);
                if (cliente == null) {
                    System.out.println("No se pudo registrar el cliente.");
                    return;
                }

                List<Producto> productosSeleccionados = seleccionarProductos(scanner);
                if (productosSeleccionados.isEmpty()) {
                    System.out.println("No se seleccionaron productos.");
                    return;
                }

                String direccionEntrega;
                while (true) {
                    System.out.println("\nDirección registrada: " + cliente.getDireccion());
                    System.out.print("¿Desea usar esta dirección? (S/N): ");
                    String respuesta = scanner.nextLine().trim().toUpperCase();

                    if (respuesta.equals("S")) {
                        direccionEntrega = cliente.getDireccion();
                        break;
                    } else if (respuesta.equals("N")) {
                        System.out.print("Ingrese la nueva dirección de entrega: ");
                        direccionEntrega = scanner.nextLine().trim();
                        if (!direccionEntrega.isEmpty()) {
                            break;
                        }
                    }
                    System.out.println("Por favor, ingrese S o N.");
                }

                try {
                    Pedido pedido = gestorPedidos.crearPedido(cliente, productosSeleccionados, direccionEntrega);
                    mostrarResumenPedido(pedido);
                } catch (Exception e) {
                    System.out.println("Error al crear el pedido: " + e.getMessage());
                }

            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }

        // Redirigir al menú de gestión de pedidos
        gestionarPedidos();
    }

    public void gestionarPedidos() {
        while (true) {
            System.out.println("\n=== Gestión de Pedidos ===");
            System.out.println("1. Crear nuevo pedido");
            System.out.println("2. Ver pedidos vigentes");
            System.out.println("3. Modificar un pedido");
            System.out.println("4. Cancelar un pedido");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion;
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine(); // Limpiar el buffer
                continue;
            }

            switch (opcion) {
                case 1:
                    crearNuevoPedido(scanner);
                    break;
                case 2:
                    verPedidosVigentes();
                    break;
                case 3:
                    modificarPedido(scanner);
                    break;
                case 4:
                    cancelarPedido(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo de la gestión de pedidos.");
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }


    private void crearNuevoPedido(Scanner scanner) {
        System.out.println("\n=== Crear Nuevo Pedido ===");
        try {
            Cliente cliente = seleccionarOcrearCliente(scanner);
            if (cliente == null) {
                System.out.println("No se pudo registrar el cliente.");
                return;
            }

            List<Producto> productosSeleccionados = seleccionarProductos(scanner);
            if (productosSeleccionados.isEmpty()) {
                System.out.println("No se seleccionaron productos.");
                return;
            }

            String direccionEntrega;
            while (true) {
                System.out.println("\nDirección registrada: " + cliente.getDireccion());
                System.out.print("¿Desea usar esta dirección? (S/N): ");
                String respuesta = scanner.nextLine().trim().toUpperCase();

                if (respuesta.equals("S")) {
                    direccionEntrega = cliente.getDireccion();
                    break;
                } else if (respuesta.equals("N")) {
                    System.out.print("Ingrese la nueva dirección de entrega: ");
                    direccionEntrega = scanner.nextLine().trim();
                    if (!direccionEntrega.isEmpty()) {
                        break;
                    }
                }
                System.out.println("Por favor, ingrese S o N.");
            }

            try {
                Pedido pedido = gestorPedidos.crearPedido(cliente, productosSeleccionados, direccionEntrega);
                mostrarResumenPedido(pedido);
            } catch (Exception e) {
                System.out.println("Error al crear el pedido: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    public void verPedidosVigentes() {
        List<Pedido> pedidosVigentes = dataManager.getPedidosVigentes();
        
        if (pedidosVigentes.isEmpty()) {
            System.out.println("\nNo hay pedidos vigentes.");
            return;
        }
        
        System.out.println("\n=== Pedidos Vigentes ===");
        for (Pedido pedido : pedidosVigentes) {
            // Verificar si el pedido está cancelado
            if (pedido.getEstado() == EstadoPedido.CANCELADO) {
                continue; // Ignorar pedidos cancelados
            }
    
            // Verificar si el pedido tiene cliente asignado
            if (pedido.getCliente() == null) {
                System.out.println("Advertencia: Pedido con ID " + pedido.getId() + " no tiene cliente asignado.");
                continue; // Ignorar pedidos sin cliente asignado
            }
    
            System.out.println("Pedido ID: " + pedido.getId());
            System.out.println("Cliente: " + pedido.getCliente().getNombre());
            System.out.println("Productos:");
    
            // Mostrar solo los nombres de los productos
            for (Producto producto : pedido.getProductos()) {
                System.out.println("- " + producto.getNombre());
            }
    
            // Accede a la dirección desde el domicilio del pedido
            System.out.println("Dirección: " + pedido.getDomicilio().getDireccion());
            System.out.println("Estado: " + pedido.getEstado());
            System.out.println("------------------------------------");
        }
    }
    
    
    
    private void modificarPedido(Scanner scanner) {
        System.out.println("\n=== Modificar Pedido ===");
        System.out.print("Ingrese el ID del pedido a modificar: ");
        int pedidoId = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Pedido pedido = dataManager.buscarPedidoPorId(pedidoId);
        if (pedido == null) {
            System.out.println("Pedido no encontrado.");
            return;
        }

        while (true) {
            System.out.println("\nPedido ID: " + pedido.getId());
            System.out.println("1. Cambiar estado");
            System.out.println("2. Asignar repartidor");
            System.out.println("3. Modificar productos");
            System.out.println("4. Añadir incidencia");
            System.out.println("5. Volver");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    cambiarEstadoPedido(pedido, scanner);
                    break;
                case 2:
                    asignarRepartidor(pedido, scanner);
                    break;
                case 3:
                    modificarProductos(pedido, scanner);
                    break;
                case 4:
                    agregarIncidencia(pedido, scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private void cancelarPedido(Scanner scanner) {
        System.out.println("\n=== Cancelar Pedido ===");
        System.out.print("Ingrese el ID del pedido a cancelar: ");
        int pedidoId = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
    
        Pedido pedido = dataManager.buscarPedidoPorId(pedidoId);
        if (pedido == null) {
            System.out.println("Pedido no encontrado.");
            return;
        }
    
        pedido.setEstado(EstadoPedido.CANCELADO);
        System.out.println("El pedido ha sido cancelado.");
    }    

    private void cambiarEstadoPedido(Pedido pedido, Scanner scanner) {
        System.out.println("\nEstados disponibles:");
        for (EstadoPedido estado : EstadoPedido.values()) {
            System.out.println(estado.getCodigo() + ". " + estado.getDescripcion());
        }
        System.out.print("Seleccione el nuevo estado: ");
        int codigoEstado = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        EstadoPedido nuevoEstado = EstadoPedido.fromCodigo(codigoEstado);
        if (nuevoEstado != null) {
            pedido.setEstado(nuevoEstado);
            System.out.println("Estado actualizado a: " + nuevoEstado.getDescripcion());
        } else {
            System.out.println("Estado no válido.");
        }
    }

    private void asignarRepartidor(Pedido pedido, Scanner scanner) {
        System.out.println("\n=== Asignar Repartidor ===");
        List<Repartidor> repartidores = dataManager.getRepartidoresDisponibles();
        if (repartidores.isEmpty()) {
            System.out.println("No hay repartidores disponibles.");
            return;
        }

        for (Repartidor repartidor : repartidores) {
            System.out.println(repartidor.getId() + ". " + repartidor.getNombre());
        }
        System.out.print("Seleccione el ID del repartidor: ");
        int repartidorId = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Repartidor repartidor = dataManager.buscarRepartidorPorId(repartidorId);
        if (repartidor != null) {
            pedido.setRepartidor(repartidor);
            System.out.println("Repartidor asignado: " + repartidor.getNombre());
        } else {
            System.out.println("Repartidor no encontrado.");
        }
    }

    private void modificarProductos(Pedido pedido, Scanner scanner) {
        System.out.println("\n=== Modificar Productos ===");
        List<Producto> productosSeleccionados = seleccionarProductos(scanner);
        pedido.setProductos(productosSeleccionados);
        System.out.println("Productos actualizados.");
    }

    private void agregarIncidencia(Pedido pedido, Scanner scanner) {
        System.out.println("\n=== Añadir Incidencia ===");
        System.out.print("Describa la incidencia: ");
        String descripcion = scanner.nextLine().trim();
        pedido.agregarIncidencia(new Incidencia(descripcion));
        System.out.println("Incidencia añadida.");
    }

    private void mostrarResumenPedido(Pedido pedido) {
        System.out.println("\n=== Resumen del Pedido ===");
        System.out.println("ID Pedido: " + pedido.getId());
        System.out.println("\nProductos:");
        for (Producto producto : pedido.getProductos()) {
            System.out.printf("- %s: $%.2f%n", producto.getNombre(), producto.getPrecio());
        }
        System.out.println("\nDetalles de entrega:");
        System.out.println("Dirección: " + pedido.getDomicilio().getDireccion());
        System.out.println("Zona: " + pedido.getDomicilio().getZona().getNombre());
        System.out.println("Repartidor: " + pedido.getDomicilio().getRepartidor().getNombre());
        System.out.println("Tiempo estimado: " + pedido.getDomicilio().getTiempoEstimadoEntrega());
        
        System.out.println("\nCostos:");
        System.out.printf("Subtotal: $%.2f%n", pedido.getSubtotal());
        System.out.printf("Costo de envío: $%.2f%n", pedido.getCostoEnvio());
        if (pedido.getDescuento() > 0) {
            System.out.printf("Descuento aplicado: $%.2f%n", pedido.getDescuento());
        }
        System.out.printf("Total a pagar: $%.2f%n", pedido.getTotal());
        
        System.out.println("\nEstado del pedido: " + pedido.getEstado().getDescripcion());
    }

    private Cliente seleccionarOcrearCliente(Scanner scanner) {
        System.out.print("Ingrese el ID del cliente: ");
        int clienteId = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Cliente cliente = dataManager.buscarClientePorId(clienteId);
        if (cliente == null) {
            System.out.println("Cliente no encontrado. Ingrese los datos para registrarlo.");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Dirección: ");
            String direccion = scanner.nextLine();
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();

            cliente = new Cliente(clienteId, nombre, direccion, telefono);
            dataManager.agregarCliente(cliente);
            System.out.println("Cliente registrado exitosamente.");
        } else {
            System.out.println("Cliente encontrado: " + cliente);
        }
        
        return cliente;
    }

    private List<Producto> seleccionarProductos(Scanner scanner) {
        List<Producto> productosSeleccionados = new ArrayList<>();
        List<Producto> productosDisponibles = dataManager.getProductos();

        if (productosDisponibles.isEmpty()) {
            System.out.println("No hay productos disponibles.");
            return productosSeleccionados;
        }

        System.out.println("\nProductos disponibles:");
        for (Producto producto : productosDisponibles) {
            System.out.println(producto.getId() + ". " + producto.getNombre() + " - $" + producto.getPrecio());
        }

        System.out.println("\nIngrese los IDs de los productos que desea (0 para finalizar):");
        while (true) {
            System.out.print("ID del producto: ");
            int productoId = scanner.nextInt();
            if (productoId == 0) break;

            Producto producto = dataManager.buscarProductoPorId(productoId);
            if (producto != null) {
                productosSeleccionados.add(producto);
                System.out.println(producto.getNombre() + " añadido al pedido.");
            } else {
                System.out.println("Producto no encontrado. Intente nuevamente.");
            }
        }
        return productosSeleccionados;
    }

}
