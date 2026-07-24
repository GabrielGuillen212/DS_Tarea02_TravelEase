package GestorIncidencias;

public class GestionIncidencia {
    private EstrategiaIncidencia estrategia;

    public GestionIncidencia(EstrategiaIncidencia estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(EstrategiaIncidencia estrategia) {
        this.estrategia = estrategia;
    }
    
    public void ejecutarSolucion(Incidencia incidencia){
        this.estrategia.procesarIncidencia(incidencia);
    }
}
