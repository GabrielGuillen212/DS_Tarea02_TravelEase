package Factory;

import Reservas.ServicioReserva;

public abstract class VehiculoFactory {

    public abstract Vehiculo crearVehiculo(
            String id,
            String descripcionBase,
            double precioBase,
            String nombreProveedor);

    public ServicioReserva reservarVehiculo(
            String id,
            String descripcionBase,
            double precioBase,
            String nombreProveedor) {

        return crearVehiculo(id, descripcionBase, precioBase, nombreProveedor);
    }
}