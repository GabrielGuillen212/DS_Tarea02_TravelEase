package Notificaciones;

import java.util.ArrayList;

public class Reembolsos {

    public static ArrayList<Reembolsos> listaReembolsos = new ArrayList<>();
    public String idReembolso;
    public String estado;
    public String descripcion;


    public Reembolsos(String idReembolso, String descripcion) {
        this.idReembolso = idReembolso;
        this.estado = "Pendiente";
        this.descripcion = descripcion;
        listaReembolsos.add(this);
    }

    public String getIdReembolso() {
        return idReembolso;
    }

    public String getEstado() {
        return estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "idReembolso: " + idReembolso + " - estado: " + estado + " - descripcion: " + descripcion;
    }
}
