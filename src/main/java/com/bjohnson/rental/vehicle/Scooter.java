package com.bjohnson.rental.vehicle;

import com.bjohnson.rental.value.VehicleType;

public class Scooter extends AbstractVehicle {

    static final int COST_PER_DAY = 25;

    public Scooter(int quantity) {
        super(quantity);
    }

    @Override
    protected int getCostPerDay() {
        return COST_PER_DAY;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.SCOOTER;
    }
}
