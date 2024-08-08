import com.gmail.lampbussinessextra.Classes.*;
import com.gmail.lampbussinessextra.Classes.Enum.BrewType;
import com.gmail.lampbussinessextra.Classes.Enum.CoffeeType;

public class Main {
    public static void main(String[] args) {
        Coffee LampsCoffee = new Coffee(
                CoffeeType.BLACK,
                BrewType.FRENCH_PRESS,
                1.0
        );
        LampsCoffee.debug();

        Coffee RandomCoffee = new Coffee();
        RandomCoffee.debug();
    }
}