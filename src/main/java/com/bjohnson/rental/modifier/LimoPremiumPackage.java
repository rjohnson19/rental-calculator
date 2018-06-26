package com.bjohnson.rental.modifier;

import com.bjohnson.rental.RentalConstants;

/**
 * A Limo Premium Package can be optionally added to a Limo rental.
 * It is free and always included on Sunday.
 */
public class LimoPremiumPackage extends LimoAmenity {

    private static final int COST_PER_DAY = 75;
    private static final String DESCRIPTION = "Limo Premium package including Champagne and H’ordeurves for an additional $" + COST_PER_DAY + "/day";

    public LimoPremiumPackage() {
        super(DESCRIPTION, RentalConstants.MODIFIER_OPTIONS_YES_NO);
    }

    @Override
    public float getCostPerDay() {
        return COST_PER_DAY;
    }
}
