package modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    
    private List<Producto> productos;
    private Domicilio domicilio;
    private EstadoPedido estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaEntrega;
    private double subtotal;
    private double costoEnvio;
    private double descuento;
    private double total;
    private String notas;
    private Cliente cliente;
    private Repartidor repartidor;
    private List<Incidencia> incidencias;

    public Pedido(int id, List<Producto> productos, Domicilio domicilio, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.productos = productos;
        this.domicilio = domicilio;
        this.estado = EstadoPedido.RECIBIDO;
        this.fechaCreacion = LocalDateTime.now();
        this.incidencias = new ArrayList<>();
        this.calcularCostos();
    }
    
    public void aplicarRecargo(double recargo) {
        this.total += recargo; // Aumentar el total con el recargo
    }

    private void calcularCostos() {
        // Calcular subtotal de productos
        this.subtotal = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
        
         // Obtener el costo de envío desde el barrio asociado al domicilio
         if (domicilio != null && domicilio.getBarrio() != null) {
            this.costoEnvio = domicilio.getBarrio().getCostoEnvio();
            System.out.println("Costo de envío aplicado: " + this.costoEnvio);
        } else {
            this.costoEnvio = 0;
        }
        
        // Calcular total
        this.total = this.subtotal + this.costoEnvio - this.descuento;
    }

    public void aplicarDescuento(double descuento) {
        this.descuento = descuento;
        calcularCostos();
    }

    public void agregarIncidencia(Incidencia incidencia) {
        this.incidencias.add(incidencia);
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDateTime fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public List<Incidencia> getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(List<Incidencia> incidencias) {
        this.incidencias = incidencias;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

}
