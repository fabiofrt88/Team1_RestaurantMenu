package it.team1Restaurant.dao.testDAO;

import it.team1Restaurant.dao.TypeDrinkDAO;
import it.team1Restaurant.foods.TypeDrinkEnum;

public class TestTypeDrinkDAO {

    public static void main(String[] args) {

        TypeDrinkDAO typeDrinkDAO = new TypeDrinkDAO();

        typeDrinkDAO.createTable();

        typeDrinkDAO.insertTypeDrink(TypeDrinkEnum.WINE);
        typeDrinkDAO.insertTypeDrink(TypeDrinkEnum.FRUIT_JUICE);
        typeDrinkDAO.insertTypeDrink(TypeDrinkEnum.SOFT_DRINK);
        typeDrinkDAO.insertTypeDrink(TypeDrinkEnum.COCKTAIL);
        typeDrinkDAO.insertTypeDrink(TypeDrinkEnum.BEER);
        typeDrinkDAO.insertTypeDrink(TypeDrinkEnum.LIQUOR);

    }
}
