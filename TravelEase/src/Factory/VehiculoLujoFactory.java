package Factory;

import Reservas.*;

public class VehiculoLujoFactory extends VehiculoFactory {
    @Override
    public Vehiculo crearVehiculo(String id, String descripcionBase, double precioBase) {
        return new Vehiculo(id, descripcionBase + " - Lujo", precioBase + 120);
    }
}