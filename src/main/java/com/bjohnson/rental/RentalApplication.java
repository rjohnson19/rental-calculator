package com.bjohnson.rental;

import com.bjohnson.rental.factory.VehicleRentalFactory;
import com.bjohnson.rental.factory.VehicleRentalFactoryImpl;
import com.bjohnson.rental.utils.ConsoleUtils;
import com.bjohnson.rental.value.VehicleType;
import com.bjohnson.rental.vehicle.Vehicle;

import java.io.Console;
import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Main application class where the user selections for day, vehicles, and modifiers is ultimately captured
 * and used to calculate the total rental cost.
 */
public class RentalApplication {
    private DayOfWeek dayOfWeek;
    private List<Vehicle> vehicles;
    private VehicleRentalFactory rentalFactory;
    private Console console;
    private static final List<String> DAYS_OF_WEEK = new ArrayList<>(Arrays.stream(DayOfWeek.values())
            .map(value -> value.getDisplayName(TextStyle.FULL, Locale.getDefault()))
            .collect(Collectors.toList()));

    public RentalApplication(final Console console) {
        this.vehicles = new ArrayList<>();
        this.rentalFactory = new VehicleRentalFactoryImpl();
        this.console = console;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    private void captureDayOfWeek() {
        while (dayOfWeek == null) {
            System.out.println("Choose day of rental.");
            String day = ConsoleUtils.captureOptionByIndex(console, DAYS_OF_WEEK);
            if (Objects.nonNull(day) && !day.isEmpty()) {
                dayOfWeek = DayOfWeek.valueOf(day.toUpperCase());
            }
        }
    }

    private void captureVehicleRentals() {
        System.out.println("Choose vehicles to rent and their quantity.");
        Arrays.stream(VehicleType.values()).forEach(this::captureVehicleWithQuantity);
    }

    private void captureVehicleWithQuantity(VehicleType vehicleType) {
        final String vehicleName = vehicleType.getName();
        int quantity = -1;
        while (quantity < 0) {
            System.out.print("Enter desired number of " + vehicleName + "(s) to rent, 0 for none: ");
            quantity = ConsoleUtils.nextIntOrDefault(console, -1);
        }

        if (quantity > 0) {
            addVehicle(vehicleType, quantity);
        }
    }

    private void addVehicle(VehicleType vehicleType, int quantity) {
        this.vehicles.add(rentalFactory.rentVehicle(vehicleType, quantity));
    }

    private void collectModifierOptions() {
        if (vehiclesHaveAnyModifiers()) {
            System.out.println("Choose additional options for the vehicles you are renting.");
            vehicles.forEach(this::collectVehicleModifierOptions);
        }
    }

    private void collectVehicleModifierOptions(Vehicle vehicle) {
        vehicle.getApplicableModifiers().forEach(modifier -> modifier.captureSelection(console, dayOfWeek));
    }

    private boolean vehiclesHaveAnyModifiers() {
        return vehicles.stream()
                .anyMatch(vehicle -> !vehicle.getApplicableModifiers().isEmpty());
    }

    private void execute() {
        captureDayOfWeek();

        captureVehicleRentals();

        collectModifierOptions();

        final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        System.out.println("Grand Total: " + currencyFormat.format(getTotalCost()));
    }

    private float getTotalCost() {
        float totalCost = 0;
        for (Vehicle vehicle : vehicles) {
            totalCost += vehicle.getCost(dayOfWeek, vehicles);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        final Console console = System.console();
        if (Objects.isNull(console)) {
            System.err.println("Not in interactive mode!");
            System.exit(1);
        }
        final RentalApplication rentalApplication = new RentalApplication(console);
        rentalApplication.execute();
    }
}
