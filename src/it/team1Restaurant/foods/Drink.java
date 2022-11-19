package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeDish;

import java.util.EnumSet;
import java.util.List;

public class Drink extends Food {

    private double alcoholPercentage;

    public Drink(String name, double price) {
        super(TypeFood.DRINK, name, price);
    }

    public Drink(String name, double price, EnumSet<TypeDish> typeSet) {
        super(TypeFood.DRINK, name, price, typeSet);
    }

    public Drink (String name, List<Ingredient> ingredients, double price) {
        super(TypeFood.DRINK, name, ingredients, price);
    }

    public Drink (String name, List<Ingredient> ingredients, double price, EnumSet<TypeDish> typeSet) {
        super(TypeFood.DRINK, name, ingredients, price, typeSet);
    }

    public double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }




}
