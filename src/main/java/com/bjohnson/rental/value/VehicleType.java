package com.bjohnson.rental.value;

/**
 * Enumeration holding types of vehicles available for rental.
 */
public enum VehicleType {
    MIDSIZE_CAR("Midsize Car"),
    ECONOMY_CAR("Economy Car"),
    SUV("SUV"),
    LUXURY_CAR("Luxury Car"),
    LIMOUSINE("Limousine"),
    BICYCLE("Bicycle"),
    SCOOTER("Scooter"),
    MOTORCYCLE("Motorcycle"),
    JETSKI("JetSki");

    private String name;
    VehicleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
