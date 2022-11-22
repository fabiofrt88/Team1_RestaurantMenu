package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeDishClient;

import java.util.EnumSet;
import java.util.List;

public interface IFood {

    TypeFood getType();
    String getName();
    List<Ingredient> getIngredientList();
    double getPrice();
    EnumSet<TypeDishClient> getTypeSet();
    String getFoodDetails();

}
