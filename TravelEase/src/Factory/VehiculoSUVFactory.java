package Factory;

public class VehiculoSUVFactory extends VehiculoFactory {

    @Override
    public Vehiculo crearVehiculo(
            String id,
            String descripcionBase,
            double precioBase,
            String nombreProveedor) {

        return new Vehiculo(
                id,
                descripcionBase + " - SUV",
                precioBase + 40,
                nombreProveedor);
    }
}