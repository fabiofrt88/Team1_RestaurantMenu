package it.team1Restaurant.dao.testDAO;

import it.team1Restaurant.dao.TypeFoodDAO;
import it.team1Restaurant.menu.TypeFoodEnum;

public class TestTypeFoodDAO {

    public static void main(String[] args) {

        TypeFoodDAO typeFoodDAO = new TypeFoodDAO();

        typeFoodDAO.createTable();

        typeFoodDAO.insertTypeFood(TypeFoodEnum.GENERIC);
        typeFoodDAO.insertTypeFood(TypeFoodEnum.CHILD);
        typeFoodDAO.insertTypeFood(TypeFoodEnum.MEAT);
        typeFoodDAO.insertTypeFood(TypeFoodEnum.FISH);
        typeFoodDAO.insertTypeFood(TypeFoodEnum.VEGAN);
        typeFoodDAO.insertTypeFood(TypeFoodEnum.VEGETARIAN);
        typeFoodDAO.insertTypeFood(TypeFoodEnum.CELIAC);

    }

}
