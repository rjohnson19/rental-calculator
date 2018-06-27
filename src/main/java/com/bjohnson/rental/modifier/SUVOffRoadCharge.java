package com.bjohnson.rental.modifier;

import com.bjohnson.rental.RentalConstants;

import java.time.DayOfWeek;

/**
 * A Yes or No modifier that, if opted for, adds a flat fee to an SUV rental to take it off road.
 */
public class SUVOffRoadCharge extends AbstractModifier {

    static final int FLAT_FEE = 15;
    private static final String DESCRIPTION = "Take SUV off road for an additional $" + FLAT_FEE;


    public SUVOffRoadCharge() {
        super(DESCRIPTION, RentalConstants.MODIFIER_OPTIONS_YES_NO);
    }

    @Override
    public float getPerDayCost(DayOfWeek dayOfWeek) {
        return 0;
    }

    @Override
    public float getFlatFeeCost() {
        // fee only applies if opted for
        if (!RentalConstants.MODIFIER_OPTION_YES.equals(getSelectedOption())) {
            return 0F;
        }
        return FLAT_FEE;
    }
}
