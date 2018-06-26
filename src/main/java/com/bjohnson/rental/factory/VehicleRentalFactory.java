package com.bjohnson.rental.factory;

import com.bjohnson.rental.value.VehicleType;
import com.bjohnson.rental.vehicle.Vehicle;

@FunctionalInterface
public interface VehicleRentalFactory {
    /**
     * Constructs a vehicle of the desired type, with the specified quantity, for rental.
     * @param vehicleType The type of vehicle.
     * @param quantity desired quantity of vehicles. Must be > 0.
     * @return Vehicle for rental.
     */
    Vehicle rentVehicle(VehicleType vehicleType, int quantity);
}
