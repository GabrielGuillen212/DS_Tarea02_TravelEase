package Reservas;


public class Reserva {
    private String idReserva;
    private String estado; // Ej: "RESERVADO", "CONFIRMADO", "CANCELADO"
    private ServicioReserva servicio; 

    public Reserva(String idReserva, ServicioReserva servicio) {
        this.idReserva = idReserva;
        this.servicio = servicio;
        this.estado = "RESERVADO"; 
    }

    public ServicioReserva getServicio() {
        return this.servicio;
    }

    public String getIdReserva() {
        return this.idReserva;
    }

    public String getEstado() {
        return this.estado;
    }

}