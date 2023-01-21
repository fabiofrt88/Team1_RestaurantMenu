package it.team1Restaurant.controller;

import com.google.gson.GsonBuilder;
import it.team1Restaurant.dao.ServiceDAOFactory;
import it.team1Restaurant.foods.Ingredient;
import it.team1Restaurant.service.IngredientService;
import spark.Request;
import spark.Response;

import java.util.List;

public class IngredientController {

    private static IngredientService ingredientService = ServiceDAOFactory.getIngredientService();

    public static String getAllIngredients(Request request, Response response){
        List<Ingredient> ingredientList = ingredientService.selectAllIngredients();
        return new GsonBuilder().setPrettyPrinting().create().toJson(ingredientList);
    }

    public static String getIngredientById(Request request, Response response){
        Integer id = Integer.parseInt(request.params(":id"));
        Ingredient ingredient = ingredientService.selectIngredientById(id);
        return new GsonBuilder().setPrettyPrinting().create().toJson(ingredient);
    }

}
