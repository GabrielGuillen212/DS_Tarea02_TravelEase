package Factory;

import Reservas.ServicioReserva;

public class Vehiculo implements ServicioReserva {

    private String id;
    private String descripcion;
    private double precio;
    private String proveedor;

    public Vehiculo(String id, String descripcion, double precio, String proveedor) {
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