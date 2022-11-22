package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeDishClient;

import java.util.EnumSet;
import java.util.List;

public class Dish extends Food {

    public Dish(TypeFood typeFood, String name, double price) {
        super(typeFood, name, price);
    }

    public Dish(TypeFood typeFood, String name, double price, EnumSet<TypeDishClient> typeSet) {
        super(typeFood, name, price, typeSet);
    }

    public Dish(TypeFood typeFood, String name, List<Ingredient> ingredients, double price) {
        super(typeFood, name, ingredients, price);
    }

    public Dish(TypeFood typeFood, String name, List<Ingredient> ingredients, double price, EnumSet<TypeDishClient> typeSet) {
        super(typeFood, name, ingredients, price, typeSet);
    }

    @Override
    public String toString() {
        return "Dish" + super.toString();
    }

}
