package com.bjohnson.rental.vehicle;

import com.bjohnson.rental.modifier.Modifier;
import com.bjohnson.rental.modifier.SUVOffRoadCharge;
import com.bjohnson.rental.value.VehicleType;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SUV extends MidsizeCar {
    static final double PREMIUM_PERCENTAGE = 0.50;
    private List<Modifier> modifiers;

    public SUV(int quantity) {
        super(quantity);
        this.modifiers = new ArrayList<>(Collections.singletonList(new SUVOffRoadCharge()));
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.SUV;
    }

    @Override
    public List<Modifier> getApplicableModifiers() {
        return modifiers;
    }

    @Override
    public float getCost(DayOfWeek dayOfWeek, List<Vehicle> otherRentals) {
        // SUVs cost 50% more then the midsize car rate, but that doesn't include the offroad fee,
        // so we need to customize the cost calculation.
        // first get the midsize could for our quantity, without including the offroad modifier:
        float myCost = calculateBaseCost(otherRentals);
        myCost = applyDayBasedModifications(dayOfWeek, myCost);
        // apply a 50% premium to that
        myCost += (myCost * PREMIUM_PERCENTAGE);
        // apply any offroad fee
        return addModifierCosts(dayOfWeek, myCost, otherRentals);

    }
}
