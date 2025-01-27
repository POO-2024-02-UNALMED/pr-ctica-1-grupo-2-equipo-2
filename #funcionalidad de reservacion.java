#funcionalidad de reservacion
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Reserva {
    private String nombreCliente;
    private Date fechaReserva;
    private String horario; // "dia" o "noche"
    private int numeroPersonas;
    private boolean esMesa; // true si es una mesa, false si es todo el establecimiento
    private String tipoEvento; // "fiesta", "cumpleaños", etc.
    private boolean conPersonal; // true si se requiere personal del restaurante

    public Reserva(String nombreCliente, Date fechaReserva, String horario, int numeroPersonas, boolean esMesa, String tipoEvento, boolean conPersonal) {
        this.nombreCliente = nombreCliente;
        this.fechaReserva = fechaReserva;
        this.horario = horario;
        this.numeroPersonas = numeroPersonas;
        this.esMesa = esMesa;
        this.tipoEvento = tipoEvento;
        this.conPersonal = conPersonal;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public String getHorario() {
        return horario;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public boolean isEsMesa() {
        return esMesa;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public boolean isConPersonal() {
        return conPersonal;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "nombreCliente='" + nombreCliente + '\'' +
                ", fechaReserva=" + fechaReserva +
                ", horario='" + horario + '\'' +
                ", numeroPersonas=" + numeroPersonas +
                ", esMesa=" + esMesa +
                ", tipoEvento='" + tipoEvento + '\'' +
                ", conPersonal=" + conPersonal +
                '}';
    }
}

class Restaurante {
    private List<Reserva> reservas;
    private List<String> catalogoMesas;

    public Restaurante() {
        this.reservas = new ArrayList<>();
        this.catalogoMesas = new ArrayList<>();
        inicializarCatalogoMesas();
    }

    private void inicializarCatalogoMesas() {
        for (int i = 1; i <= 10; i++) {
            catalogoMesas.add("Mesa " + i);
        }
    }

    public void realizarReserva(String nombreCliente, Date fechaReserva, String horario, int numeroPersonas, boolean esMesa, String tipoEvento, boolean conPersonal) {
        Reserva nuevaReserva = new Reserva(nombreCliente, fechaReserva, horario, numeroPersonas, esMesa, tipoEvento, conPersonal);
        reservas.add(nuevaReserva);
        System.out.println("Reserva realizada: " + nuevaReserva);
    }

    public void cancelarReserva(String nombreCliente) {
        boolean encontrado = reservas.removeIf(reserva -> reserva.getNombreCliente().equalsIgnoreCase(nombreCliente));
        if (encontrado) {
            System.out.println("Reserva cancelada para el cliente: " + nombreCliente);
        } else {
            System.out.println("No se encontró reserva para el cliente: " + nombreCliente);
        }
    }

    public void aplazarReserva(String nombreCliente, Date nuevaFecha) {
        for (Reserva reserva : reservas) {
            if (reserva.getNombreCliente().equalsIgnoreCase(nombreCliente)) {
                reservas.remove(reserva);
                realizarReserva(nombreCliente, nuevaFecha, reserva.getHorario(), reserva.getNumeroPersonas(), reserva.isEsMesa(), reserva.getTipoEvento(), reserva.isConPersonal());
                return;
            }
        }
        System.out.println("No se encontró reserva para el cliente: " + nombreCliente);
    }

    public void mostrarCatalogoMesas() {
        System.out.println("Catálogo de Mesas:");
        for (String mesa : catalogoMesas) {
            System.out.println(mesa);
        }
    }

    public void mostrarReservas() {
        System.out.println("Reservas actuales:");
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas.");
        } else {
            for (Reserva reserva : reservas) {
                System.out.println(reserva);
            }
        }
    }

    public List<String> getCatalogoMesas() {
        return catalogoMesas;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
}