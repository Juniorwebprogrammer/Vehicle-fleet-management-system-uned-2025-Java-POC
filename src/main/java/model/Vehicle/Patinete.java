package model.Vehicle;

import model.base.Base;

public class Patinete extends VinculedVehicle{
    public Patinete(
            int id,
            double costo,
            double consumo,
            Base base
    ) {
        super(id, costo, consumo, base);
    }
}
