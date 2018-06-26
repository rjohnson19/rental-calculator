package com.bjohnson.rental.vehicle;

import com.bjohnson.rental.modifier.HazardInsurance;
import com.bjohnson.rental.modifier.Modifier;
import com.bjohnson.rental.value.VehicleType;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Motorcycle extends MidsizeCar {
    private List<Modifier> modifiers;

    public Motorcycle(int quantity) {
        super(quantity);
        this.modifiers = new ArrayList<>(Collections.singletonList(new HazardInsurance()));
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.MOTORCYCLE;
    }

    @Override
    public List<Modifier> getApplicableModifiers() {
        return modifiers;
    }

    @Override
    public float getCost(DayOfWeek dayOfWeek, List<Vehicle> otherRentals) {
        // Similar to SUVs, Motorcycle cost starts at the Midsize cost,
        // then we add our modifier costs after that, so the day-based modifications
        // don't apply to hazard insurance fees.
        float myCost = calculateBaseCost(otherRentals);
        myCost = applyDayBasedModifications(dayOfWeek, myCost);
        return addModifierCosts(dayOfWeek, myCost, otherRentals);

    }
}
