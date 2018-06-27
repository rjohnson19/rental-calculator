package com.bjohnson.rental.vehicle;

import com.bjohnson.rental.RentalConstants;
import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;

public class TestLimousine extends AbstractVehicleTest {
    private static final float EXPECTED_BASE_PRICE = Limousine.COST_PER_DAY;
    private static final float EXPECTED_BASIC_PREMIUM_PRICE = (float) (Limousine.COST_PER_DAY +
                (Limousine.PREMIUM_PERCENTAGE * Limousine.COST_PER_DAY));
    @Before
    public void setUp() {
        vehicle = new Limousine(1);
    }

    @Test
    public void testBaseRateOnStandardDay() {
        validatePriceOnDay(DayOfWeek.MONDAY, EXPECTED_BASE_PRICE);
    }

    @Test
    public void testLimoWithPremiumRateFridayNoAmenities() {
        validatePriceOnDay(DayOfWeek.FRIDAY, EXPECTED_BASIC_PREMIUM_PRICE);
    }

    @Test
    public void testLimoWithPremiumRateSaturdayNoAmenities() {
        validatePriceOnDay(DayOfWeek.SATURDAY, EXPECTED_BASIC_PREMIUM_PRICE);
    }

    @Test
    public void testLimoAmenitiesAreFreeOnSunday() {
        // choose 'Yes' for both modifiers.
        vehicle.getApplicableModifiers().forEach(modifier -> modifier.setSelectedOption(RentalConstants.MODIFIER_OPTION_YES));
        // they should be free on Sunday and just give us the base price.
        validatePriceOnDay(DayOfWeek.SUNDAY, EXPECTED_BASE_PRICE);
    }
}
