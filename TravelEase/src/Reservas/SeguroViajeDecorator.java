package Reservas;

public class SeguroViajeDecorator extends ServicioReservaDecorator {

    public SeguroViajeDecorator(ServicioReserva servicio) {
        super(servicio);
    }

    @Override
    public String getDescripcion() {
        return servicio.getDescripcion() + " + Seguro de viaje";
    }

    @Override
    public double getPrecio() {
        return servicio.getPrecio() + 50;
    }
}