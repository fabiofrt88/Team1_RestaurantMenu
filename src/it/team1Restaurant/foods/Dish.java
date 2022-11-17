package it.team1Restaurant.foods;

import java.util.List;

public class Dish extends Food {

    public Dish (TypeFood typeFood, String name, Ingredient ingredient, double price) {
        super(typeFood, name, ingredient, price);
    }

    public Dish (TypeFood typeFood, String name, List<Ingredient> ingredient, double price) {
        super(typeFood, name, ingredient, price);

    }

}
