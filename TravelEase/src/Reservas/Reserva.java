package Reservas;

public class Reserva {

    private String idReserva;
    private EstadoReserva estado;
    private ServicioReserva servicio;

    public Reserva(String idReserva, ServicioReserva servicio) {
        this.idReserva = idReserva;
        this.servicio = servicio;
        this.estado = EstadoReserva.RESERVADO;
    }

    public ServicioReserva getServicio() {
        return this.servicio;
    }

    public String getIdReserva() {
        return this.idReserva;
    }

    public EstadoReserva getEstado() {
        return this.estado;
    }
}