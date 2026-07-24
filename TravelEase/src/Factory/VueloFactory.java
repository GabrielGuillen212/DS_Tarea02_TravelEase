package Factory;

import Reservas.*;

public abstract class VueloFactory {

    // Método fábrica: cada subclase decide cómo construir el Vuelo
    public abstract Vuelo crearVuelo(String id, String ruta, double precioBase);

    // Método "molde" que el cliente usa sin saber la clase concreta
    public ServicioReserva reservarVuelo(String id, String ruta, double precioBase) {
        return crearVuelo(id, ruta, precioBase);
    }
}
