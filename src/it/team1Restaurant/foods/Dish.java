package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeDish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dish extends Food {

    public Dish() {
    }

    public Dish(TypeFood typeFood, String name, double price) {
        super(typeFood, name, price);
    }

    public Dish(TypeFood typeFood, String name, Ingredient ingredient, double price) {
        super(typeFood, name, ingredient, price);

    }

    public Dish(TypeFood typeFood, String name, List<Ingredient> ingredient, double price) {
        super(typeFood, name, ingredient, price);
    }

    public Dish(TypeFood typeFood, String name, List<Ingredient> ingredient, double price, TypeDish typeDish) {
        super(typeFood, name, ingredient, price, typeDish);
    }

}
