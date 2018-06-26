package com.bjohnson.rental.utils;

import java.io.Console;
import java.util.List;

/**
 * Utility class to house common functionality for interacting with user input via Console.
 */
public class ConsoleUtils {
    private ConsoleUtils() {
    }

    /**
     * Capture one of a list of options by prompting the user to select it by index.
     *
     * @param console An open Console to capture user input.
     * @param options The options to select from.
     * @return The selected option or null if the user input was not valid.
     */
    public static String captureOptionByIndex(Console console, List<String> options) {
        for (int index = 0; index < options.size(); index++) {
            int number = index + 1;
            System.out.println("\t" + number + ") " + options.get(index));
        }

        System.out.print("Please enter the number corresponding to your selection: ");
        int selection = ConsoleUtils.nextIntOrDefault(console, -1);
        int selectedIndex = --selection;
        if (selectedIndex >= 0 && selectedIndex < options.size()) {
            return options.get(selectedIndex);
        } else {
            System.out.println("Invalid selection made.");
            return null;
        }
    }

    /**
     * Provides the next integer provided by the user, or a default value on an input mismatch exception.
     *
     * @param console      An open Console to capture user input.
     * @param defaultValue The int value to return if a valid integer was not entered by the user.
     * @return integer provided by the user or the default value specified.
     */
    public static int nextIntOrDefault(Console console, int defaultValue) {
        try {
            String input = console.readLine();
            return Integer.parseInt(input, 10);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
