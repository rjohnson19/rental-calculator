package com.bjohnson.rental.modifier;

import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;

import static org.junit.Assert.assertEquals;

public class TestHazardInsurance {
    private Modifier modifier;

    @Before
    public void setUp() {
        modifier = new HazardInsurance();
    }

    @Test
    public void testPerDayDoesNotApply() {
        assertEquals(0F, modifier.getPerDayCost(DayOfWeek.MONDAY), 0F);
    }

    @Test
    public void testFlatFeeDefaultsToZero() {
        assertEquals(0F, modifier.getFlatFeeCost(), 0F);
    }

    @Test
    public void testYoungRentersHaveHighestFee() {
        modifier.setSelectedOption(HazardInsurance.RANGE_18_TO_25);
        assertEquals(50F, modifier.getFlatFeeCost(), 0F);
    }

    @Test
    public void testOlderRentersHaveLowerFee() {
        modifier.setSelectedOption(HazardInsurance.RANGE_33_TO_45);
        assertEquals(15F, modifier.getFlatFeeCost(), 0F);
    }

    @Test
    public void testOldestRentersHaveNoFee() {
        modifier.setSelectedOption(HazardInsurance.RANGE_45_OR_OLDER);
        assertEquals(0F, modifier.getFlatFeeCost(), 0F);
    }


}
