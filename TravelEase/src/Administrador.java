import Notificaciones.Notificador;
import Notificaciones.Politicas;
import Notificaciones.Itinerario;

public class Administrador extends Persona {
    
    public String idAdministrador;
    private Notificador notificador;


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

    public void gestionerpoliticas(Notificador notificador, String idPolitica, String cambio) {
        for (Politicas p : Politicas.listaPoliticas) {
            if (p.getIdPolitica().equals(idPolitica)) {
                p.setDescripcion(cambio);
            }
        }
        notificador.notificar("La política " + idPolitica + " ha sido modificada por el administrador " + getNombre() + ".");
    }

    public void gestionerItinerario(Notificador notificador, String horario, String descripcion) {
        if (horario == null){
            System.out.println("Horario invalido");
        }else{
            for (Itinerario i : Itinerario.listaItinerarios) {
                if (i.getHorario().equals(horario)) {
                    i.setDescripcion(descripcion);
                }
            }
        }
        notificador.notificar("El itinerario con horario " + horario + " ha sido modificado por el administrador " + getNombre() + ".");
    }

    public void gestionarReembolsos(Notificador notificador, String estadoReembolso) {
        // Lógica de gestión..
        notificador.notificar("Estado de reembolso actualizado: " + estadoReembolso);
    }

}
