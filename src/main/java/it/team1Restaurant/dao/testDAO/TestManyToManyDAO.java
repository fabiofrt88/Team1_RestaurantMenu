package it.team1Restaurant.dao.testDAO;

import it.team1Restaurant.dao.mtm.*;

public class TestManyToManyDAO {

    public static void main(String[] args) {

        MenuDishDAO menuDishDAO = new MenuDishDAO();
        MenuDrinkDAO menuDrinkDAO = new MenuDrinkDAO();

        IngredientDishDAO ingredientDishDAO = new IngredientDishDAO();
        IngredientDrinkDAO ingredientDrinkDAO = new IngredientDrinkDAO();

        TypeFoodDishDAO typeFoodDishDAO = new TypeFoodDishDAO();
        TypeFoodDrinkDAO typeFoodDrinkDAO = new TypeFoodDrinkDAO();
        TypeFoodClientDAO typeFoodClientDAO = new TypeFoodClientDAO();

        menuDishDAO.createTable();
        menuDrinkDAO.createTable();

        ingredientDishDAO.createTable();
        ingredientDrinkDAO.createTable();

        typeFoodDishDAO.createTable();
        typeFoodDrinkDAO.createTable();
        typeFoodClientDAO.createTable();

    }

}
