package model.Vehicle;

public abstract class Vehicle {
    private int id;
    private double porcentajeBateria = 100.0;
    private int averiasActivas = 0;
    private int averiasResueltas = 0;

    protected double costoAlquiler;
    protected double consumo;

    public Vehicle(
            int id,
            double costoAlquiler,
            double consumo
    ) {
        this.id = id;
        this.costoAlquiler = costoAlquiler;
        this.consumo = consumo;
    }
}
