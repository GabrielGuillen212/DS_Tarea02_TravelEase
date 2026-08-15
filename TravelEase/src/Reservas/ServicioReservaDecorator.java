package Reservas;

public abstract class ServicioReservaDecorator implements ServicioReserva {

    protected ServicioReserva servicio;
    protected String nombreAdicional;
    protected double precioAdicional;

    public ServicioReservaDecorator(ServicioReserva servicio, String nombreAdicional, double precioAdicional) {
        this.servicio = servicio;
        this.nombreAdicional = nombreAdicional;
        this.precioAdicional = precioAdicional;
    }

    @Override
    public String getID() {
        return servicio.getID();
    }

    @Override
    public String getDescripcion() {
        return servicio.getDescripcion() + " + " + nombreAdicional;
    }

    @Override
    public double getPrecio() {
        return servicio.getPrecio() + precioAdicional;
    }

    @Override
    public String getNombreProveedor() {
        return servicio.getNombreProveedor();
    }
}