package model.Vehicle;

import model.base.Base;

public abstract class VinculedVehicle extends Vehicle {
    private Base baseActual;

    public VinculedVehicle(
            int id,
            double costo,
            double consumo,
            Base baseInicial
    ) {
        super(id, costo, consumo);
        this.baseActual = baseInicial;
    }

    public void anclarEnBase(Base nuevaBase) {
        this.baseActual = nuevaBase;
    }
}
