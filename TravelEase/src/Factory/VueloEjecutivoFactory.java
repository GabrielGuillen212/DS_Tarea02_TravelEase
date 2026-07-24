package Factory;

import Reservas.*;

public class VueloEjecutivoFactory extends VueloFactory {
    @Override
    public Vuelo crearVuelo(String id, String ruta, double precioBase) {
        return new Vuelo(id, ruta + " - Clase Ejecutiva", precioBase + 150);
    }
}