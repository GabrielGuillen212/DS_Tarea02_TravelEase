package Notificaciones;

import java.util.ArrayList;

public class Reembolsos {

    public static ArrayList<Reembolsos> listaReembolsos = new ArrayList<>();
    public String idReembolso;
    public String estado;
    public String descripcion;


    public Reembolsos(String idReembolso, String estado, String descripcion) {
        this.idReembolso = idReembolso;
        this.estado = estado;
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
}
