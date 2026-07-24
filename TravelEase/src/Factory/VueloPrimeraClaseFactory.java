package Factory;

import Reservas.*;

public class VueloPrimeraClaseFactory extends VueloFactory {
    @Override
    public Vuelo crearVuelo(String id, String ruta, double precioBase) {
        return new Vuelo(id, ruta + " - Primera Clase", precioBase + 350);
    }
}