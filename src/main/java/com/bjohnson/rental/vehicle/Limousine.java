package com.bjohnson.rental.vehicle;

import com.bjohnson.rental.modifier.LimoDriver;
import com.bjohnson.rental.modifier.LimoPremiumPackage;
import com.bjohnson.rental.modifier.Modifier;
import com.bjohnson.rental.value.VehicleType;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Limousine extends AbstractVehicle {

    static final int COST_PER_DAY = 100;
    static final double PREMIUM_PERCENTAGE = 0.4;

    private List<Modifier> modifiers;

    public Limousine(int quantity) {
        super(quantity);
        modifiers = new ArrayList<>(Arrays.asList(new LimoDriver(), new LimoPremiumPackage()));
    }

    @Override
    protected int getCostPerDay() {
        return COST_PER_DAY;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.LIMOUSINE;
    }

    @Override
    public List<Modifier> getApplicableModifiers() {
        return modifiers;
    }

    @Override
    protected float applyDayBasedModifications(DayOfWeek dayOfWeek, float myCost) {
        // On Friday and Saturday there is a 40% premium added to the total for all limo services.
        // Note the Sunday complementary driver and premium package is handled in those modifier implementations.
        if (DayOfWeek.FRIDAY == dayOfWeek || DayOfWeek.SATURDAY == dayOfWeek) {
            myCost += (myCost * PREMIUM_PERCENTAGE);
        }

        return myCost;
    }
}
