package Factory;

import Reservas.ServicioReserva;

public class Vuelo implements ServicioReserva {

    private String id;
    private String descripcion;
    private double precio;
    private String proveedor;

    public Vuelo(String id, String descripcion, double precio, String proveedor) {
    if (id == null || id.isBlank()) {
        throw new IllegalArgumentException("El id del vuelo no puede ser nulo o vacío");
    }
    if (descripcion == null || descripcion.isBlank()) {
        throw new IllegalArgumentException("La ruta/descripción no puede ser nula o vacía");
    }
    if (precio < 0) {
        throw new IllegalArgumentException("El precio no puede ser negativo");
    }
    if (proveedor == null || proveedor.isBlank()) {
        throw new IllegalArgumentException("El proveedor no puede ser nulo o vacío");
    }
    this.id = id;
    this.descripcion = descripcion;
    this.precio = precio;
    this.proveedor = proveedor;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public String getNombreProveedor() {
        return proveedor;
    }
}