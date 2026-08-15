package GestorIncidencias;

public class GestionIncidencia {

    private EstrategiaIncidencia estrategia;

    public GestionIncidencia(){}

    public void setEstrategia(EstrategiaIncidencia estrategia) {
        if (estrategia == null) {
            throw new IllegalArgumentException("La estrategia no puede ser nula.");
        }
        this.estrategia = estrategia;
    }

    // 3. El contexto delega el trabajo al objeto estrategia.
    public void ejecutarSolucion(Incidencia incidencia) {
        if (incidencia == null) {
            throw new IllegalArgumentException("La incidencia no puede ser nula.");
        }
        if (this.estrategia == null) {
            throw new IllegalStateException("No se ha asignado una estrategia de resolución.");
        }
        
        // Delegación de la ejecución
        this.estrategia.procesarIncidencia(incidencia);
    }
}
