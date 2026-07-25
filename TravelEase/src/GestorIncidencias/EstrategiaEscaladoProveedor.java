package GestorIncidencias;


public class EstrategiaEscaladoProveedor implements EstrategiaIncidencia {

    @Override
    public void procesarIncidencia(Incidencia incidencia) {
        String servicio = incidencia.getReserva().getServicio().getNombreProveedor();
        System.out.println("No se pudo encontrar una solucion a su problema.");
        System.out.println("Conectando con servicio al cliente de: " + servicio);
        incidencia.setEstado("Escalado a "+ servicio);
    }

}
