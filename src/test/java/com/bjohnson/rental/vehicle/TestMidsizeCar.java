package com.bjohnson.rental.vehicle;

import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;

public class TestMidsizeCar extends AbstractVehicleTest {
    private static final float EXPECTED_BASE_PRICE = MidsizeCar.COST_PER_DAY;
    private static final float EXPECTED_PREMIUM_PRICE = (float) (MidsizeCar.COST_PER_DAY +
                (MidsizeCar.COST_PER_DAY * MidsizeCar.PREMIUM_PERCENTAGE));
    private static final float EXPECTED_DISCOUNT_PRICE = (float) (MidsizeCar.COST_PER_DAY -
            (MidsizeCar.COST_PER_DAY * MidsizeCar.DISCOUNT_PERCENTAGE));

    @Before
    public void setUp() {
        vehicle = new MidsizeCar(1);
    }

    @Test
    public void testBaseRateOnStandardDay() {
        validatePriceOnDay(DayOfWeek.MONDAY, EXPECTED_BASE_PRICE);
    }

    @Test
    public void testPremiumOnFriday() {
        // 30 * .25 = 7.5, total = 37.5
        validatePriceOnDay(DayOfWeek.FRIDAY, EXPECTED_PREMIUM_PRICE);
    }

    @Test
    public void testPremiumOnSaturday() {
        validatePriceOnDay(DayOfWeek.SATURDAY, EXPECTED_PREMIUM_PRICE);
    }

    @Test
    public void testDiscountPrice() {
        validatePriceOnDay(DayOfWeek.SUNDAY, EXPECTED_DISCOUNT_PRICE);
    }

    @Test
    public void testBaseRateWithMultipleVehicles() {
        vehicle = new MidsizeCar(3);
        validatePriceOnDay(DayOfWeek.MONDAY, EXPECTED_BASE_PRICE * 3);
    }

}
