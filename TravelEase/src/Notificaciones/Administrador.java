package Notificaciones;

public class Administrador extends Persona {
    
    public String idAdministrador;
    private final Notificador notificador;

    public Administrador(String nombre, String email, String idAdministrador, Notificador notificador) {
        super(nombre, email);
        this.idAdministrador = idAdministrador;
        this.notificador = notificador;
    }

    public String getIdAdmin() {
        return idAdministrador;
    }

    public void setIdAdmin(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public void gestionarPoliticas(String idPolitica, String cambio) {
        for (Politicas p : Politicas.listaPoliticas) {
            if (p.getIdPolitica().equals(idPolitica)) {
                p.setDescripcion(cambio);
            }
        }
        notificador.notificar("La política " + idPolitica + " ha sido modificada por el administrador " + getNombre() + ".");
    }

    public void gestionarItinerario(String horario, String descripcion) {
        if (horario == null){
            System.out.println("Horario invalido");
        }else{
            for (Itinerario i : Itinerario.listaItinerarios) {
                if (i.getHorario().equals(horario)) {
                    i.setDescripcion(descripcion);
                }
            }
            notificador.notificar("El itinerario con horario " + horario + " ha sido modificado por el administrador " + getNombre() + ".");
        }
    }

    public void gestionarReembolsos(String idReembolso, String estadoReembolso, String descripcion) {
        for (Reembolsos r : Reembolsos.listaReembolsos) {
            if (r.getIdReembolso().equals(idReembolso)) {
                r.setEstado(estadoReembolso);
            }
        }
        notificador.notificar("Estado de reembolso actualizado: " + estadoReembolso + "por: " + descripcion);
    }

}
