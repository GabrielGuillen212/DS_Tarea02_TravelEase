package Notificaciones;

import java.util.ArrayList;

public class Notificador {

    private ArrayList<UsuariosNotificados> list_User;

    public Notificador() {
        this.list_User = new ArrayList<>();
    }

    public void agregarUsuario(UsuariosNotificados usuario){
        list_User.add(usuario);
    }

    public void quitarUsuario(UsuariosNotificados usuario){
        list_User.remove(usuario);
    }

    public void notificar(String mensaje){
        for(UsuariosNotificados u : list_User){
            u.update(mensaje);
        }
    }

}