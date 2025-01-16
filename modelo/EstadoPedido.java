package modelo;

public enum EstadoPedido {
    RECIBIDO(1, "Recibido"),
    EN_PREPARACION(2, "En preparación"),
    EN_CAMINO(3, "En camino"),
    ENTREGADO(4, "Entregado"),
    CANCELADO(5, "Cancelado");

    private final int codigo;
    private final String descripcion;

    EstadoPedido(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    // Obtiene el código del estado
    public int getCodigo() {
        return codigo;
    }

    // Obtiene un estado desde su código
    public static EstadoPedido fromCodigo(int codigo) {
        for (EstadoPedido estado : values()) {
            if (estado.codigo == codigo) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Código de estado no válido: " + codigo);
    }

    public static EstadoPedido fromString(String estado) {
        switch (estado) {
            case "RECIBIDO": return RECIBIDO;
            case "PREPARANDO": return EN_PREPARACION;
            case "EN_CAMINO": return EN_CAMINO;
            case "ENTREGADO": return ENTREGADO;
            case "CANCELADO": return CANCELADO;
            default: throw new IllegalArgumentException("Estado desconocido: " + estado);
        }
    }

    public String getDescripcion() {
        return descripcion;
    }
    
}