package it.team1Restaurant.foods;
import it.team1Restaurant.menu.TypeFood;

import java.util.List;

public class Drink extends Food {

    private double alcoholPercentage;

    public Drink (String name, Ingredient ingredient, double price) {
        super(TypeFood.DRINK, name, ingredient, price);
    }


    public Drink (String name, List<Ingredient> ingredient, double price) {
        super(TypeFood.DRINK, name, ingredient, price);

    }

    public double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }
}