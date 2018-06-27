## Rental Calculator
- This is a Java console application for calculating the charge to rent vehicles.
- There are various vehicle types with different rules for rental costs.
- Premiums or discounts apply to vehicles depending on the day.
- Some vehicles have additional options that have per day fees or flat fees associated with them.

### Building
- Ensure you have Java 8 and Apache Maven installed and on your PATH.
- Execute ./build.sh to run the build.

### Running
- Execute ./run.sh after building to run the interactive tool.
- Make selections as shown in the prompts using the displayed numbers.
- Once you have provided all information, the grand total of the chosen vehicle rentals will be displayed, and
    the application will exit.
    
### Technical Details

#### com.bjohnson.rental.RentalApplication
- This is the main class for the application and holds the information entered via console input.
- It is responsible for totaling the cost of all selections and presenting that to the user.

#### com.bjohnson.rental.vehicle.Vehicle
- This interface represents a vehicle that can be rented.
- It has methods for returning information about the vehicle, including the cost of rental.

#### com.bjohnson.rental.vehicle.AbstractVehicle
- This abstract class houses functionality and logic common to all vehicles.
- This includes the logic for cost calculations.
- All concrete vehicle implementations derive from this class.

#### com.bjohnson.rental.modifier.Modifier
- A Vehicle can have 0 to many modifiers.
- This includes options that the user can opt to accept or decline.
- If chosen, a modifier has either a flat fee cost or a per day cost.
- Some examples are a Limo Driver modifier, and an SUV Off Road Charge.

#### com.bjohnson.rental.modifier.AbstractModifier
- This is an abstract class that all concrete modifiers derive from.
- It houses common functionality, including the logic to present the options
    for the modifier to the user, and capture their selection.
- It is up to the concrete classes to determine what charges to apply based on the selection.

#### com.bjohnson.rental.factory.VehicleRentalFactoryImpl
- This is a simple factory class that produces concrete instances of a desired vehicle,
    given the VehicleType enum value chosen and a quantity.   