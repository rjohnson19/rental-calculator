package com.bjohnson.rental.vehicle;

import java.time.DayOfWeek;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AbstractVehicleTest {
    protected Vehicle vehicle;

    protected void validatePriceOnDay(final DayOfWeek dayOfWeek, final float expectedPrice) {
        validatePriceOnDay(dayOfWeek, expectedPrice, Collections.emptyList());
    }

    protected void validatePriceOnDay(final DayOfWeek dayOfWeek, final float expectedPrice, final List<Vehicle> otherVehicles) {
        assertEquals("Cost should be $" + expectedPrice, expectedPrice,
                vehicle.getCost(dayOfWeek, otherVehicles), 0F);
    }
}
