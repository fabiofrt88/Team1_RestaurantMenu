package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeDishClientEnum;

import java.util.EnumSet;
import java.util.List;

/**
 * Questa classe rappresenta un Drink, è una sottoclasse di food.
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
//todo javadoc
public class Drink extends Food {

    private double alcoholPercentage;

    public Drink(String name, double price) {
        super(TypeFoodEnum.DRINK, name, price);
    }

    public Drink(String name, double price, EnumSet<TypeDishClientEnum> typeSet) {
        super(TypeFoodEnum.DRINK, name, price, typeSet);
    }

    public Drink (String name, List<Ingredient> ingredients, double price) {
        super(TypeFoodEnum.DRINK, name, ingredients, price);
    }

    public Drink (String name, List<Ingredient> ingredients, double price, EnumSet<TypeDishClientEnum> typeSet) {
        super(TypeFoodEnum.DRINK, name, ingredients, price, typeSet);
    }

    public double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

    @Override
    public String toString() {
        return "Drink" + super.toString();
    }
}
