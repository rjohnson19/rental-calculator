package com.bjohnson.rental.vehicle;

import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestBicycle extends AbstractVehicleTest {
    private static final float EXPECTED_BASE_PRICE = Bicycle.COST_PER_DAY;
    @Before
    public void setUp() {
        vehicle = new Bicycle(1);
    }

    @Test
    public void testNoFreeBicycleWhenRentingOtherVehicles() {
        List<Vehicle> vehicles = Arrays.asList(new LuxuryCar(1), new Motorcycle(3));
        validatePriceOnDay(DayOfWeek.MONDAY, EXPECTED_BASE_PRICE, vehicles);
    }

    @Test
    public void testFreeBicycleWhenRentingSUV() {
        List<Vehicle> vehicles = Collections.singletonList(new SUV(1));
        validatePriceOnDay(DayOfWeek.MONDAY, 0, vehicles);
    }

    @Test
    public void testOnlyGetOneOfSeveralBicyclesFree() {
        vehicle = new Bicycle(3);
        List<Vehicle> vehicles = Collections.singletonList(new SUV(1));
        validatePriceOnDay(DayOfWeek.MONDAY, EXPECTED_BASE_PRICE * 2, vehicles);
    }
}
