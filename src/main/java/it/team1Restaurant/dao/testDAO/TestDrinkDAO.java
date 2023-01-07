package it.team1Restaurant.dao.testDAO;

import it.team1Restaurant.dao.DrinkDAO;
import it.team1Restaurant.foods.Drink;
import it.team1Restaurant.foods.FoodStorageSql;
import it.team1Restaurant.foods.TypeDrinkEnum;

import java.util.List;

public class TestDrinkDAO {
    public static void main(String[] args) throws NoSuchMethodException {

        DrinkDAO drinkDAO = new DrinkDAO();

        drinkDAO.createTable();

        drinkDAO.createViewByTypeDrink(TypeDrinkEnum.WINE);
        drinkDAO.createViewByTypeDrink(TypeDrinkEnum.FRUIT_JUICE);
        drinkDAO.createViewByTypeDrink(TypeDrinkEnum.SOFT_DRINK);
        drinkDAO.createViewByTypeDrink(TypeDrinkEnum.COCKTAIL);
        drinkDAO.createViewByTypeDrink(TypeDrinkEnum.BEER);
        drinkDAO.createViewByTypeDrink(TypeDrinkEnum.LIQUOR);

        List<Drink> drinkList = FoodStorageSql.getDrinkList();
        drinkList.forEach(drinkDAO::insertDrink);

        System.out.println("selectAllDrinksByView wine_drinks\n");
        List<Drink> wineDrinks = drinkDAO.selectAllDrinksByView(TypeDrinkEnum.WINE);
        wineDrinks.forEach(System.out::println);

        System.out.println("\nselectAllDrinks\n");
        List<Drink> drinks = drinkDAO.selectAllDrinks();
        drinks.forEach(System.out::println);

        System.out.println("\nselectDrinkById\n");
        Drink drink = drinkDAO.selectDrinkById(5);
        System.out.println(drink);

    }
}

