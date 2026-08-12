package Factory;

public class VueloEjecutivoFactory extends VueloFactory {

    @Override
    public Vuelo crearVuelo(
            String id,
            String ruta,
            double precioBase,
            String nombreProveedor) {
        if (ruta == null || ruta.trim().isEmpty()) {
            throw new IllegalArgumentException("La ruta no puede estar vacía ni ser nula.");
        }

        return new Vuelo(
                id,
                ruta + " - Clase Ejecutiva",
                precioBase + 150,
                nombreProveedor);
    }
}