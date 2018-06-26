package com.bjohnson.rental.modifier;

import java.io.Console;
import java.time.DayOfWeek;
import java.util.List;

/**
 * A Modifier that applies to rental of a particular vehicle that impacts its rental cost.
 * An example is a $15 charge if you are taking an SUV offroad.
 * This interface encapsulates how to capture the Modifier from user input,
 * provides methods for applying it to a cost calculation.
 */
public interface Modifier {
    /**
     * A description of this modifier to pose to to the renter.
     *
     * @return A description of the modifier in the form of a query:
     * 'Are you taking the SUV off road?'
     */
    String getDescription();

    /**
     * Possible options for this modifier, for example Yes/No, or a set of age ranges for an age based fee.
     *
     * @param dayOfWeek The day of week this modifier is for.
     * @return List of possible options for this modifier, one of which can be selected.
     * If the list has only one option, it will be automatically selected. An example would be a complementary addition
     * on a certain day.
     */
    List<String> getOptions(DayOfWeek dayOfWeek);

    /**
     * Set the selected option for this modifier.
     *
     * @param option The option to set. Must be one of the values returned by getOptions().
     */
    void setOption(String option);

    /**
     * Provides the per day cost of this modifier.
     *
     * @param dayOfWeek The day of week this modifier is being applied to.
     * @return The per day cost of this modifier, or 0 if none.
     */
    float getPerDayCost(DayOfWeek dayOfWeek);

    /**
     * Provide a flat fee cost of this modifier, if any.
     *
     * @return Cost of this modifier as a flat fee, or 0 if none.
     */
    float getFlatFeeCost();

    /**
     * Capture the selected option for this modifier.
     * If there is only one option, this method should automatically select it without user input.
     *
     * @param console   The console to get user input from.
     * @param dayOfWeek The day of week we are renting on.
     */
    void captureSelection(Console console, DayOfWeek dayOfWeek);
}
