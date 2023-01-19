package it.team1Restaurant.dao.interfaces;

import it.team1Restaurant.foods.Ingredient;

import java.util.List;

public interface IIngredientDAO {

    void createTableIngredient();
    void insertIngredient(Ingredient ingredient);
    List<Ingredient> selectAllIngredients();
    Ingredient selectIngredientById(Integer id);


}
