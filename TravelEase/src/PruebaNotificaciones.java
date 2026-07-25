
import Notificaciones.*;
import Personas.Administrador;

public class PruebaNotificaciones {
    public static void main(String[] args) {

        Notificador notificador = new Notificador();

        Administrador admin = new Administrador("Admin1", "admin1@travelEase.com");

        
        UsuariosNotificados usuario1 = new EmailNotificado("gaguille@espo.edu.com");
        UsuariosNotificados usuario2 = new EmailNotificado("jaenguica@hitmail.com");

        UsuariosNotificados usuario3 = new AppNotificado("UsuarioApp1");
        UsuariosNotificados usuario4 = new AppNotificado("UsuarioApp2");

        
        notificador.agregarUsuario(usuario1);
        notificador.agregarUsuario(usuario2);
        notificador.agregarUsuario(usuario3);
        notificador.agregarUsuario(usuario4);

        
        admin.gestionarPoliticas(notificador, "P001", "Nueva política de cancelación: 24 horas antes del vuelo.");
        admin.gestionarItinerario(notificador, "10:00 AM", "Vuelo a quito");
        admin.gestionarReembolsos(notificador, "R001", "Aprobado", "Solicitud de reembolso aprobada por el administrador.");
    }
}
