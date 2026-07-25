package GestorIncidencias;
import Reservas.*;
public class Incidencia {
    private String idReporte;
    private String descripcion;
    private Reserva reserva;
    private String estado; //Ej: "EN REVISION", "ESCALADA", "RESUELTA"

    public Incidencia(String idReporte, String descripcion, Reserva reserva) {
        this.idReporte = idReporte;
        this.descripcion = descripcion;
        this.reserva = reserva;
        this.estado = "EN REVISION";
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
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        if(estado == null || estado.trim().isEmpty()){
            throw new IllegalArgumentException("El estado de la incidencia no puede nulo ni vacio");
        }
        this.estado = estado;
    }
    
}
