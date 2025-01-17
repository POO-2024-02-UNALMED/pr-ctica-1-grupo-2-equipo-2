package baseDatos;

import modelo.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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

    public DataManager() {
        this.clientes = new ArrayList<>();
        this.productos = new ArrayList<>();
        this.repartidores = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.zonas = new ArrayList<>();
        this.incidencias = new ArrayList<>();
        this.domicilios = new ArrayList<>();
        this.nextPedidoId = new AtomicInteger(1);
        this.nextIncidenciaId = new AtomicInteger(1);
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

}