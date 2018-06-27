package com.bjohnson.rental.modifier;

import com.bjohnson.rental.utils.ConsoleUtils;

import java.io.Console;
import java.time.DayOfWeek;
import java.util.Collections;

/**
 * This modifier captures the number of hours jetskis are being rented for, which is how we charge for them,
 * rather than charging per day.
 */
public class JetskiHours extends AbstractModifier {
    private static final int COST_PER_HOUR = 25;
    private static final String DESCRIPTION = "Enter how many hours per day you'd like to use the Jetskis, $" + COST_PER_HOUR + "/hour";
    private static final String MSG_INVALID_INPUT_JETSKI_HOURS = "Please enter a positive integer for Jetski hours.";

    private int hours = 0;

    public JetskiHours() {
        super(DESCRIPTION, Collections.emptyList());
    }

    @Override
    public float getPerDayCost(DayOfWeek dayOfWeek) {
        return COST_PER_HOUR * hours;
    }

    @Override
    public float getFlatFeeCost() {
        return 0;
    }

    @Override
    public void captureSelection(Console console, DayOfWeek dayOfWeek) {

        while (this.hours < 1) {
            System.out.print(DESCRIPTION + ": ");
            int hrs = ConsoleUtils.nextIntOrDefault(console, -1);
            if (hrs > 0) {
                this.hours = hrs;
            } else {
                System.out.println(MSG_INVALID_INPUT_JETSKI_HOURS);
            }
        }

    }
}
