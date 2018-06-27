package com.bjohnson.rental.modifier;

import com.bjohnson.rental.RentalConstants;
import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;

import static org.junit.Assert.assertEquals;

public class TestSUVOffRoadCharge {
    private Modifier modifier;

    @Before
    public void setUp() {
        modifier = new SUVOffRoadCharge();
    }

    @Test
    public void testNoPerDayCharge() {
        modifier.setSelectedOption(RentalConstants.MODIFIER_OPTION_YES);
        assertEquals(0F, modifier.getPerDayCost(DayOfWeek.MONDAY), 0F);
    }

    @Test
    public void testNoFlatFeeWhenNoSelected() {
        modifier.setSelectedOption(RentalConstants.MODIFIER_OPTION_NO);
        assertEquals(0F, modifier.getFlatFeeCost(), 0F);
    }

    @Test
    public void testFeeAppliedWhenSelected() {
        modifier.setSelectedOption(RentalConstants.MODIFIER_OPTION_YES);
        assertEquals(SUVOffRoadCharge.FLAT_FEE, modifier.getFlatFeeCost(), 0F);
    }


}
