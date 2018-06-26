package com.bjohnson.rental.modifier;

import com.bjohnson.rental.RentalConstants;

import java.time.DayOfWeek;
import java.util.Collections;
import java.util.List;

/**
 * A limo amenity has a cost per day, but is complementary and always included on a Sunday rental.
 */
public abstract class LimoAmenity extends AbstractModifier {
    protected LimoAmenity(String description, List<String> options) {
        super(description, options);
    }

    /**
     * Get the cost per day of this limo amenity.
     *
     * @return Cost per day of the amenity.
     */
    public abstract float getCostPerDay();

    @Override
    public List<String> getOptions(DayOfWeek dayOfWeek) {
        // complementary on Sundays so always included.
        if (DayOfWeek.SUNDAY == dayOfWeek) {
            return Collections.singletonList(RentalConstants.MODIFIER_OPTION_YES);
        }
        return super.getOptions(dayOfWeek);
    }

    @Override
    public float getPerDayCost(DayOfWeek dayOfWeek) {
        // complementary on Sundays, or not charged if not selected
        if (DayOfWeek.SUNDAY == dayOfWeek || !RentalConstants.MODIFIER_OPTION_YES.equals(getSelectedOption())) {
            return 0;
        }

        return getCostPerDay();
    }

    @Override
    public float getFlatFeeCost() {
        return 0;
    }
}
