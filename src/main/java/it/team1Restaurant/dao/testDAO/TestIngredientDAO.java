package it.team1Restaurant.dao.testDAO;

import it.team1Restaurant.dao.IngredientDAO;
import it.team1Restaurant.foods.FoodStorage;
import it.team1Restaurant.foods.Ingredient;

import java.util.*;

public class TestIngredientDAO {

    public static void main(String[] args) {

        IngredientDAO ingredientDAO = new IngredientDAO();

        ingredientDAO.createTable();

        List<Ingredient> ingredients = FoodStorage.getIngredientList();
        ingredients.forEach(ingredientDAO::insertIngredient);

        System.out.println("selectAllIngredients\n");
        List<Ingredient> ingredientList = ingredientDAO.selectAllIngredients();
        ingredientList.forEach(System.out::println);

        System.out.println("\nselectIngredientById\n");
        Ingredient ingredient = ingredientDAO.selectIngredientById(1);
        System.out.println(ingredient);

    }

}
