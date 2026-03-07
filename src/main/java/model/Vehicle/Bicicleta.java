package model.Vehicle;

import model.base.Base;

public class Bicicleta extends VinculedVehicle {
    public Bicicleta(
            int id,
            double costo,
            double consumo,
            Base base
    ) {
        super(id, costo, consumo, base);
    }
}
