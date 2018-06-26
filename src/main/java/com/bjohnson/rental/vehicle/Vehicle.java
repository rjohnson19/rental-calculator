package com.bjohnson.rental.vehicle;

import com.bjohnson.rental.modifier.Modifier;
import com.bjohnson.rental.value.VehicleType;

import java.time.DayOfWeek;
import java.util.List;

/**
 * Interface that represents a vehicle that can be rented,
 * providing the associated cost for rental.
 */
public interface Vehicle {
    /**
     * Get the quantity of vehicles of this type being rented.
     *
     * @return Quantity of vehicles being rented, must be > 0.
     */
    int getQuantity();

    /**
     * Get the type of vehicle this is.
     *
     * @return VehicleType for this vehicle.
     */
    VehicleType getVehicleType();

    /**
     * Get the applicable modifiers for this vehicle.
     * Note each instance of a vehicle should have its own list of modifies to be
     * populated with the selected option, then applied to the cost.
     *
     * @return List of applicable Modifiers.
     */
    List<Modifier> getApplicableModifiers();

    /**
     * Calculate the cost to rent the desired quantity of this vehicle.
     * This method should take into account any modifiers, in addition to the
     * Day of the Week it is being rented on, and other rentals made by the renter if applicable.
     *
     * @param dayOfWeek    The day of the week this rental is for.
     * @param otherRentals Other vehicles being rented by the renter.
     * @return The cost of renting this vehicle on the given day.
     */
    float getCost(DayOfWeek dayOfWeek, List<Vehicle> otherRentals);


}
