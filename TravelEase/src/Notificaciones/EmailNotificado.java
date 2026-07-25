package Notificaciones;

public class EmailNotificado implements UsuariosNotificados {
    private String email;

    public EmailNotificado(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void update(String mensaje) {
        System.out.println("Enviando correo a " + email + ": " + mensaje);
    }
}