package Notificaciones;

import java.util.ArrayList;

public class Politicas {

    public static ArrayList<Politicas> listaPoliticas = new ArrayList<>();
    public String Titulo;
    public String Descripcion;
    public String idPolitica;

    public Politicas(String titulo, String descripcion, String idPolitica) {
        this.Titulo = titulo;
        this.Descripcion = descripcion;
        this.idPolitica = idPolitica;
        listaPoliticas.add(this);
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getIdPolitica() {
        return idPolitica;
    }
}
