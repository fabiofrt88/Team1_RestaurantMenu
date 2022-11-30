package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeDishClientEnum;

import java.util.EnumSet;
import java.util.List;

//todo add javadoc
public class Dish extends Food {

    public Dish(TypeFoodEnum typeFood, String name, double price) {
        super(typeFood, name, price);
    }

    public Dish(TypeFoodEnum typeFood, String name, double price, EnumSet<TypeDishClientEnum> typeSet) {
        super(typeFood, name, price, typeSet);
    }

    public Dish(TypeFoodEnum typeFood, String name, List<Ingredient> ingredients, double price) {
        super(typeFood, name, ingredients, price);
    }

    public Dish(TypeFoodEnum typeFood, String name, List<Ingredient> ingredients, double price, EnumSet<TypeDishClientEnum> typeSet) {
        super(typeFood, name, ingredients, price, typeSet);
    }

    @Override
    public String toString() {
        return "Dish" + super.toString();
    }

}
