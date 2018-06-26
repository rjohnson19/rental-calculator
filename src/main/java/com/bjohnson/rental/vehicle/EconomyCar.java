package com.bjohnson.rental.vehicle;

import com.bjohnson.rental.value.VehicleType;

import java.time.DayOfWeek;
import java.util.List;

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
    public float getCost(DayOfWeek dayOfWeek, List<Vehicle> otherRentals) {
        // economy has a 50% discount from the midsize cost.
        float myCost = super.getCost(dayOfWeek, otherRentals);
        myCost -= (myCost * DISCOUNT_PERCENTAGE);

        return myCost;
    }
}
