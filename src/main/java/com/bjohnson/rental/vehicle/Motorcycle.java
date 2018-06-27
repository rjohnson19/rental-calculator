package com.bjohnson.rental.vehicle;

import com.bjohnson.rental.modifier.HazardInsurance;
import com.bjohnson.rental.modifier.Modifier;
import com.bjohnson.rental.value.VehicleType;

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
}
