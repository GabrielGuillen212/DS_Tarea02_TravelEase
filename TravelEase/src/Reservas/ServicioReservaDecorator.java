package Reservas;

public abstract class ServicioReservaDecorator implements ServicioReserva {

    protected ServicioReserva servicio;

    public ServicioReservaDecorator(ServicioReserva servicio) {
        this.servicio = servicio;
    }

    @Override
    public String getID() {
        return servicio.getID();
    }

    @Override
    public String getDescripcion() {
        return servicio.getDescripcion();
    }

    @Override
    public double getPrecio() {
        return servicio.getPrecio();
    }

    public String getNombreProveedor(){
        return this.servicio.getNombreProveedor();
    }
}