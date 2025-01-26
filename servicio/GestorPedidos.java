package servicio;

import modelo.*;
import baseDatos.DataManager;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class GestorPedidos {
    private DataManager dataManager;
    private static final LocalTime HORA_INICIO = LocalTime.of(8, 0);
    private static final LocalTime HORA_CIERRE = LocalTime.of(22, 0);
    private static final double RECARGO_HORA_PICO = 1.2;

    public GestorPedidos(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public Pedido crearPedido(Cliente cliente, List<Producto> productos, Barrio barrioSeleccionado) throws Exception {
        // Validar horario de servicio
        LocalTime horaActual = LocalTime.now();
        if (horaActual.isBefore(HORA_INICIO) || horaActual.isAfter(HORA_CIERRE)) {
            throw new Exception("Fuera del horario de servicio (8:00 - 22:00)");
        }
    
        // Validar disponibilidad de productos
        for (Producto producto : productos) {
            if (!dataManager.verificarDisponibilidadProducto(producto.getId())) {
                throw new Exception("Producto no disponible: " + producto.getNombre());
            }
        }
    
        // Validar que el barrio sea válido
        if (barrioSeleccionado == null) {
            throw new Exception("El barrio seleccionado no es válido.");
        }
    
        // Asignar repartidor según barrio
        Repartidor repartidor = asignarRepartidorDisponible();
        if (repartidor == null) {
            throw new Exception("No hay repartidores disponibles para el barrio seleccionado.");
        }
    
        // Crear el domicilio asociado al barrio
        Domicilio domicilio = new Domicilio(barrioSeleccionado, repartidor, null);
        domicilio.setBarrio(barrioSeleccionado);
    
        // Crear el pedido
        int idPedido = dataManager.getNextPedidoId();
        Pedido pedido = new Pedido(idPedido, productos, domicilio, cliente);
    
        // Aplicar descuentos si corresponde
        aplicarDescuentos(pedido, cliente);
    
        // Aplicar recargos por hora pico si corresponde
        if (esHoraPico()) {
            aplicarRecargoPico(pedido);
        }
    
        // Registrar el pedido
        dataManager.agregarPedido(cliente, pedido);
    
        return pedido;
    }
    
    private Repartidor asignarRepartidorDisponible() {
        return dataManager.getRepartidores().stream()
            .filter(Repartidor::isDisponible)
            .findFirst()
            .orElse(null);
    }
     
    private boolean esHoraPico() {
        LocalTime hora = LocalTime.now();
        return (hora.isAfter(LocalTime.of(12, 0)) && hora.isBefore(LocalTime.of(14, 0))) ||
               (hora.isAfter(LocalTime.of(19, 0)) && hora.isBefore(LocalTime.of(21, 0)));
    }

    private void aplicarRecargoPico(Pedido pedido) {
        double recargoTotal = pedido.getTotal() * (RECARGO_HORA_PICO - 1);
        pedido.aplicarRecargo(recargoTotal);
    }

    private void aplicarDescuentos(Pedido pedido, Cliente cliente) {
        // Descuento por cliente frecuente (más de 10 pedidos en el último mes)
        if (esClienteFrecuente(cliente)) {
            pedido.aplicarDescuento(pedido.getSubtotal() * 0.1); // 10% de descuento
        }
    }

    private boolean esClienteFrecuente(Cliente cliente) {
        LocalDateTime unMesAtras = LocalDateTime.now().minusMonths(1);
        return cliente.getHistorialPedidos().stream()
                .filter(p -> p.getFechaCreacion().isAfter(unMesAtras))
                .count() > 10;
    }

    public void actualizarEstadoPedido(Pedido pedido, EstadoPedido nuevoEstado) {
        EstadoPedido estadoAnterior = pedido.getEstado();
        pedido.setEstado(nuevoEstado);
        
        // Notificar cambio de estado
        notificarCambioEstado(pedido, estadoAnterior, nuevoEstado);
        
        // Si el pedido se entrega, liberar al repartidor
        if (nuevoEstado == EstadoPedido.ENTREGADO) {
            pedido.getDomicilio().getRepartidor().setDisponible(true);
            pedido.setFechaEntrega(LocalDateTime.now());
        }
    }

    private void notificarCambioEstado(Pedido pedido, EstadoPedido estadoAnterior, EstadoPedido nuevoEstado) {
        // Aquí iría la lógica de notificaciones (SMS, email, etc.)
        System.out.println("Pedido " + pedido.getId() + " cambió de estado: " + 
                          estadoAnterior + " -> " + nuevoEstado);
    }

}