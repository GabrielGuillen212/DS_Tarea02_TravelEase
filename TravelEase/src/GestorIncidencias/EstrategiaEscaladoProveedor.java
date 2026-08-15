package GestorIncidencias;


public class EstrategiaEscaladoProveedor implements EstrategiaIncidencia {

    @Override
    public void procesarIncidencia(Incidencia incidencia) {
        if (incidencia == null) {
            throw new IllegalArgumentException("La incidencia no puede ser nula.");
        }

        String proveedor = incidencia.getNombreProveedor();
        incidencia.setEstado("Escalado a "+ proveedor);
    }

}
