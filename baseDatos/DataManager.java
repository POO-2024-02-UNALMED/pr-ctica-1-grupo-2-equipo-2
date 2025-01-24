package baseDatos;

import modelo.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class DataManager implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Cliente> clientes;
    private List<Producto> productos;
    private List<Repartidor> repartidores;
    private List<Pedido> pedidos;
    private List<Zona> zonas;
    private List<Incidencia> incidencias;
    private AtomicInteger nextPedidoId;
    private AtomicInteger nextIncidenciaId;
    private List<Domicilio> domicilios;
    private List<Administrativo> admins;
    private List<Sucursal> sucursales;
    private final Barrio[] ciudad;

    public DataManager() {
        this.clientes = new ArrayList<>();
        this.productos = new ArrayList<>();
        this.repartidores = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.zonas = new ArrayList<>();
        this.incidencias = new ArrayList<>();
        this.domicilios = new ArrayList<>();
        this.admins = new ArrayList<>();
        this.nextPedidoId = new AtomicInteger(1);
        this.nextIncidenciaId = new AtomicInteger(1);
        this.sucursales = new ArrayList<Sucursal>();
        this.ciudad = new Barrio[16];
        cargarDatosPrueba();
    }

    private void cargarDatosPrueba() {
        // Zonas de prueba
        zonas.add(new Zona(1, "Centro", 2.99, true));
        zonas.add(new Zona(2, "Norte", 3.99, true));
        zonas.add(new Zona(3, "Sur", 3.99, true));

        // Repartidores de prueba con zonas asignadas
        Repartidor repartidor1 = new Repartidor(1, "Juan Pérez", true);
        repartidor1.setCalificacionPromedio(4.5);
        repartidor1.getZonasAsignadas().add(zonas.get(0));
        repartidor1.getZonasAsignadas().add(zonas.get(1));

        Repartidor repartidor2 = new Repartidor(2, "María García", true);
        repartidor2.setCalificacionPromedio(4.8);
        repartidor2.getZonasAsignadas().add(zonas.get(1));
        repartidor2.getZonasAsignadas().add(zonas.get(2));

        repartidores.add(repartidor1);
        repartidores.add(repartidor2);

        // Productos de prueba con stock
        productos.add(new Producto(1, "Pizza Margherita", 12.99, 20));
        productos.add(new Producto(2, "Hamburguesa Clásica", 8.99, 15));
        productos.add(new Producto(3, "Ensalada César", 7.99, 10));
        productos.add(new Producto(4, "Pasta Alfredo", 10.99, 12));
        productos.add(new Producto(5, "Refresco", 2.99, 50));

        // Admins de prueba
        admins.add(new Administrativo("Lionel Messi", 12345, 4488123));
        admins.add(new Administrativo("Elena Nito", 10453, 4488123));
        admins.add(new Administrativo("Alma Marcela Gozo", 42012, 4488123));

        // Barrios habilitados
        int[] a = {-8, -4};
        int[] b = {-4, 0};
        int[] c = {0, 4};
        int[] d = {4, 8};
        ciudad[0] = new Barrio("La Estrella", a, d);
        ciudad[1] = new Barrio("Sabaneta", b, d);
        ciudad[2] = new Barrio("Itagüí", c, d);
        ciudad[3] = new Barrio("Envigado", d, d);
        ciudad[4] = new Barrio("Robledo", d, c);
        ciudad[5] = new Barrio("Bello", c, c);
        ciudad[6] = new Barrio("Poblado", b, c);
        ciudad[7] = new Barrio("Niquía", a, c);
        ciudad[8] = new Barrio("Alpujarra", a, b);
        ciudad[9] = new Barrio("Cisneros", b, b);
        ciudad[10] = new Barrio("San Antonio", c, b);
        ciudad[11] = new Barrio("Parque Berrío", d, b);
        ciudad[12] = new Barrio("Prado", d, a);
        ciudad[13] = new Barrio("Caribe", c, a);
        ciudad[14] = new Barrio("Acevedo", b, a);
        ciudad[15] = new Barrio("Madera", a, a);

        // Sucursales de prueba nuevaSucusal
        int[] x = {-3, -3};
        int[] y = {5, 3};
        int[] z = {2, 6};
        sucursales.add(new Sucursal(1, "Cisneros", 35, x, 57000000, "auto"));
        sucursales.add(new Sucursal(2, "Robledo", 30, y, 48000000, "auto"));
        sucursales.add(new Sucursal(3, "Sabaneta", 30, z, 44000000, "auto"));
        ciudad[9].setSucursal(true);
        ciudad[4].setSucursal(true);
        ciudad[1].setSucursal(true);

    }


    // Métodos para gestionar clientes
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarPedido(Cliente cliente, Pedido pedido) throws Exception {
        pedidos.add(pedido);
        cliente.agregarPedido(pedido);
    
        for (Producto producto : pedido.getProductos()) {
            if (producto == null) {
                // Si el producto es null, lanzar una excepción con un mensaje adecuado
                throw new Exception("Producto desconocido en el pedido.");
            }
    
            if (verificarDisponibilidadProducto(producto.getId())) {
                if (producto.getStock() > 0) {
                    // Actualizar el stock si hay suficiente cantidad
                    actualizarStockProducto(producto.getId(), -1);
                } else {
                    // Si el stock es insuficiente, lanzar una excepción con el nombre del producto
                    throw new Exception("No hay suficiente stock para el producto: " + producto.getNombre());
                }
            } else {
                // Si el producto no está disponible, lanzar una excepción
                throw new Exception("El producto con ID " + producto.getId() + " no está disponible.");
            }
        }
    }

    public Cliente buscarClientePorId(int id) {
        return clientes.stream()
                .filter(cliente -> cliente.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Métodos para gestionar productos
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public Producto buscarProductoPorId(int id) {
        return productos.stream()
                .filter(producto -> producto.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean verificarDisponibilidadProducto(int productoId) {
        Producto producto = buscarProductoPorId(productoId);
        return producto != null && producto.getStock() > 0;
    }

    public void actualizarStockProducto(int productoId, int cantidad) {
        Producto producto = buscarProductoPorId(productoId);
        if (producto != null) {
            producto.actualizarStock(cantidad);
        }
    }

    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }

    // Métodos para gestionar repartidores
    public void agregarRepartidor(Repartidor repartidor) {
        repartidores.add(repartidor);
    }

    public Repartidor asignarRepartidorDisponible() {
        return repartidores.stream()
                .filter(Repartidor::isDisponible)
                .findFirst()
                .orElse(null);
    }

    public List<Repartidor> getRepartidores() {
        return new ArrayList<>(repartidores);
    }

    // Métodos para gestionar zonas
    public List<Zona> getZonas() {
        return new ArrayList<>(zonas);
    }

    public Zona getZonaPorId(int id) {
        return zonas.stream()
                .filter(zona -> zona.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Métodos para gestionar pedidos e incidencias
    public List<Pedido> getPedidos() {
        return new ArrayList<>(pedidos);
    }

    public void registrarIncidencia(Incidencia incidencia) {
        incidencias.add(incidencia);
    }

    public List<Incidencia> getIncidencias() {
        return new ArrayList<>(incidencias);
    }

    // Generadores de IDs
    public int getNextPedidoId() {
        return nextPedidoId.getAndIncrement();
    }

    public int getNextIncidenciaId() {
        return nextIncidenciaId.getAndIncrement();
    }

    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes);
    }
    
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    public void setRepartidores(List<Repartidor> repartidores) {
        this.repartidores = repartidores;
    }
    
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    public void setZonas(List<Zona> zonas) {
        this.zonas = zonas;
    }
    
    public void setIncidencias(List<Incidencia> incidencias) {
        this.incidencias = incidencias;
    }
    
    public void setNextPedidoId(AtomicInteger nextPedidoId) {
        this.nextPedidoId = nextPedidoId;
    }
    
    public void setNextIncidenciaId(AtomicInteger nextIncidenciaId) {
        this.nextIncidenciaId = nextIncidenciaId;
    }

    public List<Domicilio> getDomicilios() {
        return domicilios;
    }

    // Retorna una lista de pedidos vigentes (que no estén finalizados o cancelados)
    public List<Pedido> getPedidosVigentes() {
        return pedidos.stream()
                .filter(pedido -> pedido.getEstado() != EstadoPedido.CANCELADO && pedido.getEstado() != EstadoPedido.ENTREGADO)
                .collect(Collectors.toList());
    }

    // Busca un pedido por su ID
    public Pedido buscarPedidoPorId(int id) {
        return pedidos.stream()
                .filter(pedido -> pedido.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Busca un repartidor por su ID
    public Repartidor buscarRepartidorPorId(int id) {
        return repartidores.stream()
                .filter(repartidor -> repartidor.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    // Método adicional para agregar pedidos
    public void agregarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public List<Repartidor> getRepartidoresDisponibles() {
        // Ejemplo: Obtener repartidores disponibles desde una base de datos o lista
        return repartidores.stream()
                .filter(Repartidor::isDisponible)
                .collect(Collectors.toList());
    }
    public List<Administrativo> getAdmins(){
        return admins;
    }

    public List<Sucursal> getSucursales(){return sucursales;}

    public Barrio[] getCiudad(){return ciudad;}

    public void addSucursal(Sucursal sucursal){sucursales.add(sucursal);}

    public void quitarSucursal(){
        sucursales.remove(0);
    }
}
