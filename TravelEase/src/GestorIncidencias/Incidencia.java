package GestorIncidencias;
import Reservas.*;
public class Incidencia {
    private String idReporte;
    private String descripcion;
    private Reserva reserva;
    public Incidencia(String idReporte, String descripcion, Reserva reserva) {
        this.idReporte = idReporte;
        this.descripcion = descripcion;
        this.reserva = reserva;
    }
    public String getIdReporte() {
        return idReporte;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public Reserva getReserva() {
        return reserva;
    }

    
    
}
