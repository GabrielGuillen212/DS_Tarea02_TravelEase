package Factory;

public class VueloPrimeraClaseFactory extends VueloFactory {

    @Override
    public Vuelo crearVuelo(
            String id,
            String ruta,
            double precioBase,
            String nombreProveedor) {

        return new Vuelo(
                id,
                ruta + " - Primera Clase",
                precioBase + 350,
                nombreProveedor);
    }
}