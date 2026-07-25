package Factory;

public class VehiculoLujoFactory extends VehiculoFactory {

    @Override
    public Vehiculo crearVehiculo(
            String id,
            String descripcionBase,
            double precioBase,
            String nombreProveedor) {

        return new Vehiculo(
                id,
                descripcionBase + " - Lujo",
                precioBase + 120,
                nombreProveedor);
    }
}