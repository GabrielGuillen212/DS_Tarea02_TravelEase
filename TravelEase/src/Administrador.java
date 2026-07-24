import Notificaciones.notificador;

public class Administrador extends Persona {
    
    String idAdministrador;

    public Administrador(String nombre, String email) {
        super(nombre, email);
    }
    
    public Administrador(String nombre, String email, String idAdministrador) {
        super(nombre, email);
        this.idAdministrador = idAdministrador;
    }

    public String getIdAdmin() {
        return idAdministrador;
    }

    public void setIdAdmin(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public void gestionerpoliticas(Notificador notificador, String politica) {
        
        System.out.println("El administrador " + getNombre() + " está gestionando políticas.");
    }

    public void gestionerItinerario(Notificador notificador, String itinerario) {
        // Lógica de gestión..
        System.out.println("El administrador " + getNombre() + " está gestionando políticas.");
    }

    public void gestionarReembolsos(Notificador notificador, String estadoReembolso) {
        // Lógica de gestión..
        notificador.notificar("Estado de reembolso actualizado: " + estadoReembolso);
    }

}
