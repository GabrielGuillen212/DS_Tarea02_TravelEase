package Factory;

import Reservas.*;

public class VehiculoSUVFactory extends VehiculoFactory {
    @Override
    public Vehiculo crearVehiculo(String id, String descripcionBase, double precioBase) {
        return new Vehiculo(id, descripcionBase + " - SUV", precioBase + 40);
    }
}
