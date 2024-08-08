package com.gmail.lampbussinessextra.Classes;

import com.gmail.lampbussinessextra.Classes.Enum.BrewType;
import com.gmail.lampbussinessextra.Classes.Enum.CoffeeType;
import com.gmail.lampbussinessextra.Classes.Error.ConstructCoffeeError;

import java.util.Random;

public class Coffee {
    private CoffeeType COFFEE_TYPE;
    private BrewType BREW_TYPE;
    private Double SIZE;

    public static final String CoffeeNameFormat = "%s %s";

    private final Random RANDOM = new Random();
    private final Double[] CoffeeSizeLimitations = {1.0, 20.0};

    private boolean ValidateCoffeeSize(Double size) {
        if (size != null) {
            return (CoffeeSizeLimitations[0] <= size && CoffeeSizeLimitations[1] >= size);
        }

        return false;
    }

    public Coffee(CoffeeType coffee, BrewType brew, Double size) {
        if ((coffee == null) || (brew == null) || !ValidateCoffeeSize(size)) {
            throw new ConstructCoffeeError("Invalid Coffee constructor arguments.");
        }

        this.COFFEE_TYPE = coffee;
        this.BREW_TYPE = brew;
        this.SIZE = size;
    }

    public Coffee() { randomize(); }

    public final void debug() {
        String DebugFormat = String.format(
                "%s\n%s\n%s\n%s\n%s",
                getCoffeeType(),
                getBrewType(),
                getFormattedName(),
                getSize(),
                CoffeeNameFormat
        );
        System.out.println(DebugFormat);
    }

    public final void randomize() {
        CoffeeType[] CoffeeTypes = CoffeeType.values();
        BrewType[] BrewTypes = BrewType.values();

        this.COFFEE_TYPE = CoffeeTypes[RANDOM.nextInt(0, CoffeeTypes.length)];
        this.BREW_TYPE = BrewTypes[RANDOM.nextInt(0, BrewTypes.length)];
        this.SIZE = RANDOM.nextDouble(CoffeeSizeLimitations[0], CoffeeSizeLimitations[1]);
    }

    public final String getFormattedName() {
        return String.format(CoffeeNameFormat, this.BREW_TYPE, this.COFFEE_TYPE);
    }

    // the comment below is of *up*most significance
    //                          ^ oxymoron spotted
    // what the heck should coffee do when brewed???
    public final void brew() {}

    public final CoffeeType getCoffeeType() { return COFFEE_TYPE; }
    public final BrewType getBrewType() { return BREW_TYPE; }
    public final Double getSize() { return SIZE; }
}