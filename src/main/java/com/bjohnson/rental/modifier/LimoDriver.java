package com.bjohnson.rental.modifier;

import com.bjohnson.rental.RentalConstants;

/**
 * A Limo Driver can be optionally added to a Limo rental.
 * It is free and always included on Sunday.
 */
public class LimoDriver extends LimoAmenity {

    private static final int COST_PER_DAY = 150;
    private static final String DESCRIPTION = "Limo Driver for an additional $" + COST_PER_DAY + "/day";


    public LimoDriver() {
        super(DESCRIPTION, RentalConstants.MODIFIER_OPTIONS_YES_NO);
    }

    @Override
    public float getCostPerDay() {
        return COST_PER_DAY;
    }
}
