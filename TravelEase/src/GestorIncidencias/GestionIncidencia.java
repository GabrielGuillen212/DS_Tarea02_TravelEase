package GestorIncidencias;

public class GestionIncidencia {
    private EstrategiaIncidencia estrategia;

    public GestionIncidencia() {
        this.estrategia = new EstrategiaAgenteSoporte();
    }

    public void ejecutarSolucion(Incidencia incidencia, boolean resuelto){
        if(resuelto){
            this.estrategia = new EstrategiaAgenteSoporte();
        } else{
            this.estrategia = new EstrategiaEscaladoProveedor();
        }
        this.estrategia.procesarIncidencia(incidencia);
    }
}
