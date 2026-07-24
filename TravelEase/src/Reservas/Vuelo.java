package Reservas;

public class Vuelo implements ServicioReserva {

    private String id;
    private String descripcion;
    private double precio;

    public Vuelo(String id, String descripcion, double precio) {
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