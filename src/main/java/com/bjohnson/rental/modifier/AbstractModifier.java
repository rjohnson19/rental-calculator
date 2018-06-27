package com.bjohnson.rental.modifier;

import com.bjohnson.rental.utils.ConsoleUtils;

import java.io.Console;
import java.time.DayOfWeek;
import java.util.List;

public abstract class AbstractModifier implements Modifier {
    private String description;
    private List<String> options;
    private String selectedOption;

    public AbstractModifier(String description, List<String> options) {
        this.description = description;
        this.options = options;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public List<String> getOptions(DayOfWeek dayOfWeek) {
        return options;
    }

    @Override
    public void setSelectedOption(String option) {
        this.selectedOption = option;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    @Override
    public void captureSelection(Console console, DayOfWeek dayOfWeek) {
        List<String> options = getOptions(dayOfWeek);
        if (options.size() == 1) {
            // only a single option so we auto select it
            this.setSelectedOption(options.get(0));
        } else {
            while (getSelectedOption() == null) {
                System.out.println(getDescription());
                this.setSelectedOption(ConsoleUtils.captureOptionByIndex(console, options));
            }
        }
    }
}
