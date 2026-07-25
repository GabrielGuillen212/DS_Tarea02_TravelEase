package Factory;

public class VueloEjecutivoFactory extends VueloFactory {

    @Override
    public Vuelo crearVuelo(
            String id,
            String ruta,
            double precioBase,
            String nombreProveedor) {

        return new Vuelo(
                id,
                ruta + " - Clase Ejecutiva",
                precioBase + 150,
                nombreProveedor);
    }
}