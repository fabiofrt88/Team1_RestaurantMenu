package it.team1Restaurant.service;

import it.team1Restaurant.dao.IngredientDAO;
import it.team1Restaurant.dao.interfaces.IIngredientDAO;
import it.team1Restaurant.foods.Ingredient;

import java.util.List;

public class IngredientService {

    private IIngredientDAO ingredientDAO;

    public IngredientService(IngredientDAO ingredientDAO){
        this.ingredientDAO = ingredientDAO;
    }

    public void createTableIngredient(){
        ingredientDAO.createTableIngredient();
    }

    public void insertIngredient(Ingredient ingredient){
        ingredientDAO.insertIngredient(ingredient);
    }

    public List<Ingredient> selectAllIngredients(){
        return ingredientDAO.selectAllIngredients();
    }

    public Ingredient selectIngredientById(Integer id){
        return ingredientDAO.selectIngredientById(id);
    }




}
