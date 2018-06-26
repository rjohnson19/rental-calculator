package com.bjohnson.rental.vehicle;

import com.bjohnson.rental.value.VehicleType;

import java.time.DayOfWeek;

public class MidsizeCar extends AbstractVehicle {

    static final int COST_PER_DAY = 30;
    static final double PREMIUM_PERCENTAGE = 0.25;
    static final double DISCOUNT_PERCENTAGE = 0.2;

    public MidsizeCar(int quantity) {
        super(quantity);
    }

    @Override
    protected int getCostPerDay() {
        return COST_PER_DAY;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.MIDSIZE_CAR;
    }

    @Override
    protected float applyDayBasedModifications(DayOfWeek dayOfWeek, float myCost) {
        // On Friday and Saturday there is a 25% premium.
        if (DayOfWeek.FRIDAY == dayOfWeek || DayOfWeek.SATURDAY == dayOfWeek) {
            myCost += (myCost * PREMIUM_PERCENTAGE);
        } else if (DayOfWeek.SUNDAY == dayOfWeek) {
            // on Sunday there is a 20% discount
            myCost -= (myCost * DISCOUNT_PERCENTAGE);
        }
        return myCost;
    }
}
