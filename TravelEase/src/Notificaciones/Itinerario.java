package Notificaciones;

import java.util.ArrayList;

public class Itinerario {

    public static ArrayList<Itinerario> listaItinerarios = new ArrayList<>();
    public String horario;
    public String descripcion;

    public Itinerario(String horario, String descripcion) {
        this.horario = horario;
        this.descripcion = descripcion;
        listaItinerarios.add(this);
    }

    public String getHorario() {
        return horario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}