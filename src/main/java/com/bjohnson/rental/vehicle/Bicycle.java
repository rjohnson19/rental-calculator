package com.bjohnson.rental.vehicle;

import com.bjohnson.rental.value.VehicleType;

import java.util.List;

public class Bicycle extends AbstractVehicle {

    static final int COST_PER_DAY = 10;

    public Bicycle(int quantity) {
        super(quantity);
    }

    @Override
    protected int getCostPerDay() {
        return COST_PER_DAY;
    }

    @Override
    protected int getEffectiveQuantity(List<Vehicle> otherVehicles) {
        int quantity = getQuantity();
        // if a renter rents an SUV, their first bike rental is free.
        boolean rentingSUV = otherVehicles.stream()
                .anyMatch(vehicle -> VehicleType.SUV == vehicle.getVehicleType());
        if (rentingSUV) {
            quantity = quantity - 1;
        }

        return quantity;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.BICYCLE;
    }
}
