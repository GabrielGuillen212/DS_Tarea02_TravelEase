package Factory;

import Reservas.*;

public abstract class VehiculoFactory {

    public abstract Vehiculo crearVehiculo(String id, String descripcionBase, double precioBase);

    public ServicioReserva reservarVehiculo(String id, String descripcionBase, double precioBase) {
        return crearVehiculo(id, descripcionBase, precioBase);
    }
}