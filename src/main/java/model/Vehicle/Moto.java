package model.Vehicle;

public class Moto extends Vehicle{
    private double latitudActual;
    private double longitudActual;

    public Moto(
            int id,
            double costo,
            double consumo,
            double latitudActual,
            double longitudActual
    ) {
        super(id, costo, consumo);
        this.latitudActual = latitudActual;
        this.longitudActual = longitudActual;
    }

    public void finalizarViaje(double lat, double lng) {
        this.latitudActual = lat;
        this.longitudActual = lng;
    }
}
