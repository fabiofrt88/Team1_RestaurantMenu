package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeDish;

import java.util.EnumSet;
import java.util.List;

public interface IFood {

    TypeFood getType();
    String getName();
    List<Ingredient> getIngredientList();
    double getPrice();
    EnumSet<TypeDish> getTypeSet();
    String getFoodDetails();

}
