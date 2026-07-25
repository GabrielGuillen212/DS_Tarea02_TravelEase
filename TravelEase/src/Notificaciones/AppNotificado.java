package Notificaciones;

public class AppNotificado implements UsuariosNotificados {

    private String usuario;

    public AppNotificado(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public void update(String mensaje) {
        System.out.println("Enviando PUSH a la APP de " + usuario + ": " + mensaje);
    }
}
