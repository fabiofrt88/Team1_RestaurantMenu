package it.team1Restaurant.service;

import it.team1Restaurant.dao.interfaces.IIngredientDAO;
import it.team1Restaurant.foods.Ingredient;
import it.team1Restaurant.service.interfaces.IService;

import java.util.List;

public class IngredientService implements IService {

    private IIngredientDAO ingredientDAO;

    public IngredientService(IIngredientDAO ingredientDAO){
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
