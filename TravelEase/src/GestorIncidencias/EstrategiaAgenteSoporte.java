package GestorIncidencias;

public class EstrategiaAgenteSoporte implements EstrategiaIncidencia{

    @Override
    public void procesarIncidencia(Incidencia incidencia) {
        System.out.println("Problema resuelto por el agente de Soporte");
        incidencia.setEstado("RESUELTO");
    }

}
