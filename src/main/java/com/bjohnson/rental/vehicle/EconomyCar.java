package com.bjohnson.rental.vehicle;

import com.bjohnson.rental.value.VehicleType;

import java.time.DayOfWeek;

public class EconomyCar extends MidsizeCar {

    static final double DISCOUNT_PERCENTAGE = 0.5;

    public EconomyCar(int quantity) {
        super(quantity);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.ECONOMY_CAR;
    }

    @Override
    protected float applyDayBasedModifications(DayOfWeek dayOfWeek, float myCost) {
        // economy has a 50% discount from the midsize cost per day
        myCost -= (myCost * DISCOUNT_PERCENTAGE);
        return myCost;
    }
}
