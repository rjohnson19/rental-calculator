package com.bjohnson.rental.vehicle;

import com.bjohnson.rental.modifier.Modifier;

import java.time.DayOfWeek;
import java.util.Collections;
import java.util.List;

/**
 * Abstract class for functionality common to all vehicles.
 */
public abstract class AbstractVehicle implements Vehicle {
    private int quantity;

    public AbstractVehicle(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public float getCost(DayOfWeek dayOfWeek, List<Vehicle> otherRentals) {
        // our default implementation of rental costs for a given day
        // - multiply the cost per day by the effective quantity
        // - add applicable modifier costs including per day additions and flat fees
        // -- apply premiums or discounts based on differences in demand on certain days
        float standardCost = calculateDayStandardCost(dayOfWeek, otherRentals);
        return applyDayBasedModifications(dayOfWeek, standardCost);
    }

    @Override
    public List<Modifier> getApplicableModifiers() {
        return Collections.emptyList();
    }

    /**
     * Return the base rental cost per day of this vehicle.
     * @return Cost per day of this vehicle. Can be 0 but not negative.
     */
    protected abstract int getCostPerDay();

    /**
     * Return the effective quantity for cost calculation for this vehicle rental.
     * This allows subclasses to adjust the billed quantity based on factors such as
     * the other vehicles behind rented.
     * @param otherVehicles List of other vehicles being rented by the renter.
     * @return The effective quantity to be used for calculating cost.
     */
    protected int getEffectiveQuantity(List<Vehicle> otherVehicles) {
        return getQuantity();
    }

    /**
     * Calculate the cost for renting this vehicle, given its cost per day and the current day.
     * This cost includes modifiers added to the vehicle as options.
     * @param dayOfWeek Current day of week.
     * @return Cost of renting this vehicle (in desired quantity) for the given day.
     */
    protected float calculateDayStandardCost(DayOfWeek dayOfWeek, List<Vehicle> otherVehicles) {
        float myCost = calculateBaseCost(otherVehicles);
        // apply any per day cost, and fixed fee modifiers to each vehicle being rented
        myCost = addModifierCosts(dayOfWeek, myCost, otherVehicles);

        return myCost;
    }

    /**
     * Calculate the absolute base cost of renting this vehicle given its cost per day.
     * DOES NOT include any modifiers.
     * @return Base cost of renting this vehicle (in desired quantity).
     */
    protected int calculateBaseCost(List<Vehicle> otherVehicles) {
        return getCostPerDay() * getEffectiveQuantity(otherVehicles);
    }

    /**
     * Calculates the cost associated with modifiers applied to this rental, and adds them to the cost.
     * @param dayOfWeek Day of week vehicle is being rented.
     * @param myCost The current base cost of the vehicle.
     * @return Updated cost, accounting for any modifiers applied.
     */
    protected float addModifierCosts(DayOfWeek dayOfWeek, float myCost, List<Vehicle> otherVehicles) {
        final int effectiveQuantity = getEffectiveQuantity(otherVehicles);
        for (Modifier modifier : getApplicableModifiers()) {
            float perDayModifierCost = modifier.getPerDayCost(dayOfWeek) * effectiveQuantity;
            myCost += perDayModifierCost;
            // also apply any flat fee
            myCost += modifier.getFlatFeeCost();
        }
        return myCost;
    }

    /**
     * Applies premiums or discounts to the cost that occur based on the day of week a vehicle is being rented.
     * The default implementation in AbstractVehicle makes no changes to the cost.
     * @param dayOfWeek DayOfWeek rental is occuring.
     * @param myCost The current cost of renting this vehicle.
     * @return Adjusted cost of rental based on the current day of the week.
     */
    protected float applyDayBasedModifications(DayOfWeek dayOfWeek, float myCost) {
        return myCost;
    }
}
