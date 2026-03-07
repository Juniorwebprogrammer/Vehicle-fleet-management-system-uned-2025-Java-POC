package model.base;

import model.Vehicle.Vehicle;

import java.util.List;

public class Base {
    private int id;
    private double latitud;
    private double longitud;
    private int capacidadPlazas = 20;
    private List<Vehicle> vehicleList;

    public Base (
            int id,
            double latitud,
            double longitud
    ) {
        this.id = id;
        this.latitud = latitud;
        this.longitud = longitud;
    }
}
