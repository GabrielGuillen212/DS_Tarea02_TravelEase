package Reservas;

public class Vehiculo implements ServicioReserva {

    private String id;
    private String descripcion;
    private double precio;

    public Vehiculo(String id, String descripcion, double precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
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
}