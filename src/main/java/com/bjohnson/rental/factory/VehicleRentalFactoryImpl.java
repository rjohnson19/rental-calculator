package com.bjohnson.rental.factory;

import com.bjohnson.rental.value.VehicleType;
import com.bjohnson.rental.vehicle.*;

public class VehicleRentalFactoryImpl implements VehicleRentalFactory {
    @Override
    public Vehicle rentVehicle(VehicleType vehicleType, int quantity) {
        switch (vehicleType) {
            case MIDSIZE_CAR:
                return new MidsizeCar(quantity);
            case ECONOMY_CAR:
                return new EconomyCar(quantity);
            case SUV:
                return new SUV(quantity);
            case LUXURY_CAR:
                return new LuxuryCar(quantity);
            case LIMOUSINE:
                return new Limousine(quantity);
            case BICYCLE:
                return new Bicycle(quantity);
            case SCOOTER:
                return new Scooter(quantity);
            case MOTORCYCLE:
                return new Motorcycle(quantity);
            case JETSKI:
                return new Jetski(quantity);
            default:
                throw new UnsupportedOperationException("Vehicle type " + vehicleType + " is not supported!");
        }
    }
}
