package com.bjohnson.rental.vehicle;

import com.bjohnson.rental.modifier.JetskiHours;
import com.bjohnson.rental.modifier.Modifier;
import com.bjohnson.rental.value.VehicleType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jetski extends AbstractVehicle {

    // Jetskis only have an hourly cost which is captured by the JetskiHours modifier.
    static final int COST_PER_DAY = 0;

    private List<Modifier> modifiers;

    public Jetski(int quantity) {
        super(quantity);
        modifiers = new ArrayList<>(Collections.singletonList(new JetskiHours()));
    }

    @Override
    protected int getCostPerDay() {
        return COST_PER_DAY;
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.JETSKI;
    }

    @Override
    public List<Modifier> getApplicableModifiers() {
        return modifiers;
    }
}
