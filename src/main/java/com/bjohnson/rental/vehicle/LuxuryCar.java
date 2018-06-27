package com.bjohnson.rental.vehicle;

import com.bjohnson.rental.value.VehicleType;

import java.time.DayOfWeek;

public class LuxuryCar extends MidsizeCar {

    static final int LUXURY_COST_MULTIPLIER = 2;

    public LuxuryCar(int quantity) {
        super(quantity);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.LUXURY_CAR;
    }

    @Override
    protected float applyDayBasedModifications(DayOfWeek dayOfWeek, float myCost) {
        // luxury is 2x the mid-size rate for a given day
        return myCost * LUXURY_COST_MULTIPLIER;
    }
}
