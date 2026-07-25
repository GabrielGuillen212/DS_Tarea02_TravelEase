package Factory;

public class VehiculoEconomicoFactory extends VehiculoFactory {

    @Override
    public Vehiculo crearVehiculo(
            String id,
            String descripcionBase,
            double precioBase,
            String nombreProveedor) {

        return new Vehiculo(
                id,
                descripcionBase + " - Económico",
                precioBase,
                nombreProveedor);
    }
}
