package com.bjohnson.rental.modifier;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hazard Insurance is a modifier on motorcycles that applies a flat fee depending on the age of the renter.
 */
public class HazardInsurance extends AbstractModifier {

    private static final String DESCRIPTION = "Enter age range of renter for motorcycle hazard insurance";
    static final String RANGE_18_TO_25 = "18-25 years old";
    static final String RANGE_26_to_32 = "26-32 years old";
    static final String RANGE_33_TO_45 = "33-45 years old";
    static final String RANGE_45_OR_OLDER = "45 or older";
    static final List<String> OPTIONS = Arrays.asList(RANGE_18_TO_25, RANGE_26_to_32, RANGE_33_TO_45, RANGE_45_OR_OLDER);

    private static final Map<String, Integer> AGE_RANGE_TO_FEE_MAP = new HashMap<>();

    public HazardInsurance() {
        super(DESCRIPTION, OPTIONS);
    }

    @Override
    public float getPerDayCost(DayOfWeek dayOfWeek) {
        return 0;
    }

    @Override
    public float getFlatFeeCost() {
        return AGE_RANGE_TO_FEE_MAP.getOrDefault(getSelectedOption(), 0);
    }

    static {
        AGE_RANGE_TO_FEE_MAP.put(RANGE_18_TO_25, 50);
        AGE_RANGE_TO_FEE_MAP.put(RANGE_26_to_32, 35);
        AGE_RANGE_TO_FEE_MAP.put(RANGE_33_TO_45, 15);
        AGE_RANGE_TO_FEE_MAP.put(RANGE_45_OR_OLDER, 0);
    }
}
