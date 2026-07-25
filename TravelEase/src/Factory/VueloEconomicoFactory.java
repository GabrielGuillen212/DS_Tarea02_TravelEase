package Factory;

public class VueloEconomicoFactory extends VueloFactory {

    @Override
    public Vuelo crearVuelo(
            String id,
            String ruta,
            double precioBase,
            String nombreProveedor) {

        return new Vuelo(
                id,
                ruta + " - Clase Económica",
                precioBase,
                nombreProveedor);
    }
}