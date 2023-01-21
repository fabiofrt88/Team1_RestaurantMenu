package it.team1Restaurant.dao.testDAO;

import it.team1Restaurant.dao.ServiceDAOFactory;
import it.team1Restaurant.exception.DataAccessException;
import it.team1Restaurant.foods.FoodStorageSql;
import it.team1Restaurant.foods.Ingredient;
import it.team1Restaurant.service.IngredientService;
import it.team1Restaurant.service.ServiceEnum;

import java.util.*;

public class TestIngredientDAO {

    public static void main(String[] args) {

        try {

            IngredientService ingredientService = (IngredientService) ServiceDAOFactory.getService(ServiceEnum.INGREDIENT);

            ingredientService.createTable();

            List<Ingredient> ingredients = FoodStorageSql.getIngredientList();
            ingredients.forEach(ingredientService::insertIngredient);

            System.out.println("selectAllIngredients\n");
            List<Ingredient> ingredientList = ingredientService.selectAllIngredients();
            ingredientList.forEach(System.out::println);

            System.out.println("\nselectIngredientById\n");
            Ingredient ingredient = ingredientService.selectIngredientById(1);
            System.out.println(ingredient);

        } catch (DataAccessException | ClassCastException | NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

}
