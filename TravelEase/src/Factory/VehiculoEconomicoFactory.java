package Factory;

import Reservas.*;

public class VehiculoEconomicoFactory extends VehiculoFactory {
    @Override
    public Vehiculo crearVehiculo(String id, String descripcionBase, double precioBase) {
        return new Vehiculo(id, descripcionBase + " - Económico", precioBase);
    }
}
