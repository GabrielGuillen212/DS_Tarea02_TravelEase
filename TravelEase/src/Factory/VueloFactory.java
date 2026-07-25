package Factory;

import Reservas.ServicioReserva;

public abstract class VueloFactory {

    public abstract Vuelo crearVuelo(
            String id,
            String ruta,
            double precioBase,
            String nombreProveedor);

    public ServicioReserva reservarVuelo(
            String id,
            String ruta,
            double precioBase,
            String nombreProveedor) {

        return crearVuelo(id, ruta, precioBase, nombreProveedor);
    }
}