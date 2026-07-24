package Factory;

import Reservas.*;

public class VueloEconomicoFactory extends VueloFactory {
    @Override
    public Vuelo crearVuelo(String id, String ruta, double precioBase) {
        return new Vuelo(id, ruta + " - Clase Económica", precioBase);
    }
}
