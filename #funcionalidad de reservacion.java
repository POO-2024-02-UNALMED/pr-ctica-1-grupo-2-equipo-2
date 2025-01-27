
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Mesa {
    private int numero;
    private int capacidad;
    private boolean reservada;

    public Mesa(int numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.reservada = false;
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public boolean isReservada() {
        return reservada;
    }

    public void reservar() {
        this.reservada = true;
    }

    public void liberar() {
        this.reservada = false;
    }
}

class Reservacion {
    private LocalDateTime fechaHora;
    private int cantidadPersonas;
    private Mesa mesa;

    public Reservacion(LocalDateTime fechaHora, int cantidadPersonas, Mesa mesa) {
        this.fechaHora = fechaHora;
        this.cantidadPersonas = cantidadPersonas;
        this.mesa = mesa;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }
}

class Restaurante {
    private List<Mesa> mesas;
    private List<Reservacion> reservaciones;

    public Restaurante() {
        mesas = new ArrayList<>();
        reservaciones = new ArrayList<>();
        // Inicializar mesas
        for (int i = 1; i <= 10; i++) {
            mesas.add(new Mesa(i, 4)); // 10 mesas, cada una con capacidad para 4 personas
        }
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void realizarReservacion(LocalDateTime fechaHora, int cantidadPersonas, int numeroMesa) {
        Mesa mesa = mesas.get(numeroMesa - 1);
        if (!mesa.isReservada() && cantidadPersonas <= mesa.getCapacidad()) {
            Reservacion reservacion = new Reservacion(fechaHora, cantidadPersonas, mesa);
            reservaciones.add(reservacion);
            mesa.reservar();
            System.out.println("Reservación realizada para " + cantidadPersonas + " personas en la mesa " + mesa.getNumero());
        } else {
            System.out.println("No se puede realizar la reservación. Mesa ocupada o capacidad excedida.");
        }
    }

    public void cancelarReservacion(int numeroMesa) {
        for (Reservacion reservacion : reservaciones) {
            if (reservacion.getMesa().getNumero() == numeroMesa) {
                reservaciones.remove(reservacion);
                reservacion.getMesa().liberar();
                System.out.println("Reservación cancelada para la mesa " + numeroMesa);
                return;
            }
        }
        System.out.println("No se encontró una reservación para la mesa " + numeroMesa);
    }

    public void aplazarReservacion(int numeroMesa, LocalDateTime nuevaFechaHora) {
        for (Reservacion reservacion : reservaciones) {
            if (reservacion.getMesa().getNumero() == numeroMesa) {
                reservaciones.remove(reservacion);
                reservacion.getMesa().liberar();
                realizarReservacion(nuevaFechaHora, reservacion.getCantidadPersonas(), numeroMesa);
                return;
            }
        }
        System.out.println("No se encontró una reservación para la mesa " + numeroMesa);
    }

    public void modificarCantidadPersonas(int numeroMesa, int nuevaCantidad) {
        for (Reservacion reservacion : reservaciones) {
            if (reservacion.getMesa().getNumero() == numeroMesa) {
                if (nuevaCantidad <= reservacion.getMesa().getCapacidad()) {
                    reservacion.setCantidadPersonas(nuevaCantidad);
                    System.out.println("Cantidad de personas modificada a " + nuevaCantidad + " para la mesa " + numeroMesa);
                } else {
                    System.out.println("No se puede modificar la cantidad. Excede la capacidad de la mesa.");
                }
                return;
            }
        }
    }
}