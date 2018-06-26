package com.bjohnson.rental.vehicle;

import com.bjohnson.rental.value.VehicleType;

import java.time.DayOfWeek;
import java.util.List;

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
    public float getCost(DayOfWeek dayOfWeek, List<Vehicle> otherRentals) {
        // luxury is 2x the mid-size rate
        return super.getCost(dayOfWeek, otherRentals) * LUXURY_COST_MULTIPLIER;
    }
}
